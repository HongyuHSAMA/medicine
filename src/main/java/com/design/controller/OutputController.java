package com.design.controller;

import com.design.entity.Bills;
import com.design.entity.Message;
import com.design.service.BillsService;
import com.design.service.ReplenishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OutputController {


    @Autowired
    private ReplenishService replenishService;

    @Autowired
    private BillsService billsService;

    @RequestMapping("/output")
    public ModelAndView output(ModelAndView modelAndView) {

        modelAndView.addObject("medicines",replenishService.queryAllMedicineNameAndId());
        modelAndView.addObject("workers",replenishService.queryAllWorkerNameAndId());

        modelAndView.setViewName("output/output-init");
        return modelAndView;
    }


    @RequestMapping("/outputSubmit")
    public ModelAndView outputSubmit(ModelAndView modelAndView, Bills bills) {

        if ("".equals(bills.getCreateStringTime()) || bills.getCreateStringTime() == null) {
            modelAndView.addObject(Message.statusMsg,Message.DATE_ERROR);
        } else {
            if (billsService.addNewBills(bills)) {
                modelAndView.addObject(Message.statusMsg,Message.ADD_SUCCESS);
            }
        }

        modelAndView.setViewName("output/output-message");

        return modelAndView;
    }

    @RequestMapping(value="/output-list")
    public ModelAndView inputList(ModelAndView modelAndView){

        modelAndView.addObject( "outputList", billsService.getBillsList());
        modelAndView.setViewName( "output/output-list" );

        return modelAndView;
    }

}
