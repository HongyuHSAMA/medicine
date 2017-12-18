package com.design.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
@ToString
public class Bills {

    @Getter @Setter private long billId;//账单id
    @Getter @Setter private Date createTime;//生成时间
    @Getter @Setter private long billMedicineId;//药品id
    @Getter @Setter  private int billMedicineNumber;//药品数量
    @Getter @Setter private int billMedicinePrice;//售价
    @Getter @Setter private long billWorkerId;//经手员工姓名
    @Getter @Setter  private String billCustomer;//客户名称
}
