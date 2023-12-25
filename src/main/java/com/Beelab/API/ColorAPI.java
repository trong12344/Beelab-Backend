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

import com.Beelab.Entity.Color;
import com.Beelab.Service.ColorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/color")
public class ColorAPI {
	@Autowired
	ColorService colorservice;

	@GetMapping
	public List<Color> getListColor() {
		return colorservice.getListColor();
	}

	@GetMapping("/{id}")
	public Color getColorById(@PathVariable int id) {
		return colorservice.findOneById(id);
	}

	@PostMapping
	public Color createColor(@RequestBody Color color) {
		return colorservice.createColor(color);
	}

	@PutMapping("/{id}")
	public Color updateColor(@PathVariable int id, @RequestBody Color color) {
		color.setId(id);
		return colorservice.updateColor(color);
	}
}
