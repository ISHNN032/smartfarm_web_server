package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.livesoft.smartfarm.models.entities.Sensor;

@RepositoryRestResource
@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

	Optional<List<Sensor>> findAllByDel(boolean del);

	Optional<Sensor> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<Sensor> findByIdAndUserIdAndDel(long sensorId, long userId, boolean
	// del);

	// Optional<List<Sensor>> findAllByUserIdAndDel(long userId, boolean del);

	List<Sensor> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
