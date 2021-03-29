package com.livesoft.smartfarm.mapper;

import java.util.Optional;

import com.livesoft.smartfarm.models.entities.Store;

public interface StoreMapper {
	
	public Optional<Store> findById(long id);
}

//@Component
//public class StoreMapper {
//	
//	@Autowired
//	private SqlSession sqlSessionTemplate;
//	
//	public Optional<Store> findById(long id) {
//		return Optional.ofNullable(sqlSessionTemplate.selectOne("com.livesoft.smartfarm.mapper.StoreMapper.findById", id));
//	}
//	
//}
