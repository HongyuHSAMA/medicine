package com.design.service;

import com.design.entity.Bills;

import java.util.List;

public interface BillsService {



    boolean addNewBills(Bills bills);

    List<Bills> getBillsList();

}
