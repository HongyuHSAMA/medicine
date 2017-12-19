package com.design.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.Date;

@ToString
public class Medicine {

    @Getter @Setter  private long medicineId;//药品库存id
    @Getter @Setter private String medicineName;//药品名称
    @Getter @Setter  private int medicineNumber;//库存数量
    @Getter @Setter private Date productionDate;//生产日期
    @Getter @Setter private Date expirationDate;//保质期
    @Getter @Setter private int price;//售价
    @Getter @Setter  private String medicinePermitment;//国药准字
    @Getter @Setter private String description;//description
    @Getter @Setter private String picture;//图片字节存储
    @Getter @Setter private int warningNumber;//预警数量线
    @Getter @Setter private String medicineSupplierId;//供应商id
}
