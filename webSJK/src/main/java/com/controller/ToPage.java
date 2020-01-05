package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToPage {
    @RequestMapping("duzheML")
    public String duzheML(){
        return "duzheML";
    }

    @RequestMapping("tushuML")
    public String tushuML(){
        return "tushuML";
    }

    @RequestMapping("jieyueML")
    public String jieyueML(){
        return "jieyueML";
    }

    @RequestMapping("user")
    public String yonghuML(){
        return "user";
    }

    @RequestMapping("tushuchaxun")
    public String tushuchaxun(){
        return "tushuchaxun";
    }

}
