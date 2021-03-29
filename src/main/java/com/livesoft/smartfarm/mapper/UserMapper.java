package com.livesoft.smartfarm.mapper;

import java.util.Optional;

import org.apache.ibatis.annotations.Select;

import com.livesoft.smartfarm.models.entities.User;

public interface UserMapper {
	
	public Optional<User> findById(long id);
	
	@Select("SELECT * FROM user where id = #{id}")
	public Optional<User> findById2(long id);
}
