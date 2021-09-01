package com.livesoft.smartfarm.mapper;

import java.util.Optional;

import com.livesoft.smartfarm.models.entities.Farm;

public interface FarmMapper {
	
	public Optional<Farm> findById(long id);
}