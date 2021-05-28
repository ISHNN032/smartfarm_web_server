package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataHumi;
import com.livesoft.smartfarm.models.simples.DataHumiSimple;
import com.livesoft.smartfarm.models.values.DataHumiValue;
import com.livesoft.smartfarm.repositories.DataHumiRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataHumiService {
	private final DataHumiRepository datahumiRepository;

	public DataHumiSimple findById(Long id) {
		return datahumiRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(DataHumiValue value) {
		DataHumi dataHumi = DataHumi.builder().state(value.getState()).value(value.getValue()).build();
		datahumiRepository.save(dataHumi); // user
	}

	@Transactional
	public void patch(DataHumi dataHumi, DataHumiValue value) {
		if (StringUtils.isNotBlank(Integer.toString(value.getState())))
			dataHumi.setState(value.getState());
		if (StringUtils.isNotBlank(Float.toString(value.getValue())))
			dataHumi.setValue(value.getValue());
	}

	@Transactional
	public void delete(DataHumi dataHumi) {
		// DataHumi.setDel(true);
		datahumiRepository.delete(dataHumi);
	}

	public List<DataHumi> findAll(Pageable pageable) {
		return datahumiRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
