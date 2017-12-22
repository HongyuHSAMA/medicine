package com.design.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@ToString
public class Bills {

    @Getter @Setter private Long billId;//账单id
    @Getter @Setter private Date createTime;//生成时间
    @Getter @Setter private Long billMedicineId;//药品id
    @Getter @Setter private Integer billMedicineNumber;//药品数量
    @Getter @Setter private Integer billMedicinePrice;//售价
    @Getter @Setter private Integer billWorkerId;//经手员工ID
    @Getter @Setter private String billCustomer;//客户名称


    @Getter @Setter private String createStringTime;

}
