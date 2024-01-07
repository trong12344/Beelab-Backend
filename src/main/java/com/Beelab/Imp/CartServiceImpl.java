package com.Beelab.Imp;

import java.util.Collection;
import java.util.Optional;

import com.Beelab.DAO.ProductDetailDAO;
import com.Beelab.Entity.ProductDetail;
import com.Beelab.cartDto.AddToCartDto;
import com.Beelab.cartDto.updateCartDto;
import com.shop.clothing.common.Cqrs.HandleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Beelab.DAO.CartDAO;
import com.Beelab.Entity.Cart;
import com.Beelab.Service.CartService;


@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartDAO cartDAO;
	@Autowired
	ProductDetailDAO productDetailDAO;

	@Override
	public HandleResponse<Cart> addToCart(AddToCartDto addToCartDto) {
		Optional<ProductDetail> productDetail = productDetailDAO.findById(addToCartDto.getProductDetailId());
		if (productDetail.isEmpty()){
			return HandleResponse.error("Sản phẩm không tồn tại");
		}
		if(productDetail.get().getQuantity() < addToCartDto.getQuantity()){
			return HandleResponse.error("Số lượng không đủ");
		}
		Cart cart = Cart.builder().user_id(addToCartDto.getUserId())
				.ProductDetail(productDetail.get())
				.quantity(addToCartDto.getQuantity())
				.build();
		cartDAO.save(cart);
		return HandleResponse.ok(cart);
	}

	@Override
	public HandleResponse<Void> removeItemInCart(Integer ProductId) {
		Optional<Cart> cart = cartDAO.findByUserIdAndProductOptionId(1, ProductId);
		if (cart.isEmpty()){
			return HandleResponse.error("Không tìm thấy sản phẩm trong giỏ hàng");

		}
		cartDAO.delete(cart.get());
		return HandleResponse.ok();
	}


	@Override
	public HandleResponse<Cart> UpdateCart(updateCartDto updateCartDto) {
		Optional<Cart> cart = cartDAO.findByUserIdAndProductOptionId(updateCartDto.getUserId(), updateCartDto.getProductDetailId());
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
	public HandleResponse<Collection<Cart>> getAllCartByUser(Integer userId) {
		Collection<Cart> carts = cartDAO.findAllByUserId(userId);
		return HandleResponse.ok(carts);
	}

	@Override
	public Cart findOneById(int id) {
		return cartDAO .findById(id).get();
	}

}
