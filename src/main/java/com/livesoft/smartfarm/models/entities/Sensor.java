package com.livesoft.smartfarm.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.livesoft.smartfarm.models.simples.SensorSimple;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "sensor")
@DynamicUpdate
@DynamicInsert
public class Sensor extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 0;// ???????

	@Column(nullable = false, unique = true)
	private int _id;

	@Column(nullable = false)
	private int contId;

	@Column()
	private String name;

	@Column(nullable = false, length = 10)
	private String tableName;

	@Column(nullable = false, length = 8)
	private String dataType;

	@Builder
	public Sensor(int _id, int contId, String name, String tableName, String dataType) {
		this._id = _id;
		this.contId = contId;
		this.name = name;
		this.tableName = tableName;
		this.dataType = dataType;
	}

	@Override
	public SensorSimple getSimple() {
		return SensorSimple.builder().id(getId())._id(_id).contId(contId).name(name).tableName(tableName)
				.dataType(dataType).build();
	}
}
