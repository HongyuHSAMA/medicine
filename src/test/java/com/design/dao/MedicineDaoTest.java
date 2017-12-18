package com.design.dao;

import com.design.entity.Medicine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class MedicineDaoTest {

    @Resource
    private MedicineDao medicineDao;



    @Test
    public void queryMedicineNumber() throws Exception {

        System.out.println( medicineDao.queryMedicineNumber() );
    }

    @Test
    public void queryAll() throws Exception {

        List<Medicine> list = medicineDao.queryAll( 0,5 );

        Iterator iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println( iterator.next() );
        }

    }

    @Test
    public void queryById() throws Exception {

        long medicineId = 1000L;

        Medicine medicine = medicineDao.queryById( medicineId );

        System.out.println( medicine.toString() );

    }


}