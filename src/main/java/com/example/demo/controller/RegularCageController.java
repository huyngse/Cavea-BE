package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entities.RegularCage;
import com.example.demo.Service.RegularCageService;

@RestController
@RequestMapping("/product")
public class RegularCageController {
	@Autowired
	private RegularCageService regularCageService;
	@GetMapping("/all")
	public List<RegularCage> getAllRegularCage() {
		return regularCageService.getRegularCageList();
	}
	@GetMapping("/detail")
	public RegularCage getRegularCageById(int cageId) {
		return regularCageService.getRegularCageById(cageId);
	}
}
