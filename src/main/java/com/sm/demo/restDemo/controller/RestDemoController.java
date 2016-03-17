package com.sm.demo.restDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Newbody on 2016/2/27.
 */
@Controller
public class RestDemoController {

    @RequestMapping("demo/rest/test1")
    @ResponseBody
    public String test1(){
        return "rest demo";
    }

}
