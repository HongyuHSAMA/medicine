package com.design.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@ToString
public class Replenish {

    @Getter @Setter private Long replenish_id;//进货批次id
    @Getter @Setter private Long replenishMedicineId;//药品id
    @Getter @Setter private Date createTime;//进货日期
    @Getter @Setter private Integer replenishMedicineNumber;//进货数量
    @Getter @Setter private Integer replenishWorkerId;//经手员工ID
    @Getter @Setter private Integer replenishMedicinePrice;//进价
    //@Getter @Setter private Medicine medicine;//药品类对象，一对多


    @Getter @Setter private String createStringTime;
}
