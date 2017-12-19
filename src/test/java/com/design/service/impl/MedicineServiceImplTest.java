package com.design.service.impl;

import com.design.entity.Medicine;
import com.design.service.MedicineService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class MedicineServiceImplTest {

    @Autowired
    private MedicineService medicineService;

    @Test
    public void queryMedicineList() throws Exception {

        int pageNum = 4;
        int pageSize = 2;
        List<Medicine> list = medicineService.getMedicineList( pageNum,pageSize );

        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println( iterator.next() );
        }

    }

}