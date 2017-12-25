package com.design.service.impl;

import com.design.dao.MedicineDao;
import com.design.dao.SupplierDao;
import com.design.entity.Medicine;
import com.design.entity.Supplier;
import com.design.service.MedicineService;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    @Autowired
    private SupplierDao supplierDao;

    @Value("${medicineImage.savePath}")
    private String medicineImageSavePath;



    @Value("${medicineImage.url}")
    private String medicineImageUrl;

    @Override
    public List<Medicine> getMedicineList(int pageNum, int pageSize) {


        PageHelper.startPage( pageNum,pageSize );
        List<Medicine> list = medicineDao.queryAll( /*pageNum,pageSize*/ );

        return list;
    }

    @Override
    public Medicine getMedicineById(long medicineId) {

        return medicineDao.queryById( medicineId );
    }

    @Override
    public List<Medicine> getMedicineByKeyword(String keyword) {

        //TODO  需要确定每页显示的数据条数,考虑当根据关键字搜索后的数据分页
        int pageSize = 10;
        int pageNum = 0;
        List<Medicine> list = medicineDao.queryByKeyword( keyword );
        if (list.size() > pageSize){
            PageHelper.startPage( pageNum,pageSize );
            List<Medicine> list1 = medicineDao.queryByKeyword( keyword );
            return list1;
        } else {
            return null;
        }

    }

    @Override
    public boolean insertNewMedicine(Medicine medicine) {

        if (medicineDao.addMedicine(medicine)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean pictureHandler(Medicine medicine) {

        String dataPrix = null;
        String data = null;
        String[] d = medicine.getImgFile().split("base64,");
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

        medicine.setPicture(fileName);

        try {
            FileUtils.writeByteArrayToFile(new File(medicineImageSavePath,fileName),bytes);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public List<Medicine> initList() {

        List<Medicine> medicineList = medicineDao.queryAll();

        for (Medicine medicine : medicineList) {
            medicine.setImgUrl(medicineImageUrl + medicine.getPicture());

            medicine.setExpirationStringDate(new SimpleDateFormat("yyyy-MM-dd").format(medicine.getExpirationDate()));
        }


        return medicineList;
    }

    @Override
    public List<Supplier> queryAllSupplier() {

        return supplierDao.selectAllSupplier();

    }

    @Override
    public boolean deleteMedicineById(Long medicineId) {


        return medicineDao.deleteById(medicineId);
    }


}
