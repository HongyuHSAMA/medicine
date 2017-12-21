package com.design.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;


import java.util.Date;

@ToString
public class Medicine {

    //表属性
    @Getter @Setter private long medicineId;//药品库存id
    @Getter @Setter private String medicineName;//药品名称
    @Getter @Setter private int medicineNumber;//库存数量
    @Getter @Setter private Date productionDate;//生产日期
    @Getter @Setter private Date expirationDate;//保质期 // 过期日期
    @Getter @Setter private String medicinePermitment;//国药准字
    @Getter @Setter private String description;//description
    @Getter @Setter private String picture;//图片名
    @Getter @Setter private int warningNumber;//预警数量线
    @Getter @Setter private String medicineSupplierId;//供应商id



    //数据传输
    @Getter @Setter private String productionStringDate;//接受字符串日期
    @Getter @Setter private Integer expirationIntegerDate;//接受保质期
    @Getter @Setter private String imgFile;//图片
    @Getter @Setter private String supplierName;//供应商名称
    @Getter @Setter private String imgUrl;//图片URL
    @Getter @Setter private String expirationStringDate;//字符串格式
}
