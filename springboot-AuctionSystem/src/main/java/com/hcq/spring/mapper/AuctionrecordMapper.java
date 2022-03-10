package com.hcq.spring.mapper;

import com.hcq.spring.domain.Auctionrecord;
import com.hcq.spring.domain.AuctionrecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuctionrecordMapper {
    long countByExample(AuctionrecordExample example);

    int deleteByExample(AuctionrecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Auctionrecord record);

    int insertSelective(Auctionrecord record);

    List<Auctionrecord> selectByExample(AuctionrecordExample example);

    Auctionrecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Auctionrecord record, @Param("example") AuctionrecordExample example);

    int updateByExample(@Param("record") Auctionrecord record, @Param("example") AuctionrecordExample example);

    int updateByPrimaryKeySelective(Auctionrecord record);

    int updateByPrimaryKey(Auctionrecord record);

    int deleteByAuctionid(@Param("auctionid")Integer auctionid);


}