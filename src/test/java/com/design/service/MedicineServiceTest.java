package com.design.service;

import com.design.entity.Medicine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-*.xml")
public class MedicineServiceTest {

    @Autowired
    private MedicineService medicineService;

    @Test
    public void getMedicineList() throws Exception {

        List<Medicine> list = medicineService.getMedicineList( 2,2 );
        for (Medicine medicine: list){
            System.out.println( medicine.toString() );
        }

    }

    @Test
    public void getMedicineById() throws Exception {
    }

    @Test
    public void getMedicineByKeyword() throws Exception {
    }

    @Test
    public void insertNewMedicine() throws Exception {
    }

    @Test
    public void pictureHandler() throws Exception {
    }

    @Test
    public void initList() throws Exception {

        List<Medicine> list = medicineService.initList();

        for (Medicine m: list) {
            System.out.println( m.toString() );
        }

    }

    @Test
    public void queryAllSupplier() throws Exception {
    }

    @Test
    public void deleteMedicineById() throws Exception {
    }

}