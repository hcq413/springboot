package com.hcq.spring.mapper;

import com.hcq.spring.domain.Auction;
import com.hcq.spring.domain.AuctionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AuctionMapper {
    long countByExample(AuctionExample example);

    int deleteByExample(AuctionExample example);

    int deleteByPrimaryKey(Integer auctionid);

    int insert(Auction record);

    int insertSelective(Auction record);

    List<Auction> selectByExample(AuctionExample example);

    Auction selectByPrimaryKey(Integer auctionid);

    int updateByExampleSelective(@Param("record") Auction record, @Param("example") AuctionExample example);

    int updateByExample(@Param("record") Auction record, @Param("example") AuctionExample example);

    int updateByPrimaryKeySelective(Auction record);

    int updateByPrimaryKey(Auction record);

    Auction anctionamdauctionrecordbyuser(@Param("auctionId") int id);

    List<Auction> AuctionEndedGoods();

    List<Auction> AuctionFinishedEndGoods();
}