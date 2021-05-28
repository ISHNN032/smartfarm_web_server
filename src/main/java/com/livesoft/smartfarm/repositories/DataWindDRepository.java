package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import com.livesoft.smartfarm.models.entities.SensorDatas.DataWindD;

@RepositoryRestResource
@Repository
public interface DataWindDRepository extends JpaRepository<DataWindD, Long> {

	Optional<List<DataWindD>> findAllByDel(boolean del);

	Optional<DataWindD> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<DataWindD> findByIdAndUserIdAndDel(long datatempId, long userId,
	// boolean
	// del);

	// Optional<List<DataWindD>> findAllByUserIdAndDel(long userId, boolean del);

	List<DataWindD> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
