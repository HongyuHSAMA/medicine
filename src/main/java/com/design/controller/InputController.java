package com.design.controller;

import com.design.entity.Message;
import com.design.entity.Replenish;
import com.design.service.ReplenishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class InputController {

    @Autowired
    private ReplenishService replenishService;


    @RequestMapping("/input")
    public ModelAndView input(ModelAndView modelAndView) {

        modelAndView.addObject( "medicines", replenishService.queryAllMedicineNameAndId() );
        modelAndView.addObject( "workers", replenishService.queryAllWorkerNameAndId() );
        modelAndView.setViewName( "input/input-init" );
        return modelAndView;
    }

    @RequestMapping("/inputSubmit")
    public ModelAndView inputSubmit(ModelAndView modelAndView, Replenish replenish) {

        if ("".equals( replenish.getCreateStringTime() ) || replenish.getCreateStringTime() == null) {
            modelAndView.addObject( Message.statusMsg, Message.DATE_ERROR );
        } else {
            if (replenishService.addNewReplenish( replenish )) {
                modelAndView.addObject( Message.statusMsg, Message.ADD_SUCCESS );
            }
        }

        modelAndView.setViewName( "input/input-message" );


        return modelAndView;
    }

    @RequestMapping(value="/input-list")
    public ModelAndView inputList(ModelAndView modelAndView){

        modelAndView.addObject( "inputList",replenishService.getReplenishAll() );
        modelAndView.setViewName( "input/input-list" );
        return modelAndView;
    }

}
