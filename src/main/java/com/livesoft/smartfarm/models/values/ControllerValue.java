package com.livesoft.smartfarm.models.values;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "컨트롤러")
@Getter
@Setter
public class ControllerValue {

	@Schema(description = "ID")
	private int _id;

	@Schema(description = "컨트롤러ID")
	private int contId;

	@Schema(description = "이름")
	private String name;

	@Schema(description = "tabel이름")
	private String tableName;

	@Schema(description = "타입")
	private String dataType;

}
