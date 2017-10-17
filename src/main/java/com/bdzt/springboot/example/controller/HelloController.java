package com.bdzt.springboot.example.controller;

import com.bdzt.springboot.example.model.Country;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * hello控制类
 * @author zhanghongbing
 * @date 2017-10-11
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "/index")
    public ModelAndView getAll(Country country) {
        ModelAndView result = new ModelAndView("hello/index");
        result.addObject("name", "张三");
        return result;
    }

}
