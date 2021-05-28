package com.livesoft.smartfarm.models.values;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "습도센서데이터")
@Getter
@Setter
public class DataHumiValue {
	@Schema(description = "상태")
	private int state;

	@Schema(description = "값")
	private float value;
}
