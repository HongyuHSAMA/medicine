package com.design.service.impl;

import com.design.dao.MedicineDao;
import com.design.entity.Medicine;
import com.design.service.MedicineService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineDao medicineDao;

    @Override
    public List<Medicine> getMedicineList(int pageNum, int pageSize) {


        PageHelper.startPage( pageNum,pageSize );
        List<Medicine> list = medicineDao.queryAll( /*pageNum,pageSize*/ );

        return list;
    }

    @Override
    public Medicine getMedicineById(long medicineId) {

        return medicineDao.queryById( medicineId );
    }

    @Override
    public List<Medicine> getMedicineByKeyword(String keyword) {

        //TODO  需要确定每页显示的数据条数,考虑当根据关键字搜索后的数据分页
        int pageSize = 10;
        int pageNum = 0;
        List<Medicine> list = medicineDao.queryByKeyword( keyword );
        if (list.size() > pageSize){
            PageHelper.startPage( pageNum,pageSize );
            List<Medicine> list1 = medicineDao.queryByKeyword( keyword );
            return list1;
        } else {
            return null;
        }

    }
}
