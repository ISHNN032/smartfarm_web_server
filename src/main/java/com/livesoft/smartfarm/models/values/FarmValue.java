package com.livesoft.smartfarm.models.values;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "농장")
@Getter @Setter
public class FarmValue {
	@Schema(description = "사용자 id")
	private Long userId;
	
	@Schema(description = "이름")
	private String name;
	
	@Schema(description = "업종")
	private String farmBusiness;
	
}
