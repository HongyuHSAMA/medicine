package com.design.controller;


import com.design.dao.WorkerDao;
import com.design.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class LoginAndLogoutController {

    @Autowired
    private WorkerDao workerDao;

    @RequestMapping("/")
//    @RequestMapping(value="/login")
    public ModelAndView welcome(ModelAndView modelAndView){

        modelAndView.setViewName("login");

        return modelAndView;
    }

    @RequestMapping(value="/index")
    public ModelAndView loginForm(ModelAndView modelAndView, String workerId, String workerPassword,
                                  HttpSession session) {
        //TODO 交由前端控制输入字段
        if (workerId == null || "".equals(workerId) ||
                workerPassword == null || workerPassword.length() <= 0){
            modelAndView.setViewName( "login" );
            return modelAndView;
        }
        //格式转换
        long workerId1 = Integer.valueOf( workerId );

        //判断是否有次id的账号，并判断密码是否正确
        if (workerDao.queryById( workerId1 ) != null
                && workerPassword.equals( workerDao.queryById( workerId1 ).getWorkerPassword() )){
            session.setAttribute( "worker",workerDao.queryById( workerId1 ) );
            modelAndView.setViewName("index");
        }else {
            modelAndView.addObject( "error",1 );

            modelAndView.setViewName( "login" );
        }
        return modelAndView;
    }

    @RequestMapping(value="/logout")
    public ModelAndView logout(ModelAndView modelAndView, HttpSession session){

        session.setAttribute( "worker1",session.getAttribute( "worker" ) );

        session.removeAttribute( "worker" );

        modelAndView.setViewName( "login" );

        return modelAndView;
    }
}
