package com.Beelab.API;

import com.Beelab.Entity.ProductDetail;
import com.Beelab.Entity.ProductImage;
import com.Beelab.Imp.ImageServiceImpl;
import com.Beelab.Service.ImageService;
import com.Beelab.Service.ProductDetailServ;
import com.Beelab.dto.CreateProductDetailDto;
import com.Beelab.dto.createImageDto;
import com.shop.clothing.common.Cqrs.HandleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/product-detail")
public class ProductDetailAPI {
    @Autowired
    ProductDetailServ pddao;

    @Autowired
    ImageService idao;

    @PostMapping("create")
    public ResponseEntity<ProductDetail> create(@RequestBody CreateProductDetailDto createProductDetailDto){
        return ResponseEntity.ok(pddao.createProductDetail(createProductDetailDto).get());
    }

    @PostMapping("create-image")
    public ResponseEntity<ProductImage> createImage(@RequestBody createImageDto createImageDto){
        return ResponseEntity.ok(idao.create(createImageDto).get());
    }

    @GetMapping("get-image/{id}")
    public ResponseEntity<List<ProductImage>> getAll(@PathVariable Integer id){
        return ResponseEntity.ok(idao.getImageByProductId(id).get()).;
    }
}
