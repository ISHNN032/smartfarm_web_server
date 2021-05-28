package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataWindD;
import com.livesoft.smartfarm.models.simples.DataWindDSimple;
import com.livesoft.smartfarm.models.values.DataWindDValue;
import com.livesoft.smartfarm.repositories.DataWindDRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class DataWindDService {
	private final DataWindDRepository datawinddRepository;

	public DataWindDSimple findById(Long id) {
		return datawinddRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(DataWindDValue value) {
		DataWindD dataWindD = DataWindD.builder().state(value.getState()).value(value.getValue()).build();
		datawinddRepository.save(dataWindD); // user
	}

	@Transactional
	public void patch(DataWindD dataWindD, DataWindDValue value) {
		if (StringUtils.isNotBlank(Integer.toString(value.getState())))
			dataWindD.setState(value.getState());
		if (StringUtils.isNotBlank(Float.toString(value.getValue())))
			dataWindD.setValue(value.getValue());
	}

	@Transactional
	public void delete(DataWindD dataWindD) {
		// DataWindD.setDel(true);
		datawinddRepository.delete(dataWindD);
	}

	public List<DataWindD> findAll(Pageable pageable) {
		return datawinddRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
