package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.livesoft.smartfarm.models.entities.SensorDatas.DataTemp;

@RepositoryRestResource
@Repository
public interface DataTempRepository extends JpaRepository<DataTemp, Long> {

	Optional<List<DataTemp>> findAllByDel(boolean del);

	Optional<DataTemp> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<DataTemp> findByIdAndUserIdAndDel(long datatempId, long userId,
	// boolean
	// del);

	// Optional<List<DataTemp>> findAllByUserIdAndDel(long userId, boolean del);

	List<DataTemp> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
