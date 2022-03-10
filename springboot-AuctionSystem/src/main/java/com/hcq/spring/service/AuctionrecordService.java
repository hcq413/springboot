package com.hcq.spring.service;

import com.hcq.spring.domain.Auctionrecord;

public interface AuctionrecordService {

    Integer deleteByPrimary(Integer id);

    Integer addAuctionrecord(Auctionrecord auctionrecord) throws Exception;
}
