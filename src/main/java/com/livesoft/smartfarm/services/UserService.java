package com.livesoft.smartfarm.services;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.livesoft.smartfarm.models.entities.User;
import com.livesoft.smartfarm.models.entities.UserRole;
import com.livesoft.smartfarm.models.entities.UserRole.RoleType;
import com.livesoft.smartfarm.models.simples.UserSimple;
import com.livesoft.smartfarm.models.values.UserValue;
import com.livesoft.smartfarm.repositories.UserRepository;
import com.livesoft.smartfarm.repositories.UserRoleRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final UserRoleRepository userRoleRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserSimple findById(Long id) {
		return userRepository.findWithUserRolesById(id).orElse(null).getSimple();
	}
	
	@Transactional(transactionManager="transactionManager")
	private User save(UserValue value) {
		User user = userRepository.save(User.builder()
				.type(value.getType())
				.email(value.getEmail())
				.birthDate(value.getBirthDate())
				.name(value.getName())
				.password(passwordEncoder.encode(value.getPassword()))
				.phoneNumber(value.getPhoneNumber())
				.sex(value.getSex()).build());
		return user;
	}
		
	@Transactional
	private UserRole saveUserRole(User user, RoleType roleName) {
		return userRoleRepository.save(UserRole.builder().user(user).roleName(roleName).build());
	}
	
	public UserSimple join(UserValue value) {
		User user = save(value);
		saveUserRole(user, RoleType.ROLE_VIEW);
		return user.getSimple();
	}
	
	@Transactional
	public boolean patch(long id, UserValue value) {
		Optional<User> oUser = userRepository.findById(id);		
		if(oUser.isPresent()) {
			User user = oUser.get();
			if(StringUtils.isNotBlank(value.getType()))
				user.setType(value.getType());
			if(StringUtils.isNotBlank(value.getEmail()))
				user.setEmail(value.getEmail());
			if(StringUtils.isNotBlank(value.getBirthDate()))
				user.setBirthDate(value.getBirthDate());
			if(StringUtils.isNotBlank(value.getName()))
				user.setName(value.getName());
			if(StringUtils.isNotBlank(value.getPassword()))
				user.setPassword(passwordEncoder.encode(value.getPassword()));
			if(StringUtils.isNotBlank(value.getPhoneNumber()))
				user.setPhoneNumber(value.getPhoneNumber());
			if(StringUtils.isNotBlank(value.getSex()))
				user.setSex(value.getSex());			
		} else {
			return false;
		}
		return true;
	}

	@Transactional
	public boolean delete(long id) {		
		Optional<User> oUser = userRepository.findById(id);
		if(!oUser.isPresent())
			return false;
		
		User user = oUser.get();
		user.setDel(true);
		return true;
	}

	public List<User> findAll(Pageable pageable) {
		return userRepository.findAllByDelOrderByIdDesc(false, pageable);
	}

	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}
	
	
}
