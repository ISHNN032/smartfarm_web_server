package com.livesoft.smartfarm.models.values;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "컨트롤러")
@Getter
@Setter
public class ControllerValue {
	@Schema(description = "농장ID")
	private Long farmId;

	@Schema(description = "이름")
	private String name;
}
