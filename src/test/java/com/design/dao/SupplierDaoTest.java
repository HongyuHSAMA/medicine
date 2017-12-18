package com.design.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SupplierDaoTest {

    @Resource
    private SupplierDao supplierDao;

    @Test
    public void addSupplier() throws Exception {

        String supplierName = "惠氏制药有限公司";
        String picture = "201712654";
        System.out.println( supplierDao.addSupplier( supplierName,picture ) );

    }

}