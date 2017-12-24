package com.design.controller;

import com.design.dao.MedicineDao;
import com.design.entity.Medicine;
import com.design.entity.Message;
import com.design.enums.MessageEnum;
import com.design.service.MedicineService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        modelAndView.setViewName( "welcome" );

        return modelAndView;
    }

    @RequestMapping("/medicineList")
    public ModelAndView medicineList(ModelAndView modelAndView) {

        modelAndView.addObject( "medicineList", medicineService.initList() );

        modelAndView.setViewName( "medicine/medicine-list" );
        return modelAndView;
    }

    @RequestMapping("/medicineAdd")
    public ModelAndView medicineAdd(ModelAndView modelAndView) {

        modelAndView.addObject( "suppliers", medicineService.queryAllSupplier() );

        modelAndView.setViewName( "medicine/medicine-add" );
        return modelAndView;
    }

    @RequestMapping("/medicineShow")
    public ModelAndView medicineShow(ModelAndView modelAndView) {
        modelAndView.setViewName( "medicine/medicine-show" );
        return modelAndView;
    }

    @RequestMapping("/medicineAddSubmit")
    public ModelAndView medicineAddSubmit(ModelAndView modelAndView, Medicine medicine) throws ParseException {

        if ("".equals( medicine.getProductionStringDate() ) || medicine.getProductionStringDate() == null) {
            modelAndView.addObject( Message.statusMsg, Message.DATE_ERROR );
            modelAndView.addObject( "medicineList", medicineService.initList() );
            modelAndView.setViewName( "medicine/medicine-message" );
            return modelAndView;
        }
        if ("".equals( medicine.getImgFile() ) || medicine.getImgFile() == null) {
            modelAndView.addObject( Message.statusMsg, Message.PICTURE_ERROR );
            modelAndView.addObject( "medicineList", medicineService.initList() );
            modelAndView.setViewName( "medicine/medicine-message" );
            return modelAndView;
        }

        //将字符串换成Date
        Date dateTemp = new SimpleDateFormat( "yyyy-MM-dd" ).parse( medicine.getProductionStringDate() );
        medicine.setProductionDate( dateTemp );

        //生产日期+保质期=过期日期
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime( dateTemp );
        gregorianCalendar.add( 1, medicine.getExpirationIntegerDate() );
        gregorianCalendar.set( gregorianCalendar.get( Calendar.YEAR ), gregorianCalendar.get( Calendar.MONTH ), gregorianCalendar.get( Calendar.DATE ) );

        //设置过期日期
        dateTemp = gregorianCalendar.getTime();
        medicine.setExpirationDate( dateTemp );


        //图片处理
        if (medicineService.pictureHandler( medicine )) {

            if (medicineService.insertNewMedicine( medicine )) {
                modelAndView.addObject( Message.statusMsg, Message.ADD_SUCCESS );
            } else {
                modelAndView.addObject( Message.statusMsg, Message.ADD_FAIL );
            }

        } else {
            modelAndView.addObject( Message.statusMsg, Message.ADD_FAIL );
        }


        modelAndView.addObject( "medicineList", medicineService.initList() );

        modelAndView.setViewName( "medicine/medicine-message" );
        return modelAndView;
    }


    @RequestMapping("/medicineDelete")
    @ResponseBody
    public Map<String, String> medicineDelete(@RequestBody Medicine medicine) {


        Map<String, String> map = new HashMap<>();


        Long medicineId = medicine.getMedicineId();
        try {
            if (medicineId != null) {
                if (medicineService.deleteMedicineById( medicineId )) {

                    map.put( Message.statusMsg, Message.DELETE_SUCCESS.getMsg() );
                } else {
                    map.put( Message.statusMsg, Message.DELETE_FAIL.getMsg() );
                }
            } else {
                map.put( Message.statusMsg, Message.ERROR.getMsg() );
            }

        } catch (Exception e) {
            map.put( Message.statusMsg, Message.DELETE_ERROR.getMsg() );
        }
        return map;
    }

    @RequestMapping(value = "/deleteMore", method = {RequestMethod.POST})
    @ResponseBody
    public Map<String, String> medicineDeleteMore(HttpServletRequest request) {
        Map<String, String> returnMessage = new HashMap<>();
        //TODO 先做简单删除，再检测错误信息
        String items = request.getParameter( "itemList" );

        String[] item = items.split( "," );
        long medicineId;
        for (String s : item) {
            medicineId = (long) Integer.valueOf( s );
            System.out.println( medicineId );
            if (medicineService.deleteMedicineById( medicineId )) {
                returnMessage.put( "message", MessageEnum.SUCCESS.getStateInfo() );

            } else {
                returnMessage.put( "message", s+":"+MessageEnum.DELETE_FAIL.getStateInfo() );
            }
        }
        for (String s : returnMessage.values()) {
            System.out.println( s );
        }
        System.out.println( returnMessage );
        return returnMessage;
    }

    @RequestMapping("/member-show/{medicineId}")
    public ModelAndView medicineInfoShow(ModelAndView modelAndView, @PathVariable("medicineId") String medicineId) throws ParseException {

        long medicineIdL = Integer.valueOf( medicineId );
        Medicine medicine = medicineDao.queryById( medicineIdL );

        //时间格式转换
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );


        medicine.setProductionStringDate( format.format( medicine.getProductionDate() ) );
        medicine.setExpirationStringDate( format.format( medicine.getExpirationDate() ) );

        modelAndView.addObject( "medicine", medicine );

        modelAndView.setViewName( "medicine/medicine-show1" );

        return modelAndView;
    }


}






















