package com.design.dao;

import com.design.entity.Worker;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerDao {

    /**
     * 根据员工Id查找员工信息
     * @param workerId
     * @return
     */
    boolean queryById(@Param("workerId") int workerId);


    List<Worker> queryAllWorkerNameAndId();
}
