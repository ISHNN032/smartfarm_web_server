package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataSoilHumi;

@RepositoryRestResource
@Repository
public interface DataSoilHumiRepository extends JpaRepository<DataSoilHumi, Long> {

	Optional<List<DataSoilHumi>> findAllByDel(boolean del);

	Optional<DataSoilHumi> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<DataSoilHumi> findByIdAndUserIdAndDel(long datatempId, long userId,
	// boolean
	// del);

	// Optional<List<DataSoilHumi>> findAllByUserIdAndDel(long userId, boolean del);

	List<DataSoilHumi> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
