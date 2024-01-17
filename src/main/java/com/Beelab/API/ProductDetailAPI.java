package com.Beelab.API;

import com.Beelab.Entity.ProductDetail;
import com.Beelab.Service.ProductDetailServ;
import com.Beelab.dto.productdto.CreateProductDetailDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/product-detail")
public class ProductDetailAPI {
    @Autowired
    ProductDetailServ pddao;

    @PostMapping("create")
    @Secured("PRODUCT_MANAGEMENT")
    public ResponseEntity<ProductDetail> create(@RequestBody CreateProductDetailDto createProductDetailDto){
        return ResponseEntity.ok(pddao.createProductDetail(createProductDetailDto).get());
    }

    @GetMapping("{id}")
    @Secured("PRODUCT_MANAGEMENT")
    public ResponseEntity<List<ProductDetail>> getProductDetailByProductId(@PathVariable Integer id){
     return ResponseEntity.ok(pddao.getProductDetailByProductId(id).orThrow());
    }

}
