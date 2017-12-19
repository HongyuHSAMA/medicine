package com.design.service;

import com.design.entity.Medicine;
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


}
