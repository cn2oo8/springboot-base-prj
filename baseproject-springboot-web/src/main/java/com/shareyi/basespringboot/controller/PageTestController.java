package com.shareyi.basespringboot.controller;

import com.shareyi.basespringboot.common.web.CommonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * 页面功能
 *
 * @author david
 * @date 2018/3/28
 */
@Controller
@RequestMapping("/")
public class PageTestController {


    @RequestMapping(value = "/error", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String error(ModelMap context) {
        return "templates/error.html";
    }

    @RequestMapping(value = "/vmHello")
    public String vmHello(ModelMap context) {
        context.put("hello", "Hello world");
        context.put("now", new Date());
        return "hello";
    }


    @RequestMapping(value = "/hello")
    @ResponseBody
    public Map error() {
        return CommonResult.create().succeed().getReturnMap();
    }
}
