package com.livesoft.smartfarm.controllers.views;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livesoft.smartfarm.services.ControllerService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/v/controllers")
@RequiredArgsConstructor
@Controller
public class VControllerController {

	private final ControllerService controllerService;

	@GetMapping("")
	public String selectControllers(Model model,
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("controllers", controllerService.findAll(pageable));
		model.addAttribute("currentPage", "controller");
		return "content/controller";
	}

}
