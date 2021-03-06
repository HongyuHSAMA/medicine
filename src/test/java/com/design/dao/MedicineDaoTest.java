package com.design.dao;

import com.design.entity.Medicine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class MedicineDaoTest {

    @Autowired
    private MedicineDao medicineDao;


    @Test
    public void queryMedicineNumber() throws Exception {

        System.out.println( medicineDao.queryMedicineNumber() );
    }

    @Test
    public void queryAll() throws Exception {

        List<Medicine> list = medicineDao.queryAll(  );

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

    @Test
    public void deleteTest() {
        try {
            medicineDao.deleteById(1000L);
            System.out.println("1111111111");
        } catch (Exception e) {
            System.out.println("222222222222");
        }
    }


}