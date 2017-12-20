package com.design.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InputController {

    @RequestMapping("/input")
    public ModelAndView input(ModelAndView modelAndView) {

        modelAndView.setViewName("input/input-init");


        return modelAndView;
    }
}
