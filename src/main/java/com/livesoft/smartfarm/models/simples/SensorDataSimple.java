package com.livesoft.smartfarm.models.simples;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorDataSimple {
	@Schema(description = "센서 ID")
	private Long sensorId;

	@Schema(description = "상태")
	private int state;

	@Schema(description = "값")
	private float value;

	@Builder
	public SensorDataSimple(Long sensorId, int state, float value) {
		this.sensorId = sensorId;
		this.state = state;
		this.value = value;
	}
}
