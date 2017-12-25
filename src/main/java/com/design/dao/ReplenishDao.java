package com.design.dao;

import com.design.entity.Medicine;
import com.design.entity.Replenish;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReplenishDao {


    /**
     * 添加进货表信息
     *
     * @param replenishMedicineId
     * @param createTime
     * @param replenishMedicineNumber
     * @param replenishWorkerId
     * @param replenishMedicinePrice
     * @return
     */
    boolean addReplenishDao(@Param("replenishMedicineId") long replenishMedicineId,
                            @Param("createTime") Date createTime,
                            @Param("replenishMedicineNumber") int replenishMedicineNumber,
                            @Param("replenishWorkerId") long replenishWorkerId,
                            @Param("replenishMedicinePrice") int replenishMedicinePrice);

    /**
     * 获取全部入库记录

     * @return
     */
    List<Replenish> queryAll();


    List<Medicine> queryAllMedicine();


    boolean insertReplenish(Replenish replenish);
}
