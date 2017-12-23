package com.design.service;


import com.design.dao.SupplierDao;
import com.design.entity.Supplier;
import org.springframework.stereotype.Service;


public interface SupplierService {


    /**
     * 添加供应商
     */
    boolean addSuppliers(String supplierName, String pucture);

    /**
     * 处理supplier的图片编码
     */
    boolean pictureHandle(Supplier supplier);

}
