package com.design.service.impl;

import com.design.dao.ReplenishDao;
import com.design.dao.WorkerDao;
import com.design.entity.Medicine;
import com.design.entity.Replenish;
import com.design.entity.Worker;
import com.design.service.ReplenishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ReplenishServiceImpl implements ReplenishService {


    @Autowired
    private ReplenishDao replenishDao;

    @Autowired
    private WorkerDao workerDao;

    @Override
    public List<Medicine> queryAllMedicineNameAndId() {

        return replenishDao.queryAllMedicine();
    }

    @Override
    public List<Worker> queryAllWorkerNameAndId() {
        return workerDao.queryAllWorkerNameAndId();
    }

    @Override
    public List<Replenish> getReplenishAll() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

        List<Replenish> list = replenishDao.queryAll();
        for (Replenish replenish :list){
            replenish.setCreateStringTime( simpleDateFormat.format( replenish.getCreateTime() ) );
        }

        return list;
    }

    @Override
    public boolean addNewReplenish(Replenish replenish) {

        try {
            replenish.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").parse(replenish.getCreateStringTime()));

            if (replenishDao.insertReplenish(replenish)) {
                return true;
            } else {
                return false;
            }

        } catch (ParseException e) {
            return false;
        }

    }
}
