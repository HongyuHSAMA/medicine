package com.design.dao;

import com.design.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import org.springframework.stereotype.Component;


import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Repository
public interface MedicineDao {

    /**
     * 根据id删除药品
     * @param medicineId
     * @return
     */
    boolean deleteById(Long medicineId);




    /**
     * 根据关键字模糊查询（对应药品名称和供应商id）
     * @param keyword
     * @return
     */
    //TODO   是否需要将供应商Id改为供应商名称，传入的类型为string，然后需要Id的话，类型不对
    List<Medicine> queryByKeyword(@Param( "keyword" ) String keyword);

    /**
     * 添加药品
     * @param medicineName
     * @param medicineNumber
     * @param productionDate
     * @param expirationDate
     * @param price
     * @param medicinePermiment
     * @param description
     * @param picture
     * @param warningNumber
     * @return
     */
    boolean addMedicine(Medicine medicine);

    /**
     * 查询药库里药品的种类
     * @return
     */
    int queryMedicineNumber();

    /**
     * 查询全部药品信息
     * @return
     */
    List<Medicine> queryAll();

    /**
     * 根据药品id查询药品信息
     * @param medicineId
     * @return
     */
    Medicine queryById(@Param("medicineId") long medicineId);

    /**
     * 更新药品信息
     * @param medicineNumber
     * @param expirationDate
     * @param price
     * @param description
     * @param picture
     * @return
     */
    boolean setMedicineInfo(@Param( "medicineId" ) long medicineId,
                            @Param("medicineNumber")int medicineNumber,
                            @Param("expirationDate")Date expirationDate,
                            @Param("price") int price,
                            @Param("description")String description, @Param("picture")String picture,
                            @Param( "medicineSupplierId" ) int medicineSupplierId
                            );




}
