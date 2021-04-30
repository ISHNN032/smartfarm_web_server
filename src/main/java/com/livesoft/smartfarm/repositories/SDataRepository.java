package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.livesoft.smartfarm.models.entities.SData;

@RepositoryRestResource
@Repository
public interface SDataRepository extends JpaRepository<SData, Long> {

	Optional<List<SData>> findAllByDel(boolean del);

	Optional<SData> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<SData> findByIdAndUserIdAndDel(long sdataId, long userId, boolean
	// del);

	// Optional<List<SData>> findAllByUserIdAndDel(long userId, boolean del);

	List<SData> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
