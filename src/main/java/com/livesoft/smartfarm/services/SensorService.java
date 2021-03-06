package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.Sensor;
import com.livesoft.smartfarm.models.simples.SensorSimple;
import com.livesoft.smartfarm.models.values.SensorValue;
import com.livesoft.smartfarm.repositories.SensorRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SensorService {

	private final SensorRepository sensorRepository;

	public SensorSimple findById(Long id) {
		return sensorRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(SensorValue value) {
		Sensor sensor = Sensor.builder().contId(value.getContId()).name(value.getName()).build(); // ->
		sensorRepository.save(sensor); // user
	}

	@Transactional
	public void patch(Sensor sensor, SensorValue value) {
		if (StringUtils.isNotBlank(Long.toString(value.getContId())))
			sensor.setContId(value.getContId());
		if (StringUtils.isNotBlank(value.getName()))
			sensor.setName(value.getName());
	}

	@Transactional
	public void delete(Sensor sensor) {
		// sensor.setDel(true);
		sensorRepository.delete(sensor);
	}

	public List<Sensor> findAll(Pageable pageable) {
		return sensorRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
