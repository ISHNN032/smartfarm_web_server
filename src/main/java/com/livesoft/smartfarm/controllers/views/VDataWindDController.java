package com.livesoft.smartfarm.controllers.views;

import java.util.List;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataWindD;
import com.livesoft.smartfarm.services.DataWindDService;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class VDataWindDController {
	private final DataWindDService datawinddService;

	@GetMapping("/api/windd")
	public List<DataWindD> selectSDatas(Model model,
			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		return datawinddService.findAll(pageable);
	}
}
