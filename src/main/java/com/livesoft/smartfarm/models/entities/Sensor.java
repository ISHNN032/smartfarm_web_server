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

	@Column(nullable = false)
	private Long contId;

	@Column()
	private String name;

	@Builder
	public Sensor(Long contId, String name) {
		this.contId = contId;
		this.name = name;
	}

	@Override
	public SensorSimple getSimple() {
		return SensorSimple.builder().contId(contId).name(name).build();
	}
}
