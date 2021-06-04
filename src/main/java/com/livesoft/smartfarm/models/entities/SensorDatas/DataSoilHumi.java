package com.livesoft.smartfarm.models.entities.SensorDatas;

import com.livesoft.smartfarm.models.entities.BaseEntity;
import com.livesoft.smartfarm.models.simples.DataSoilHumiSimple;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "data_soilh")
@DynamicUpdate
@DynamicInsert
public class DataSoilHumi extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 0;// ???????

    @Column(nullable = false)
    private int state;

    @Column(nullable = false)
    private float value;

    @Builder
    public DataSoilHumi(int state, float value) {
        this.state = state;
        this.value = value;
    }

    @Override
    public DataSoilHumiSimple getSimple() {
        return DataSoilHumiSimple.builder().id(getId()).state(state).value(value).build();
    }
}