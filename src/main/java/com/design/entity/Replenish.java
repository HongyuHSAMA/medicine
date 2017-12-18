package com.design.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
public class Replenish {

    @Getter @Setter private long replenish_id;//进货批次id
    @Getter @Setter private long replenishMedicineId;//药品id
    @Getter @Setter private Date createTime;//进货日期
    @Getter @Setter private int replenishMedicineNumber;//进货数量
    @Getter @Setter private String replenishWorkerName;//经手员工名称
    @Getter @Setter private int replenishMedicinePrice;//进价
    //@Getter @Setter private Medicine medicine;//药品类对象，一对多
}
