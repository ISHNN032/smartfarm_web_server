package com.livesoft.smartfarm.controllers.views;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.livesoft.smartfarm.models.entities.SensorData;
import com.livesoft.smartfarm.services.SensorDataService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class VSensorDataController {
	private final SensorDataService sdataService;

	@GetMapping("/api/sdatas")
	public List<SensorData> selectSDatas(Model model,
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		return sdataService.findAll(pageable);
	}
}
