package com.hcq.spring.service;

import com.hcq.spring.domain.Auction;

import java.util.List;

public interface AuctionService {

    List<Auction> getAllActions(Auction auction);

    Integer addAction(Auction auction);

    Integer updateAction(Auction auction);

    Auction selectByid(Integer id);


    Integer deleteByPrimaryKey(Integer id);

    Auction anctionamdauctionrecordbyuser(int auctionId);

    List<Auction> findAuctionEndedGoods();

    List<Auction> findAuctionFinishedEndGoods();
}
