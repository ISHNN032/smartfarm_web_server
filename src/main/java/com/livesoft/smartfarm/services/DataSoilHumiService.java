package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataSoilHumi;
import com.livesoft.smartfarm.models.simples.DataSoilHumiSimple;
import com.livesoft.smartfarm.models.values.DataSoilHumiValue;
import com.livesoft.smartfarm.repositories.DataSoilHumiRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataSoilHumiService {
	private final DataSoilHumiRepository datasoilhumiRepository;

	public DataSoilHumiSimple findById(Long id) {
		return datasoilhumiRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(DataSoilHumiValue value) {
		DataSoilHumi dataSoilHumi = DataSoilHumi.builder().state(value.getState()).value(value.getValue()).build();
		datasoilhumiRepository.save(dataSoilHumi); // user
	}

	@Transactional
	public void patch(DataSoilHumi dataSoilHumi, DataSoilHumiValue value) {
		if (StringUtils.isNotBlank(Integer.toString(value.getState())))
			dataSoilHumi.setState(value.getState());
		if (StringUtils.isNotBlank(Float.toString(value.getValue())))
			dataSoilHumi.setValue(value.getValue());
	}

	@Transactional
	public void delete(DataSoilHumi dataSoilHumi) {
		// DataSoilHumi.setDel(true);
		datasoilhumiRepository.delete(dataSoilHumi);
	}

	public List<DataSoilHumi> findAll(Pageable pageable) {
		return datasoilhumiRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
