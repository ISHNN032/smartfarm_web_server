package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataSoilTemp;

@RepositoryRestResource
@Repository
public interface DataSoilTempRepository extends JpaRepository<DataSoilTemp, Long> {

	Optional<List<DataSoilTemp>> findAllByDel(boolean del);

	Optional<DataSoilTemp> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<DataSoilTemp> findByIdAndUserIdAndDel(long datatempId, long userId,
	// boolean
	// del);

	// Optional<List<DataSoilTemp>> findAllByUserIdAndDel(long userId, boolean del);

	List<DataSoilTemp> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
