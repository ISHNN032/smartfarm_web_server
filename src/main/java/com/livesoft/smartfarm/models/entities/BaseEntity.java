package com.livesoft.smartfarm.models.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1146360965411496820L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createTimestamp;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true)
	private Date updateTimestamp;	

	@Column(nullable = false)
	private boolean del;	
	
	@PrePersist
	protected void onCreate() {
		createTimestamp = Timestamp.valueOf(LocalDateTime.now());
	}
	
	@PreUpdate
	protected void onUpdate() {
		updateTimestamp = Timestamp.valueOf(LocalDateTime.now());
	}
	
	public abstract Object getSimple();
}
