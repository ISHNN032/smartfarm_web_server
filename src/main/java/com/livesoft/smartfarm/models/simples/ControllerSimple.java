package com.livesoft.smartfarm.models.simples;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ControllerSimple {
	@Schema(description = "농장ID")
	private Long farmId;

	@Schema(description = "이름")
	private String name;

	@Builder
	public ControllerSimple(Long farmId, String name) {
		this.farmId = farmId;
		this.name = name;
	}
}
