package com.livesoft.smartfarm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.livesoft.smartfarm.models.entities.Controller;

@RepositoryRestResource
@Repository
public interface ControllerRepository extends JpaRepository<Controller, Long> {

	Optional<List<Controller>> findAllByDel(boolean del);

	Optional<Controller> findByIdAndDel(Long id, boolean del);

	// @RestResource(exported = false)
	// Optional<Controller> findByIdAndUserIdAndDel(long controllerId, long userId,
	// boolean
	// del);

	// Optional<List<Controller>> findAllByUserIdAndDel(long userId, boolean del);

	List<Controller> findAllByDelOrderByIdDesc(boolean del, Pageable pageable);
}
