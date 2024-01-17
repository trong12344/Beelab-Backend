package com.Beelab.Imp;

import java.util.Collection;
import java.util.Optional;

import com.Beelab.DAO.ProductDetailDAO;
import com.Beelab.Entity.ProductDetail;
import com.Beelab.config.ICurrentUserService;
import com.Beelab.dto.cartDto.AddToCartDto;
import com.Beelab.dto.cartDto.updateCartDto;
import com.Beelab.Common.HandleResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.CartDAO;
import com.Beelab.Entity.Cart;
import com.Beelab.Service.CartService;
import org.springframework.web.server.ResponseStatusException;


@Service
@AllArgsConstructor
public class CartServiceImpl implements CartService {
	@Autowired
	CartDAO cartDAO;
	@Autowired
	ProductDetailDAO productDetailDAO;
	private final ICurrentUserService currentUserService;

	@Override
	public HandleResponse<Cart> addToCart(AddToCartDto addToCartDto) {
		Optional<ProductDetail> productDetail = productDetailDAO.findById(addToCartDto.getProductDetailId());
		if (productDetail.isEmpty()){
			return HandleResponse.error("Sản phẩm không tồn tại");
		}
		if(productDetail.get().getQuantity() < addToCartDto.getQuantity()){
			return HandleResponse.error("Số lượng không đủ");
		}
		Optional<Integer> currentUserId = currentUserService.getCurrentUserId();
		if (currentUserId.isEmpty()) {
			return HandleResponse.error("Bạn chưa đăng nhập");
		}
		Cart cart = Cart.builder().user_id(currentUserId.get())
				.ProductDetail(productDetail.get())
				.user_id(currentUserId.get())
				.quantity(addToCartDto.getQuantity())
				.build();
		cartDAO.save(cart);
		return HandleResponse.ok(cart);
	}

	@Override
	public HandleResponse<Void> removeItemInCart(Integer ProductId) {
		Optional<Integer> currentUserId = currentUserService.getCurrentUserId();
		if (currentUserId.isEmpty()) {
			return HandleResponse.error("Bạn chưa đăng nhập");
		}
		Optional<Cart> cart = cartDAO.findByUserIdAndProductOptionId(currentUserId.get(), ProductId);
		if (cart.isEmpty()){
			return HandleResponse.error("Không tìm thấy sản phẩm trong giỏ hàng");

		}
		cartDAO.delete(cart.get());
		return HandleResponse.ok();
	}


	@Override
	public HandleResponse<Cart> UpdateCart(updateCartDto updateCartDto) {
		Optional<Integer> currentUserId = currentUserService.getCurrentUserId();
		if (currentUserId.isEmpty()) {
			return HandleResponse.error("Bạn chưa đăng nhập");
		}
		Optional<Cart> cart = cartDAO.findByUserIdAndProductOptionId(currentUserId.get(), updateCartDto.getProductDetailId());
		if (cart.isEmpty()){
			return HandleResponse.error("Sản phẩm không tồn tại trong giỏ hàng");
		}
		int currentStock = cart.get().getProductDetail().getQuantity();
		if (currentStock< updateCartDto.getNewQuantity()){
			return HandleResponse.error("Số lượng không đủ");
		}
		cart.get().setQuantity(updateCartDto.getNewQuantity());
		cartDAO.save(cart.get());
		return HandleResponse.ok(cart.get());
	}


	@Override
	public HandleResponse<Collection<Cart>> getAllCartByUser() {
		var currentUserId = currentUserService.getCurrentUserId();
		if (currentUserId.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Bạn chưa đăng nhập");
		}
		Collection<Cart> carts = cartDAO.findAllByUserId(currentUserId.get());
		return HandleResponse.ok(carts);
	}

	@Override
	public Cart findOneById(int id) {
		return cartDAO .findById(id).get();
	}

}
