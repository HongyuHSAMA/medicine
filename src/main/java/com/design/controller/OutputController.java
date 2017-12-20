package com.design.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OutputController {

    @RequestMapping("/output")
    public ModelAndView output(ModelAndView modelAndView) {

        modelAndView.setViewName("output/output-init");


        return modelAndView;
    }

}
