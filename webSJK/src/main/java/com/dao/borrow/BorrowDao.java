package com.dao.borrow;

import com.domain.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowDao {
    @Select("select * from borrow where rdID=#{id}")
    List<Borrow> selectBorrowNumByID(int id);

    @Insert("insert into borrow(rdID,bkID,ldContinueTimes,ldDateOut,IdDateRetPan)" +
            " values(#{rdID},#{bkID},#{ldContinueTimes},#{ldDateOut},#{IdDateRetPan})")
   void insertBorrowInfo(@Param("rdID")int id,@Param("bkID")  int bkid,
                         @Param("ldContinueTimes")  int time,@Param("ldDateOut")  String date,@Param("IdDateRetPan")String dateret);



}
