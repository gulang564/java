package com.controller.borrow;

import com.dao.book.BookDao;
import com.dao.borrow.BorrowDao;
import com.dao.reader.ReaderDao;
import com.dao.readerType.ReaderTypeDao;
import com.domain.Book;
import com.domain.Borrow;
import com.domain.Reader;
import com.domain.ReaderType;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BorrowInfo {
    @Autowired
    ReaderDao readerDao;
    @Autowired
    ReaderTypeDao readerTypeDao;
    @Autowired
    BookDao bookDao;

    @Autowired
    BorrowDao borrowDao;

    @RequestMapping("submitBorrowInfo")
    @ResponseBody
    public Map submitBorrowInfo(HttpServletRequest request) {


        String jieyuehao=request.getParameter("jieyuehao");
        System.out.println(jieyuehao);

        String tushuhao=request.getParameter("tushuhao");
        System.out.println(tushuhao);
        String jieyueriqi=request.getParameter("jieyueriqi");
        System.out.println(jieyueriqi);

        borrowDao.insertBorrowInfo(Integer.parseInt(jieyuehao),Integer.parseInt(tushuhao),
                0,jieyueriqi,"");

        Map map=new HashMap();
        map.put("success","成功");
        return map ;

    }

    /*@RequestMapping("borrowBook")
    public void borrowBook(HttpServletRequest request) {
        String jieyuahao=request.getParameter("");
        System.out.println(jieyuahao);

        String tushuhao=request.getParameter("");
        System.out.println(jieyuahao);

        String riqi=request.getParameter("");
        System.out.println(jieyuahao);

    }*/
}
