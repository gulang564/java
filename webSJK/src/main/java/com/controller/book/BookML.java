package com.controller.book;

import com.dao.book.BookDao;
import com.dao.borrow.BorrowDao;
import com.dao.reader.ReaderDao;
import com.dao.readerType.ReaderTypeDao;
import com.domain.*;
import com.utis.CountTimes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class BookML {
    @Autowired
    BookDao bookDao;
    @Autowired
    ReaderDao readerDao;
    @Autowired
    ReaderTypeDao readerTypeDao;
    @Autowired
    BorrowDao borrowDao;

    @RequestMapping("/addBook")
    public String addBook(MultipartFile fileUpload,Book book){
        /*当数据封装不上的时候就需要考虑，是不是数据类型不匹配的问题*/
        System.out.println(fileUpload);
        System.out.println(book);
        try {
            if(fileUpload!=null){
                //截取文件格式
                System.out.println(fileUpload.getOriginalFilename());

                int begin = fileUpload.getOriginalFilename().indexOf(".");
                int last = fileUpload.getOriginalFilename().length();
                String s = fileUpload.getOriginalFilename().substring(begin, last);
                String imgname= UUID.randomUUID().toString().replace("-","");

               /* //创建一个新文件，
                String name=Integer.toString(max+1);
                File excelFile=File.createTempFile(name,s);*/

                book.setBkCover("./UserImg/"+imgname+s);

                bookDao.addBook(book);

                fileUpload.transferTo(new File("E:\\javaAllPractice\\images\\"+imgname+s));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  "tushuML";
    }

    @RequestMapping("/updateBookInfo")
    public String updateBookInfo(MultipartFile fileUpload,Book book){
        try {
            if(fileUpload!=null){
                //截取文件格式fg

                int begin = fileUpload.getOriginalFilename().indexOf(".");
                int last = fileUpload.getOriginalFilename().length();
                String s = fileUpload.getOriginalFilename().substring(begin, last);
                String imgname= UUID.randomUUID().toString().replace("-","");

               /* //创建一个新文件，
                String name=Integer.toString(max+1);
                File excelFile=File.createTempFile(name,s);*/
                book.setBkCover("./UserImg/"+imgname+s);
                bookDao.addBook(book);
                fileUpload.transferTo(new File("E:\\javaAllPractice\\images\\"+imgname+s));

            }else {

                /*根据图书编码来更新图书*/
                String Cover=bookDao.findBkCoverByBkCode(book.getBkCode());
                book.setBkCover(Cover);
                bookDao.UpdateBookInfo(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "tushuML";
    }

    @ResponseBody
    @RequestMapping("/findBook")
    public List<Book>  findBook(HttpServletRequest request){

        String field= request.getParameter("field");
        String Info=request.getParameter("Info");
        System.out.println(field+"----------"+Info);
        /*
        *  <option>书名</option>
           <option>作者</option>
           <option>出版社</option>
        * */
       List<Book> book=null;
        if ("书名".equals(field)){
            System.out.println("已经进入这里");
            book=bookDao.findBookByBkName(Info);

        }else if ("作者".equals(field)){
            book=   bookDao.findBookByBkAuthor(Info);
        }else {
            book=  bookDao.findBookByBkPress(Info);
        }
        System.out.println(book);
        return book;
    }

    @ResponseBody
    @RequestMapping("/findBookBySelects")
    public List<Book> findBookBySelects(HttpServletRequest request){

     String bookName=  request.getParameter("bookName");
        System.out.println("bookName==="+bookName);
     if (bookName.equals(""))
     {
         bookName=null;
     }

     String AuthorName=  request.getParameter("AuthorName");
        System.out.println("AuthorName==="+AuthorName);

        if (AuthorName.equals(""))
        {
            AuthorName=null;
        }


     String bookBrief= request.getParameter("bookBrief");
        System.out.println("bookBrief==="+bookBrief);
        if (bookBrief.equals(""))
        {
            bookBrief=null;
        }


     String PressName=  request.getParameter("PressName");
        System.out.println("PressName==="+PressName);
        if (PressName.equals(""))
        {
            PressName=null;
        }


     String sort=  request.getParameter("sort");
        System.out.println("sort==="+sort);
        if (sort.equals(""))
        {
            sort=null;
        }


     String PressDate= request.getParameter("PressDate");
        System.out.println("PressDate==="+PressDate);
        if (PressDate.equals(""))
        {
            PressDate=null;
        }

     List<Book> books= bookDao.findBookBySelects(bookName,AuthorName,bookBrief,PressName, sort,PressDate);
     return books;
    }

    @ResponseBody
    @RequestMapping("findManyInfo")
    public Map findManyInfo(HttpServletRequest request){
        Map map=new HashMap();

        String jieyuehao=request.getParameter("jieyuehao");
        Reader reader=readerDao.findReaderByID(Integer.parseInt(jieyuehao));
        String name=reader.getRdName();
        String dept=reader.getRdDept();
        String leibie=reader.getRdLeibie();

        map.put("name",name);
        map.put("dept",dept);
        map.put("leibie",leibie);

        ReaderType readerType= readerTypeDao.selectLendQtyByReaderType(leibie);
        int CanLendbookNum=readerType.getCanLendQty();
        map.put("CanLendbookNum",CanLendbookNum);

        int lendDay=readerType.getCanLendDay();
        map.put("lendDay",lendDay);

        List<Borrow> borrows=borrowDao.selectBorrowNumByID(Integer.parseInt(jieyuehao));
        System.out.println();

        List<ZongHe> zongHeList=new ArrayList<>();

        if (borrows.size()!=0){
            System.out.println("非空");
            int hasLendBookNum = borrows.size();
            map.put("hasLendBookNum",hasLendBookNum);

            for (int i = 0; i < hasLendBookNum; i++) {
                ZongHe zongHe=new ZongHe();
                Book book =bookDao.findBookByID(borrows.get(i).getBkID());
                zongHe.setBookID(book.getBkID());
                zongHe.setBookName(book.getBkName());
                zongHe.setBookAuth(book.getBkAuthor());

                String dateOut=borrows.get(i).getLdDateOut();
                System.out.println("dateout======》"+dateOut);

                String[] dates= dateOut.split("-");

                int cishu=borrows.get(i).getLdContinueTimes();
                System.out.println("借阅次数==>"+cishu);
                zongHe.setXujiecishu(cishu);

                zongHe.setJieyueriqi(borrows.get(i).getLdDateOut());

                Integer year;
                Integer  month;

                System.out.println(dates[0]+"|"+dates[1]+"|"+dates[2]);
/*当次数为0的时候其实需要它为1，这个乘30才能得到下一次的时间*/
                //从这就开始加1了
                cishu=cishu+1;
                if(Integer.parseInt(dates[1])+cishu >12){
                    System.out.println("进入第1个");

                    month=Integer.parseInt(dates[1])-12+cishu;
                    System.out.println(month);

                    dates[1]= month.toString();
                     year = Integer.parseInt(dates[0])+1;
                    System.out.println(year);
                    dates[0]=year.toString();

                }else {
                    System.out.println("进入第2个");
                    month=Integer.parseInt(dates[1])+cishu;
                    System.out.println(month);
                    year = Integer.parseInt(dates[0]);
                    System.out.println(year);
                }
               /* zongHe.setYinghuanriqi(dates[0]+"-"+dates[1]+"-"+dates[2]);*/

                /*格式转换必须是年月日时分秒都要算*/
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                System.out.println("开始转换");
                LocalDateTime startTime = LocalDateTime.parse(borrows.get(i).getLdDateOut()+" 00:00:00",df);


                LocalDateTime endTime = startTime.plusDays((cishu+1)*30);

                System.out.println("开始时间：" + startTime.format(df) + "，结束时间：" + endTime.format(df));

                /*这个就是到期时间*/
                String daoqishijian=endTime.format(df);


                String endbefore=endTime.format(df);
                System.out.println("过期开始=======>"+endbefore);
                zongHe.setYinghuanriqi(endbefore);


                System.out.println("最终的时间");
                LocalDateTime end =  LocalDateTime.now();
                System.out.println(end.toString().substring(0,10));

               // String endtime=end.format(df);


                /*这个就是过期时间*/
                int days= CountTimes.countDay(endbefore,end.toString().substring(0,10));
                zongHe.setChaoqitianshu(days);
                System.out.println(days);

                /*超期天数算出来后，就要算价钱了*/
                double fajing=readerTypeDao.getPunishRateByReaderType(leibie);
                double allfajing=days*fajing;
                zongHe.setChaoqijinge(allfajing);


                zongHeList.add(zongHe);
            }
            map.put("zonghe",zongHeList);

        }else {
            System.out.println("空");
            map.put("hasLendBookNum","0");
        }


        return map;

    }

}
