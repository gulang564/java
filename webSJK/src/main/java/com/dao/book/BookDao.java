package com.dao.book;

import com.domain.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookDao {
    @Insert("insert into book(" +
            "bkID," +
            "bkCode," +
            "bkName," +
            "bkAuthor," +
            "bkPress," +
            "bkDatePress," +
            "bkLanguage," +
            "bkPages," +
            "bkNum," +
            "bkDateIn," +
            "bkBrief," +
            "bkCover," +
            "bkStatus," +
            "bkLeibie)" +
            "values(#{bkID},#{bkCode},#{bkName},#{bkAuthor},#{bkPress},#{bkDatePress}," +
            "#{bkLanguage},#{bkPages},#{bkNum},#{bkDateIn},#{bkBrief},#{bkCover},#{bkStatus}," +
            "#{bkLeibie})")
   void addBook(Book book);

    @Select("select bkCover where bkCode=#{bkCode}")
    String findBkCoverByBkCode(String bkCode);



    @Update("update book set"+
            "bkID=#{bkID}," +
            "bkName=#{bkName}," +
            "bkAuthor=#{bkAuthor}," +
            "bkPress=#{bkPress}," +
            "bkDatePress=#{bkDatePress}," +
            "bkLanguage=#{bkLanguage}," +
            "bkPages=#{bkPages}," +
            "bkNum=#{bkNum}," +
            "bkDateIn=#{bkDateIn}," +
            "bkBrief=#{bkBrief}," +
            "bkCover=#{bkCover}," +
            "bkStatus=#{bkStatus}," +
            "bkLeibie=#{bkLeibie} where  bkCode=#{bkCode}")
    void UpdateBookInfo(Book book);


    @Select("select * from book where bkName like '%${value}%'")
    List<Book> findBookByBkName(String info);

    @Select("select * from book where bkAuthor LIKE '%${value}%'")
    List<Book> findBookByBkAuthor( String info);

    @Select("select *from book where  bkPress LIKE '%${value}%'")
    List<Book> findBookByBkPress(String info);

    @Select("<script> select * from book " +
            " <where> 1=1 " +
            " <if test=\"#{bookName} != null\"> AND bkName LIKE '%${bookName}%'</if> " +
            " <if test=\"#{AuthorName} != null\" >  AND bkAuthor LIKE '%${AuthorName}%'</if> " +
            " <if test=\"#{bookBrief} != null\" >  AND bkBrief LIKE '%${bookBrief}%'</if> " +
            " <if test=\"#{PressName} != null\" >  AND bkPress LIKE '%${PressName}%'</if> " +
            " <if test=\"#{sort} != null\" >  AND  bkLeibie LIKE '%${sort}%'</if> " +
            " <if test=\"#{PressDate} != null\" >  AND bkDatePress LIKE '%${PressDate}%'</if> " +
            " </where>" +
            "</script>"
           )
    List<Book> findBookBySelects(@Param("bookName")String bookName,
                                 @Param("AuthorName")String AuthorName,
                                 @Param("bookBrief")String bookBrief,
                                 @Param("PressName")String PressName,
                                 @Param("sort")String sort,
                                 @Param("PressDate")String PressDate
                                 );


    @Select("select *from book where bkID=#{id}")
    Book findBookByID(int id);

}
