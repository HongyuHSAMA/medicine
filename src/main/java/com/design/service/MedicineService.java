package com.design.service;

import com.design.entity.Medicine;
import com.design.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MedicineService {

    /**
     * 根据药品信息，“获取”第pageNum页，每页pageSize条数据
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<Medicine> getMedicineList(int pageNum,int pageSize);

    /**
     * 根据id获取药品信息
     * @param medicineId
     * @return
     */
    Medicine getMedicineById(long medicineId);

    /**
     * 根据关键字模糊查询药品列表
     * @param keyword
     * @return
     */
    List<Medicine> getMedicineByKeyword(String keyword);

    /**
     * 插入新的药品元组
     * @param medicine
     * @return
     */
    boolean insertNewMedicine(Medicine medicine);


    /**
     * 对上传的图片编码进行处理
     * @param medicine
     * @return
     */
    boolean pictureHandler(Medicine medicine);


    /**
     * 初始化药品列表
     * @return
     */
    List<Medicine> initList();

    /**
     * 查询所有供应商
     * @return
     */
    List<Supplier> queryAllSupplier();


    boolean deleteMedicineById(Long medicineId);

}
