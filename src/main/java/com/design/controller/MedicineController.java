package com.design.controller;

import com.design.dao.MedicineDao;
import com.design.entity.Medicine;
import com.design.entity.Message;
import com.design.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@RestController
public class MedicineController {

    @Autowired
    private MedicineService medicineService;


    @Autowired
    private MedicineDao medicineDao;


    /*@RequestMapping("/index")
    public ModelAndView test1() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        return modelAndView;
    }*/

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");

        return modelAndView;
    }

    @RequestMapping("/medicineList")
    public ModelAndView medicineList(ModelAndView modelAndView) {



        modelAndView.addObject("medicineList",medicineService.initList());



        modelAndView.setViewName("medicine/medicine-list");
        return modelAndView;
    }
    @RequestMapping("/medicineAdd")
    public ModelAndView medicineAdd(ModelAndView modelAndView) {

        modelAndView.addObject("suppliers",medicineService.queryAllSupplier());

        modelAndView.setViewName("medicine/medicine-add");
        return modelAndView;
    }
    @RequestMapping("/medicineShow")
    public ModelAndView medicineShow(ModelAndView modelAndView) {
        modelAndView.setViewName("medicine/medicine-show");
        return modelAndView;
    }

    @RequestMapping("/medicineAddSubmit")
    public ModelAndView medicineAddSubmit(ModelAndView modelAndView, Medicine medicine) throws ParseException {

        if ("".equals(medicine.getProductionStringDate()) || medicine.getProductionStringDate() == null) {
            modelAndView.addObject(Message.statusMsg,Message.DATE_ERROR);
            modelAndView.addObject("medicineList",medicineService.initList());
            modelAndView.setViewName("medicine/medicine-message");
            return modelAndView;
        }
        if ("".equals(medicine.getImgFile()) || medicine.getImgFile() == null) {
            modelAndView.addObject(Message.statusMsg,Message.PICTURE_ERROR);
            modelAndView.addObject("medicineList",medicineService.initList());
            modelAndView.setViewName("medicine/medicine-message");
            return modelAndView;
        }


        //将字符串换成Date
        Date dateTemp = new SimpleDateFormat("yyyy-MM-dd").parse(medicine.getProductionStringDate());
        medicine.setProductionDate(dateTemp);

        //生产日期+保质期=过期日期
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(dateTemp);
        gregorianCalendar.add(1,medicine.getExpirationIntegerDate());
        gregorianCalendar.set(gregorianCalendar.get(Calendar.YEAR),gregorianCalendar.get(Calendar.MONTH),gregorianCalendar.get(Calendar.DATE));

        //设置过期日期
        dateTemp = gregorianCalendar.getTime();
        medicine.setExpirationDate(dateTemp);


        //图片处理
        if (medicineService.pictureHandler(medicine)) {

            if (medicineService.insertNewMedicine(medicine)) {
                modelAndView.addObject(Message.statusMsg,Message.ADD_SUCCESS);
            } else {
                modelAndView.addObject(Message.statusMsg,Message.ADD_FAIL);
            }

        } else {
            modelAndView.addObject(Message.statusMsg,Message.ADD_FAIL);
        }


        modelAndView.addObject("medicineList",medicineService.initList());

        modelAndView.setViewName("medicine/medicine-message");
        return modelAndView;
    }


    @RequestMapping("/test1")
    public ModelAndView test11(ModelAndView modelAndView) {

        modelAndView.setViewName("medicine/medicine-message");

        return modelAndView;
    }

}






















