package com.design.service;

import com.design.dao.MedicineDao;
import com.design.dao.ReplenishDao;
import com.design.dao.WorkerDao;
import com.design.entity.Medicine;
import com.design.entity.Replenish;
import com.design.entity.Worker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class ReplenishServiceTest {

    @Autowired
    private MedicineDao medicineDao;

    @Autowired
    private WorkerDao workerDao;

    @Autowired
    private ReplenishDao replenishDao;

    @Test
    public void getReplenishAll() throws Exception {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

        List<Replenish> list = replenishDao.queryAll();
        for (Replenish replenish :list){
            //以replinish相应的职工、药品id，查询相应的名称，如果不存在则使用保存的id显示
            Worker worker = workerDao.queryById( replenish.getReplenishWorkerId() );
            Medicine medicine = medicineDao.queryById( replenish.getReplenishMedicineId() );
            if(worker != null){
                replenish.setReplenishWorkerName( worker.getWorkerName() );
            }else{
                replenish.setReplenishWorkerName( replenish.getReplenishWorkerId().toString());
            }
            if (medicine!= null) {
                replenish.setReplenishMedicineName( medicine.getMedicineName() );
            }else{
                replenish.setReplenishMedicineName(replenish.getReplenishMedicineId().toString() );
            }
            replenish.setCreateStringTime( simpleDateFormat.format( replenish.getCreateTime() ) );
            System.out.println( replenish.toString() );
        }

    }

}