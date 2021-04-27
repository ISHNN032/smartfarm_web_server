package com.livesoft.smartfarm.models.simples;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorSimple {

	private Long id;

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

	@Builder
	public SensorSimple(Long id, int _id, int contId, String name, String tableName, String dataType) {
		this._id = _id;
		this.contId = contId;
		this.name = name;
		this.tableName = tableName;
		this.dataType = dataType;
	}
}
