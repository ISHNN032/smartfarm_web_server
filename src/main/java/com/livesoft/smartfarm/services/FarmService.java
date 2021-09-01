package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.Farm;
import com.livesoft.smartfarm.models.simples.FarmSimple;
import com.livesoft.smartfarm.models.values.FarmValue;
import com.livesoft.smartfarm.repositories.FarmRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FarmService {

	private final FarmRepository farmRepository;
	
	public FarmSimple findById(Long id) {
		return farmRepository.findById(id).orElse(null).getSimple();
	}
	
	@Transactional
	public void save(FarmValue value) {
		Farm farm = Farm.builder()
				.name(value.getName())
				.farmBusiness(value.getFarmBusiness()).build();		// FIXME userId -> user 
		farmRepository.save(farm);
	}
	
	@Transactional
	public void patch(Farm farm, FarmValue value) {
		if(StringUtils.isNotBlank(value.getName()))
			farm.setName(value.getName());
		if(StringUtils.isNotBlank(value.getFarmBusiness()))
			farm.setFarmBusiness(value.getFarmBusiness());
		// user
	}

	@Transactional
	public void delete(Farm farm) {
//		farm.setDel(true);
		farmRepository.delete(farm);
	}

	public List<Farm> findAll(Pageable pageable) {
		return farmRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
