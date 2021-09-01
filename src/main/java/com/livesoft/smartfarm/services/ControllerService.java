package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.Controller;
import com.livesoft.smartfarm.models.simples.ControllerSimple;
import com.livesoft.smartfarm.models.values.ControllerValue;
import com.livesoft.smartfarm.repositories.ControllerRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ControllerService {

	private final ControllerRepository controllerRepository;

	public ControllerSimple findById(Long id) {
		return controllerRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(ControllerValue value) {
		Controller controller = Controller.builder().farmId(value.getFarmId()).name(value.getName()).build(); // ->
		controllerRepository.save(controller); // user
	}

	@Transactional
	public void patch(Controller controller, ControllerValue value) {
		if (StringUtils.isNotBlank(Long.toString(value.getFarmId())))
			controller.setFarmId(value.getFarmId());
		if (StringUtils.isNotBlank(value.getName()))
			controller.setName(value.getName());
	}

	@Transactional
	public void delete(Controller controller) {
		// controller.setDel(true);
		controllerRepository.delete(controller);
	}

	public List<Controller> findAll(Pageable pageable) {
		return controllerRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
