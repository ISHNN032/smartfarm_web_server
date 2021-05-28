package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataWindS;
import com.livesoft.smartfarm.models.simples.DataWindSSimple;
import com.livesoft.smartfarm.models.values.DataWindSValue;
import com.livesoft.smartfarm.repositories.DataWindSRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataWindSService {
	private final DataWindSRepository datawindsRepository;

	public DataWindSSimple findById(Long id) {
		return datawindsRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(DataWindSValue value) {
		DataWindS dataWindS = DataWindS.builder().state(value.getState()).value(value.getValue()).build();
		datawindsRepository.save(dataWindS); // user
	}

	@Transactional
	public void patch(DataWindS dataWindS, DataWindSValue value) {
		if (StringUtils.isNotBlank(Integer.toString(value.getState())))
			dataWindS.setState(value.getState());
		if (StringUtils.isNotBlank(Float.toString(value.getValue())))
			dataWindS.setValue(value.getValue());
	}

	@Transactional
	public void delete(DataWindS dataWindS) {
		// DataWindS.setDel(true);
		datawindsRepository.delete(dataWindS);
	}

	public List<DataWindS> findAll(Pageable pageable) {
		return datawindsRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
