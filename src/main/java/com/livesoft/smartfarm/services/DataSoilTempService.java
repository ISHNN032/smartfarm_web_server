package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataSoilTemp;
import com.livesoft.smartfarm.models.simples.DataSoilTempSimple;
import com.livesoft.smartfarm.models.values.DataSoilTempValue;
import com.livesoft.smartfarm.repositories.DataSoilTempRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataSoilTempService {
	private final DataSoilTempRepository datasoiltempRepository;

	public DataSoilTempSimple findById(Long id) {
		return datasoiltempRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(DataSoilTempValue value) {
		DataSoilTemp dataSoilTemp = DataSoilTemp.builder().state(value.getState()).value(value.getValue()).build();
		datasoiltempRepository.save(dataSoilTemp); // user
	}

	@Transactional
	public void patch(DataSoilTemp dataSoilTemp, DataSoilTempValue value) {
		if (StringUtils.isNotBlank(Integer.toString(value.getState())))
			dataSoilTemp.setState(value.getState());
		if (StringUtils.isNotBlank(Float.toString(value.getValue())))
			dataSoilTemp.setValue(value.getValue());
	}

	@Transactional
	public void delete(DataSoilTemp dataSoilTemp) {
		// DataSoilTemp.setDel(true);
		datasoiltempRepository.delete(dataSoilTemp);
	}

	public List<DataSoilTemp> findAll(Pageable pageable) {
		return datasoiltempRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
