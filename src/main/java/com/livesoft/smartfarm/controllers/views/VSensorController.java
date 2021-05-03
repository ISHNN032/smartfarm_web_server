package com.livesoft.smartfarm.controllers.views;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.livesoft.smartfarm.services.SensorService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/#/sensors")
@RequiredArgsConstructor
@Controller
public class VSensorController {

	private final SensorService sensorService;

	@GetMapping("")
	public String selectSensors(Model model,
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		model.addAttribute("sensors", sensorService.findAll(pageable));
		model.addAttribute("currentPage", "sensor");
		return "content/sensor";
	}

}
