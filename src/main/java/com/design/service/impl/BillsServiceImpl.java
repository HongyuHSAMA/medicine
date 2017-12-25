package com.design.service.impl;

import com.design.dao.BillsDao;
import com.design.entity.Bills;
import com.design.service.BillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class BillsServiceImpl implements BillsService{

    @Autowired
    private BillsDao billsDao;


    @Override
    public boolean addNewBills(Bills bills) {

        try {
            bills.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").parse(bills.getCreateStringTime()));
            if (billsDao.addBill(bills)) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            return false;
        }

    }

    @Override
    public List<Bills> getBillsList() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );

        List<Bills> list =billsDao.queryAll();
        for (Bills bills :list){
            bills.setCreateStringTime( simpleDateFormat.format( bills.getCreateTime() ) );
        }

        return list;
    }
}
