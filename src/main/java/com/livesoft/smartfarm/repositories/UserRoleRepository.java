package com.livesoft.smartfarm.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.livesoft.smartfarm.models.entities.User;
import com.livesoft.smartfarm.models.entities.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{
	
	Set<UserRole> findByUserAndDel(User user, boolean del);
	
}