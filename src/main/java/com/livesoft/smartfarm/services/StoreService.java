package com.livesoft.smartfarm.services;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.Store;
import com.livesoft.smartfarm.models.simples.StoreSimple;
import com.livesoft.smartfarm.models.values.StoreValue;
import com.livesoft.smartfarm.repositories.StoreRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class StoreService {

	private final StoreRepository storeRepository;
	
	public StoreSimple findById(Long id) {
		return storeRepository.findById(id).orElse(null).getSimple();
	}
	
	@Transactional
	public void save(StoreValue value) {
		Store store = Store.builder()
				.name(value.getName())
				.storeBusiness(value.getStoreBusiness()).build();		// FIXME userId -> user 
		storeRepository.save(store);
	}
	
	@Transactional
	public void patch(Store store, StoreValue value) {
		if(StringUtils.isNotBlank(value.getName()))
			store.setName(value.getName());
		if(StringUtils.isNotBlank(value.getStoreBusiness()))
			store.setStoreBusiness(value.getStoreBusiness());
		// user
	}

	@Transactional
	public void delete(Store store) {
//		store.setDel(true);
		storeRepository.delete(store);
	}

	public List<Store> findAll(Pageable pageable) {
		return storeRepository.findAllByDelOrderByIdDesc(false, pageable);
	}
}
