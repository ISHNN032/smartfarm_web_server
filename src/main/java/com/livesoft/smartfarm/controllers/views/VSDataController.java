package com.livesoft.smartfarm.controllers.views;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livesoft.smartfarm.services.SDataService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/v/sdatas")
@RequiredArgsConstructor
@Controller
public class VSDataController {

	private final SDataService sdataService;

	@GetMapping("")
	public String selectSDatas(Model model,
			@PageableDefault(page = 0, size = 101, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("sdatas", sdataService.findAll(pageable));
		model.addAttribute("currentPage", "sdata");
		return "content/sdata";
	}

}
