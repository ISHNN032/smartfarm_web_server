package com.livesoft.smartfarm.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.livesoft.smartfarm.models.simples.SensorDataSimple;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "sensordata")
@DynamicUpdate
@DynamicInsert
public class SensorData extends BaseEntity implements Serializable {

	@Column(nullable = false)
	private Long sensorId;

	@Column()
	private int state;

	@Column()
	private float value;

	@Builder
	public SensorData(Long sensorId, int state, float value) {
		this.sensorId = sensorId;
		this.state = state;
		this.value = value;
	}

	@Override
	public SensorDataSimple getSimple() {
		return SensorDataSimple.builder().sensorId(sensorId).state(state).value(value).build();
	}
}
