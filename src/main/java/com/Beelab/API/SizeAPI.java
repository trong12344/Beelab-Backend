package com.Beelab.API;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	    private SizeService sizeService;

	    @GetMapping
	    public List<Size> getListSize() {
	        return sizeService.getListSize();
	    }

	    @GetMapping("/{id}")
	    public Size getSizeById(@PathVariable int id) {
	        return sizeService.findOneById(id);
	    }

	    @GetMapping("/name/{name}")
	    public Size getSizeByName(@PathVariable String name) {
	        return sizeService.findOneByName(name);
	    }

	    @PostMapping
	    public Size createSize(@RequestBody Size size) {
	        return sizeService.createSize(size);
	    }

	    @PutMapping("/{id}")
	    public Size updateSize(@PathVariable int id, @RequestBody Size size) {
	        return sizeService.updateSize(id, size);
	    }
}
