package com.livesoft.smartfarm.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.livesoft.smartfarm.models.simples.FarmSimple;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter @Setter
@Entity(name = "farm")
@DynamicUpdate
public class Farm extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 3321044622977739271L;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_FARM_USER"))
	private User user;
	
	@Column(nullable=false, length = 100)
	private String name;

	@Column(length = 30)
	private String farmBusiness;	
	
	@Builder
	private Farm(User user, String name, String farmBusiness) {
		this.user = user;
		this.name = name;
		this.farmBusiness = farmBusiness;
	}

	@Override
	public FarmSimple getSimple() {
		return FarmSimple.builder().id(getId()).name(name).farmBusiness(farmBusiness)
				.userId(user != null ? user.getId() : null).build();
	}
}
