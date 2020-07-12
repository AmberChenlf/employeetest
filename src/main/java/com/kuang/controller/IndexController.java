package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author bingqiong.cbb
 * @date 2020-07-06 21:29
 **/
@Controller

public class IndexController {
    @RequestMapping("/index.html")
   public String index(){
        System.out.println("index");
        return "index";

    }
}
