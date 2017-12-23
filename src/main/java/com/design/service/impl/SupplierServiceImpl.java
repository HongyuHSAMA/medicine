package com.design.service.impl;


import com.design.dao.SupplierDao;
import com.design.entity.Supplier;
import com.design.service.SupplierService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class SupplierServiceImpl implements SupplierService{

    @Autowired
    private SupplierDao supplierDao;

    @Value("${supplierImage.savePath}")
    private String supplierImageSavePath;


    @Value("${supplierImage.url}")
    private String supplierImageUrl;

    @Override
    public boolean addSuppliers(String supplierName, String picture) {
        System.out.println( "picture"+picture );
        return supplierDao.addSupplier( supplierName,picture );
    }

    @Override
    public boolean pictureHandle(Supplier supplier) {

        String dataPrix = null;
        String data = null;
        String[] d =supplier.getImgFile().split("base64,");
        if (d != null && d.length == 2) {
            dataPrix = d[0];
            data = d[1];
        } else {
            return false;
        }
        if ("data:image/jpeg;".equalsIgnoreCase(dataPrix)) {
            dataPrix = ".jpeg";
        } else {
            return false;
        }

        byte[] bytes = Base64Utils.decodeFromString(data);


        String fileName = String.valueOf(System.currentTimeMillis()) + UUID.randomUUID() + dataPrix;

        supplier.setSupplierPicture( fileName );
        try {
            FileUtils.writeByteArrayToFile(new File(supplierImageSavePath,fileName),bytes);
            return true;
        } catch (IOException e) {
            return false;
        }

    }


}
