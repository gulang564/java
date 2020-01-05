package com.dao.readerType;

import com.domain.ReaderType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ReaderTypeDao {
    @Select("select *from readertype")
    List<ReaderType> findAllReaderType();

    @Select("select * from readertype where rdTypeName=#{leibie}")
    ReaderType selectLendQtyByReaderType(String leibie);

    @Select("select PunishRate from readertype where rdTypeName=#{leibie}")
    double getPunishRateByReaderType(String leibie);
}
