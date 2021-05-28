package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataTemp;
import com.livesoft.smartfarm.models.simples.DataTempSimple;
import com.livesoft.smartfarm.models.values.DataTempValue;
import com.livesoft.smartfarm.repositories.DataTempRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataTempService {
	private final DataTempRepository datatempRepository;

	public DataTempSimple findById(Long id) {
		return datatempRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(DataTempValue value) {
		DataTemp dataTemp = DataTemp.builder().state(value.getState()).value(value.getValue()).build();
		datatempRepository.save(dataTemp); // user
	}

	@Transactional
	public void patch(DataTemp dataTemp, DataTempValue value) {
		if (StringUtils.isNotBlank(Integer.toString(value.getState())))
			dataTemp.setState(value.getState());
		if (StringUtils.isNotBlank(Float.toString(value.getValue())))
			dataTemp.setValue(value.getValue());
	}

	@Transactional
	public void delete(DataTemp dataTemp) {
		// DataTemp.setDel(true);
		datatempRepository.delete(dataTemp);
	}

	public List<DataTemp> findAll(Pageable pageable) {
		return datatempRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
