package com.design.service;

import com.design.entity.Medicine;
import com.design.entity.Replenish;
import com.design.entity.Worker;

import java.util.List;

public interface ReplenishService {

    List<Medicine> queryAllMedicineNameAndId();
    List<Worker> queryAllWorkerNameAndId();

    List<Replenish> getReplenishAll();

    boolean addNewReplenish(Replenish replenish);

}
