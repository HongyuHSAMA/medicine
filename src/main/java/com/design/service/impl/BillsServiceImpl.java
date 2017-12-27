package com.design.service.impl;

import com.design.dao.BillsDao;
import com.design.dao.MedicineDao;
import com.design.dao.WorkerDao;
import com.design.entity.Bills;
import com.design.entity.Medicine;
import com.design.entity.Worker;
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

    @Autowired
    private MedicineDao medicineDao;

    @Autowired
    private WorkerDao workerDao;

    @Override
    public boolean addNewBills(Bills bills) {

        try {
            bills.setCreateTime(new SimpleDateFormat("yyyy-MM-dd").parse(bills.getCreateStringTime()));
            if (billsDao.addBill(bills)) {
                medicineDao.changeMedicineNum( bills.getBillMedicineId(),(-bills.getBillMedicineNumber()));
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
            Worker worker =workerDao.queryById( bills.getBillWorkerId() );
            Medicine medicine = medicineDao.queryById( bills.getBillMedicineId() );
            if( worker != null){
                bills.setBillWorkerName( worker.getWorkerName() );
            }else{
                bills.setBillWorkerName( bills.getBillWorkerId().toString()+"(职工已离职)" );
            }
            if (medicine!= null) {
                bills.setBillMedicineName(medicine.getMedicineName() );
            }else{
                bills.setBillMedicineName(bills.getBillMedicineId().toString()+"(药品已删除)" );
            }
            bills.setCreateStringTime( simpleDateFormat.format( bills.getCreateTime() ) );
        }

        return list;
    }
}
