package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataSolar;

@RepositoryRestResource
@Repository
public interface DataSolarRepository extends JpaRepository<DataSolar, Long> {

	Optional<List<DataSolar>> findAllByDel(boolean del);

	Optional<DataSolar> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<DataSolar> findByIdAndUserIdAndDel(long datatempId, long userId,
	// boolean
	// del);

	// Optional<List<DataSolar>> findAllByUserIdAndDel(long userId, boolean del);

	List<DataSolar> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
