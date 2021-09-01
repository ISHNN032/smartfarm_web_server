package com.livesoft.smartfarm.controllers.views;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livesoft.smartfarm.services.FarmService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/v/farms")
@RequiredArgsConstructor
@Controller
public class VFarmController {
	
	private final FarmService farmService;
	
	@GetMapping("")
	public String selectStores(Model model, @PageableDefault(page=0, size=5, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("farms", farmService.findAll(pageable));
		model.addAttribute("currentPage", "farm");
		return "content/farm";
	}
	
}
