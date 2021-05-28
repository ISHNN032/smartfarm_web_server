package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.livesoft.smartfarm.models.entities.SensorDatas.DataHumi;

@RepositoryRestResource
@Repository
public interface DataHumiRepository extends JpaRepository<DataHumi, Long> {

	Optional<List<DataHumi>> findAllByDel(boolean del);

	Optional<DataHumi> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<DataHumi> findByIdAndUserIdAndDel(long datatempId, long userId,
	// boolean
	// del);

	// Optional<List<DataHumi>> findAllByUserIdAndDel(long userId, boolean del);

	List<DataHumi> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
