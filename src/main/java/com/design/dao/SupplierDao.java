package com.design.dao;

import com.design.entity.Supplier;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierDao {

    /**
     * 添加供应商/生产商
     * @param suppllierName
     * @param supplierPicture
     * @return
     */
    boolean addSupplier(@Param( "suppllierName" ) String suppllierName,@Param( "supplierPicture" ) String supplierPicture);



    List<Supplier> selectAllSupplier();

}
