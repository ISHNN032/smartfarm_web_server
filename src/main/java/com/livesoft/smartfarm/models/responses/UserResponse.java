package com.livesoft.smartfarm.models.responses;

import com.livesoft.smartfarm.models.simples.UserSimple;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "회원 Response")
public class UserResponse extends CommonResponse<UserSimple> {

	public UserResponse(UserSimple value) {
		super(value);
	}
	
}
