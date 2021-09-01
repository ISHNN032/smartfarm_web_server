package com.livesoft.smartfarm.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.livesoft.smartfarm.models.simples.ControllerSimple;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "controller")
@DynamicUpdate
@DynamicInsert
public class Controller extends BaseEntity implements Serializable {

	@Column(nullable = false)
	private Long farmId;

	@Column()
	private String name;

	@Builder
	public Controller(Long farmId, String name) {
		this.farmId = farmId;
		this.name = name;
	}

	@Override
	public ControllerSimple getSimple() {
		return ControllerSimple.builder().farmId(farmId).name(name).build();
	}
}
