package com.design.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SupplierController {

    @RequestMapping("/supplierAdd")
    public ModelAndView supplierAdd(ModelAndView modelAndView) {

        modelAndView.setViewName("supplier/supplier-add");


        return modelAndView;
    }
}
