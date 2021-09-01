package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import com.livesoft.smartfarm.models.entities.SensorData;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RepositoryRestResource
@Repository
public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

	Optional<List<SensorData>> findAllByDel(boolean del);

	Optional<SensorData> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<SData> findByIdAndUserIdAndDel(long sdataId, long userId, boolean
	// del);

	// Optional<List<SData>> findAllByUserIdAndDel(long userId, boolean del);

	List<SensorData> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
