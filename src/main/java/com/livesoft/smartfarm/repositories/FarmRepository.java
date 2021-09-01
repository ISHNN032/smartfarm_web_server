package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.livesoft.smartfarm.models.entities.Farm;

@RepositoryRestResource
@Repository
public interface FarmRepository extends JpaRepository<Farm, Long> {
	
	Optional<List<Farm>> findAllByDel(boolean del);
	
	Optional<Farm> findByIdAndDel(Long id, boolean del);
	
	@RestResource(exported = false)
	Optional<Farm> findByIdAndUserIdAndDel(long farmId, long userId, boolean del);
	
	Optional<List<Farm>> findAllByUserIdAndDel(long userId, boolean del);

	List<Farm> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
