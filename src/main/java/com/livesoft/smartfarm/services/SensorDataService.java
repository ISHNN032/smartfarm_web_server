package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.SensorData;
import com.livesoft.smartfarm.models.simples.SensorDataSimple;
import com.livesoft.smartfarm.models.values.SensorDataValue;
import com.livesoft.smartfarm.repositories.SensorDataRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SensorDataService {

	private final SensorDataRepository sdataRepository;

	public SensorDataSimple findById(Long id) {
		return sdataRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(SensorDataValue value) {
		SensorData sdata = SensorData.builder().sensorId(value.getSensorId()).state(value.getState()).value(value.getValue()).build();
		sdataRepository.save(sdata); // user
	}

	@Transactional
	public void patch(SensorData sdata, SensorDataValue value) {
		if (StringUtils.isNotBlank(Long.toString(value.getSensorId())))
			sdata.setSensorId(value.getSensorId());
		if (StringUtils.isNotBlank(Integer.toString(value.getState())))
			sdata.setState(value.getState());
		if (StringUtils.isNotBlank(Float.toString(value.getValue())))
			sdata.setValue(value.getValue());
	}

	@Transactional
	public void delete(SensorData sdata) {
		// sdata.setDel(true);
		sdataRepository.delete(sdata);
	}

	public List<SensorData> findAll(Pageable pageable) {
		return sdataRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
