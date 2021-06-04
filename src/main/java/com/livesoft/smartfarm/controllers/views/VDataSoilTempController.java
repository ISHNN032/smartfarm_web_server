package com.livesoft.smartfarm.controllers.views;

import java.util.List;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataSoilTemp;
import com.livesoft.smartfarm.services.DataSoilTempService;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class VDataSoilTempController {
	private final DataSoilTempService datasoiltempService;

	@GetMapping("/api/soilt")
	public List<DataSoilTemp> selectSDatas(Model model,
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		return datasoiltempService.findAll(pageable);
	}
}
