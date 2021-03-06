package com.design.controller;

import com.design.entity.Supplier;
import com.design.enums.MessageEnum;
import com.design.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/supplierAdd")
    public ModelAndView supplierAdd(ModelAndView modelAndView) {

        modelAndView.setViewName("supplier/supplier-add");

        return modelAndView;
    }

    @RequestMapping(value="/supplierAddSubmit")

    public ModelAndView supplierAddSubmit(ModelAndView modelAndView, Supplier supplier){

        if (supplier.getSupplierName() == null || supplier.getSupplierName().length() <= 0 ||
                supplier.getImgFile() == null || supplier.getImgFile().length()<= 0){
            modelAndView.addObject( "message", MessageEnum.ADD_FAIL );
        } else{
            supplierService.pictureHandle( supplier );
            supplierService.addSuppliers( supplier.getSupplierName(),supplier.getSupplierPicture());

            modelAndView.addObject( "message", MessageEnum.SUCCESS );
        }
        modelAndView.setViewName( "supplier/supplier-message" );
        return modelAndView;
    }
}
