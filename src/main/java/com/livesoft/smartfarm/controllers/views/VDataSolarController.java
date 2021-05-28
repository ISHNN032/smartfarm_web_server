package com.livesoft.smartfarm.controllers.views;

import java.util.List;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataSolar;
import com.livesoft.smartfarm.services.DataSolarService;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class VDataSolarController {
	private final DataSolarService datasolarService;

	@GetMapping("/api/solar")
	public List<DataSolar> selectSDatas(Model model,
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		return datasolarService.findAll(pageable);
	}
}
