package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.SData;
import com.livesoft.smartfarm.models.simples.SDataSimple;
import com.livesoft.smartfarm.models.values.SDataValue;
import com.livesoft.smartfarm.repositories.SDataRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SDataService {

	private final SDataRepository sdataRepository;

	public SDataSimple findById(Long id) {
		return sdataRepository.findById(id).orElse(null).getSimple();
	}

	@Transactional
	public void save(SDataValue value) {
		SData sdata = SData.builder().state(value.getState()).value(value.getValue()).build();
		sdataRepository.save(sdata); // user
	}

	@Transactional
	public void patch(SData sdata, SDataValue value) {
		if (StringUtils.isNotBlank(Integer.toString(value.getState())))
			sdata.setState(value.getState());
		if (StringUtils.isNotBlank(Float.toString(value.getValue())))
			sdata.setValue(value.getValue());
	}

	@Transactional
	public void delete(SData sdata) {
		// sdata.setDel(true);
		sdataRepository.delete(sdata);
	}

	public List<SData> findAll(Pageable pageable) {
		return sdataRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
