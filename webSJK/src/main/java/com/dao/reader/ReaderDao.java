package com.dao.reader;

import com.domain.Reader;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ReaderDao {
    @Select("select reader.* from reader,readertype where reader.rdName=#{name} and readertype.rdTypeName=#{type} and reader.rdDept=#{dept}")
    Reader selectReaderByName_type_Dept(@Param("name") String name, @Param("type") String rdType, @Param("dept") String rdDept);

    @Insert("insert into reader(rdID,rdName,rdSex,rdDept,rdPhone,rdEmail,rdDateReg,rdPhoto,rdStatus,rdBorrowQty,rdPwd,rdLeibie) values(#{rdID},#{rdName},#{rdSex},#{rdDept}," +
            "#{rdPhone},#{rdEmail},#{rdDateReg},#{rdPhoto},#{rdStatus},#{rdBorrowQty}" +
            ",#{rdPwd},#{rdLeibie})")
    void addReader(Reader   reader);

    @Update("update reader set rdName=#{rdName},rdSex=#{rdSex},rdDept=#{rdDept},rdPhone=#{rdPhone}," +
            "rdEmail=#{rdEmail},rdDateReg=#{rdDateReg},rdPhoto=#{rdPhoto},rdStatus=#{rdStatus}," +
            "rdBorrowQty=#{rdBorrowQty},rdPwd=#{rdPwd},rdLeibie=#{rdLeibie} where rdID=#{rdID}")
    void updateUserInfo(Reader reader);

    @Select("select rdPhoto reader where rdID=#{id}")
    String findPhotoByID(int id);

    @Select("select * from reader where rdID=#{id}")
    Reader findReaderByID(int id);

    /*@Select("select rdLeibie from reader where rdID=#{id}")
    String getRdLeibeiById(String id);*/

    @Update("update reader set rdStatus=#{status} where rdID=#{id}")
    int updateReaderStatusByID(@Param("status") String status,@Param("id") int id);

    @Delete("delete from reader where rdID=#{id}")
    int deleteReader(@Param("id") int id);
}
