package com.livesoft.smartfarm.models.simples;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorSimple {
	@Schema(description = "컨트롤러ID")
	private Long contId;

	@Schema(description = "이름")
	private String name;

	@Builder
	public SensorSimple(Long contId, String name) {
		this.contId = contId;
		this.name = name;
	}
}
