package com.design.dao;

import com.design.entity.Medicine;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MedicineDao {

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
    boolean addMedicine(@Param("medicineName") String medicineName, @Param("medicineNumber")int medicineNumber,
                        @Param("productionDate") Date productionDate, @Param("expirationDate")Date expirationDate,
                        @Param("price") int price, @Param("medicinePermiment")String medicinePermiment,
                        @Param("description")String description, @Param("picture")String  picture,
                        @Param("warningNumber") int warningNumber);

    /**
     * 查询药库里药品的种类
     * @return
     */
    int queryMedicineNumber();

    /**
     * 根据偏移量查询药品列表
     * @param offset  偏移量
     * @param limit
     * @return
     */
    List<Medicine> queryAll(@Param("offset") int offset,@Param("limit") int limit);

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
