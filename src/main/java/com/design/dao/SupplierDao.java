package com.design.dao;

import org.apache.ibatis.annotations.Param;

public interface SupplierDao {

    /**
     * 添加供应商/生产商
     * @param suppllierName
     * @param supplierPicture
     * @return
     */
    boolean addSupplier(@Param( "suppllierName" ) String suppllierName,@Param( "supplierPicture" ) String supplierPicture);


}
