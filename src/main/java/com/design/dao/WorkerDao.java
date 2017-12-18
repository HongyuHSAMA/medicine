package com.design.dao;

import org.apache.ibatis.annotations.Param;

public interface WorkerDao {

    /**
     * 根据员工Id查找员工信息
     * @param workerId
     * @return
     */
    boolean queryById(@Param("workerId") int workerId);
}
