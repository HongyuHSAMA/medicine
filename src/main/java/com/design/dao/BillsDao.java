package com.design.dao;

import com.design.entity.Bills;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BillsDao {

    /**
     * 添加账单
     *
     * @param bills
     * @return
     */
    boolean addBill(Bills bills);

    /**
     * 根据偏移量查询账单数据
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Bills> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 根据账单Id查询账单
     *
     * @param billId
     * @return
     */
    Bills queryById(@Param("billId") long billId);

    /**
     * 根据工作人员id查询账单
     *
     * @param billWorkerId
     * @return
     */
    Bills queryByWorkerId(@Param("billWorkerId") String billWorkerId);


}
