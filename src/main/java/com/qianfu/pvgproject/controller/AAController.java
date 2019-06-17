package com.qianfu.pvgproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AAController {

    @RequestMapping("/index")
    public ModelAndView test01() {
        ModelAndView mv = new ModelAndView("/index");
        return mv;
    }

    @RequestMapping("/cameraManager")
    public ModelAndView test02(){
        ModelAndView mv = new ModelAndView("/page/news/newsList.html");
        return mv;
    }
}
