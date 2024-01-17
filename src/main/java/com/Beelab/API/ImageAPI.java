package com.Beelab.API;

import com.Beelab.Entity.ProductImage;
import com.Beelab.Service.ImageService;
import com.Beelab.dto.productdto.createImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/image")
public class ImageAPI {
    @Autowired
    ImageService idao;

    @PostMapping("create")
    public ResponseEntity<ProductImage> createImage(@RequestBody createImageDto createImageDto){
        return ResponseEntity.ok(idao.create(createImageDto).get());
    }

}
