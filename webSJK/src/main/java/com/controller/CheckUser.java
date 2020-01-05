package com.controller;

import com.dao.reader.ReaderDao;
import com.domain.Reader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CheckUser {
    @Autowired
    ReaderDao readerDao;

    @ResponseBody
    @RequestMapping("/getUserMessage")
    public Reader getUserMessage(HttpServletRequest request){

        String username=request.getParameter("username");
        System.out.println(username);

        String userType=request.getParameter("userType");
        System.out.println(userType);

        String danwei=request.getParameter("danwei");
        System.out.println(danwei);

       Reader reader= readerDao.selectReaderByName_type_Dept(username, userType, danwei);

        System.out.println(reader);
        /*      一个巨型的坑
        springmvc中的@ResponseBody 返回的如果不是对象的话，只有null； ajax用什么方式都无法判断结果的类型
        *
        * 怎么判断怎么错，直接new 一个空对象回去就ok 了，网上这个比较浪费时间，但是这个是比较直接方式了
        * 如果返回null 用ajax 中的 json接收， jquery也无法判断这个对象是不是对象。输出是，什么都没有
        * */
       return reader==null?new Reader():reader;


    }

    @RequestMapping("/check")
    public  String checkUser(){
        return "tushuchaxun";
    }
}
