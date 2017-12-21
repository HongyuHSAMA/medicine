package com.design.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Supplier {

    @Getter @Setter private long supplierId;
    @Getter @Setter private String supplierName;
    @Getter @Setter private String supplierPicture;
}
