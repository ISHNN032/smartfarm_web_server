package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.livesoft.smartfarm.models.entities.SensorDatas.DataWindS;

@RepositoryRestResource
@Repository
public interface DataWindSRepository extends JpaRepository<DataWindS, Long> {

	Optional<List<DataWindS>> findAllByDel(boolean del);

	Optional<DataWindS> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<DataWindS> findByIdAndUserIdAndDel(long datatempId, long userId,
	// boolean
	// del);

	// Optional<List<DataWindS>> findAllByUserIdAndDel(long userId, boolean del);

	List<DataWindS> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
