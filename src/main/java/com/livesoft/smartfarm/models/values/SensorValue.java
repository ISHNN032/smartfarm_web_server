package com.livesoft.smartfarm.models.values;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "센서")
@Getter
@Setter
public class SensorValue {
	@Schema(description = "컨트롤러ID")
	private Long contId;

	@Schema(description = "이름")
	private String name;
}
