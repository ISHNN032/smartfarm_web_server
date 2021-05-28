package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataSolar;
import com.livesoft.smartfarm.models.simples.DataSolarSimple;
import com.livesoft.smartfarm.models.values.DataSolarValue;
import com.livesoft.smartfarm.repositories.DataSolarRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataSolarService {
	private final DataSolarRepository datasolarRepository;

	public DataSolarSimple findById(Long id) {
		return datasolarRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(DataSolarValue value) {
		DataSolar dataSolar = DataSolar.builder().state(value.getState()).value(value.getValue()).build();
		datasolarRepository.save(dataSolar); // user
	}

	@Transactional
	public void patch(DataSolar dataSolar, DataSolarValue value) {
		if (StringUtils.isNotBlank(Integer.toString(value.getState())))
			dataSolar.setState(value.getState());
		if (StringUtils.isNotBlank(Float.toString(value.getValue())))
			dataSolar.setValue(value.getValue());
	}

	@Transactional
	public void delete(DataSolar dataSolar) {
		// DataSolar.setDel(true);
		datasolarRepository.delete(dataSolar);
	}

	public List<DataSolar> findAll(Pageable pageable) {
		return datasolarRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
