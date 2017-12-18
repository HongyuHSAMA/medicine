package com.design.dao;

import com.design.entity.Replenish;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class ReplenishDaoTest {

    @Resource
    private ReplenishDao replenishDao;

    @Test
    public void addReplenishDao() throws Exception {

        long replenishMedicineId = 1000L;
        Date createTime = new Date( );
        int replenishMedicineNumber = 100;
        long replenishWorkerId = 1000L;
        int replenishMedicinePrice = 66;

        System.out.println( replenishDao.addReplenishDao( replenishMedicineId,createTime,
                replenishMedicineNumber,replenishWorkerId,replenishMedicinePrice ) );

    }

    @Test
    public void queryAll() throws Exception {

        List<Replenish> list = replenishDao.queryAll( 0,5 );
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println( iterator.next() );
        }

    }

}