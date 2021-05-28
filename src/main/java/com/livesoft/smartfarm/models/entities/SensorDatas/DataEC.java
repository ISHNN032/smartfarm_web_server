// package com.livesoft.smartfarm.models.entities.SensorDatas;

// import java.io.Serializable;
// import javax.persistence.Entity;
// import javax.persistence.Table;

// import com.livesoft.smartfarm.models.entities.SData;

// import org.hibernate.annotations.DynamicInsert;
// import org.hibernate.annotations.DynamicUpdate;
// import lombok.AccessLevel;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// @NoArgsConstructor(access = AccessLevel.PROTECTED)
// @Getter
// @Setter
// @Entity
// @Table(name = "data_ec")
// @DynamicUpdate
// @DynamicInsert
// public class DataEC extends SData implements Serializable {
// public DataEC(int state, float value) {
// super(state, value);
// }
// }