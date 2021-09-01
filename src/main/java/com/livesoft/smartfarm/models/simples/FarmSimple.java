package com.livesoft.smartfarm.models.simples;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FarmSimple {
	
	private Long id;
	
	@Schema(description = "사용자 id")
	private Long userId;
	
	@Schema(description = "이름")
	private String name;
	
	@Schema(description = "업종")
	private String farmBusiness;
	
	@Builder
	public FarmSimple(Long id, Long userId, String name, String farmBusiness) {
		this.id = id;
		this.userId = userId;
		this.name = name;
		this.farmBusiness = farmBusiness;
	}
}
