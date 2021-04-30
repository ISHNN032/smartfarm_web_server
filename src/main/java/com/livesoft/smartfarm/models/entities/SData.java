package com.livesoft.smartfarm.models.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import com.livesoft.smartfarm.models.simples.SDataSimple;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "sdata")
@DynamicUpdate
@DynamicInsert
public class SData extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 0;// ???????
	@Column(nullable = false)
	private int state;

	@Column(nullable = false)
	private float value;

	@Builder
	public SData(int state, float value) {
		this.state = state;
		this.value = value;
	}

	@Override
	public SDataSimple getSimple() {
		return SDataSimple.builder().id(getId()).state(state).value(value).build();
	}
}
