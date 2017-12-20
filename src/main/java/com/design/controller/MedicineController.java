package com.design.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class MedicineController {
    @RequestMapping(value = "/index")
        public ModelAndView test1() {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("index");


            return modelAndView;
        }

    @RequestMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");

        return modelAndView;
    }

    @RequestMapping("/medicineList")
    public ModelAndView medicineList(ModelAndView modelAndView) {
        modelAndView.setViewName("medicine/medicine-list");
        return modelAndView;
    }
    @RequestMapping("/medicineAdd")
    public ModelAndView medicineAdd(ModelAndView modelAndView) {
        modelAndView.setViewName("medicine/medicine-add");
        return modelAndView;
    }
    @RequestMapping("/medicineShow")
    public ModelAndView medicineShow(ModelAndView modelAndView) {
        modelAndView.setViewName("medicine/medicine-show");
        return modelAndView;
    }
}
