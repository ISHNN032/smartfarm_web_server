package com.livesoft.smartfarm.models.simples;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataWindSSimple {

	private Long id;

	@Schema(description = "상태")
	private int state;

	@Schema(description = "값")
	private float value;

	@Builder
	public DataWindSSimple(Long id, int state, float value) {
		this.id = id;
		this.state = state;
		this.value = value;
	}
}