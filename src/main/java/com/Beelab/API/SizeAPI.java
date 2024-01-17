package com.Beelab.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Beelab.Entity.Size;
import com.Beelab.Service.SizeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/size")
public class SizeAPI {
    @Autowired
    SizeService sizeService;

    @GetMapping
    public List<Size> getListSize() {
        return sizeService.getListSize();
    }

    @GetMapping("/{id}")
    public Size getSizeById(@PathVariable int id) {
        return sizeService.findOneById(id);
    }

    @GetMapping("/ten/{name}")
    public ResponseEntity<Size> getSizeByName(@PathVariable String name) {
        List<Size> sizes = sizeService.findByName(name);
        if (!sizes.isEmpty()) {
            Size size = sizes.get(0);
            return ResponseEntity.ok(size);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Size createSize(@RequestBody Size size) {
        return sizeService.createSize(size);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateSize(@PathVariable Long id, @RequestBody Size updatedSize) {
        Size existingSize = sizeService.findOneById(updatedSize.getId());
        if (existingSize != null) {
            existingSize.setName(updatedSize.getName());
            existingSize.setDescription(updatedSize.getDescription());
            existingSize.setStatus(updatedSize.getStatus());
            sizeService.updateSize(existingSize);
            return new ResponseEntity<>("Update size thành công ", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Size không tìm thấy", HttpStatus.NOT_FOUND);
        }
    }

}