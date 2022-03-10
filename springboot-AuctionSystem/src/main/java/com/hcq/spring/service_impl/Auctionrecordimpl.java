package com.hcq.spring.service_impl;

import com.hcq.spring.domain.Auction;
import com.hcq.spring.domain.Auctionrecord;
import com.hcq.spring.mapper.AuctionMapper;
import com.hcq.spring.mapper.AuctionrecordMapper;
import com.hcq.spring.service.AuctionrecordService;
import com.hcq.spring.utils.AuctionPriceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class Auctionrecordimpl implements AuctionrecordService {

    @Autowired
    AuctionrecordMapper mapper;
    @Autowired
    AuctionMapper auctionMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer deleteByPrimary(Integer id) {
        return mapper.deleteByAuctionid(id);
    }

    @Override
    public Integer addAuctionrecord(Auctionrecord auctionrecord) throws Exception{
        Auction auction = auctionMapper.anctionamdauctionrecordbyuser(auctionrecord.getAuctionid());
        //  Date1.after(Date2),当Date1大于Date2时，返回TRUE，当小于等于时，返回false
        if (!auction.getAuctionendtime().after(new Date())) {
            throw new AuctionPriceException("该商品拍卖时间已经结束");
        }
        if (auction.getAuctionRecordList() != null && auction.getAuctionRecordList().size() > 0) {
            Auctionrecord auctionrecord_1 = auction.getAuctionRecordList().get(0);
            if (auctionrecord.getAuctionprice().compareTo(auctionrecord_1.getAuctionprice()) < 1) {
                throw new AuctionPriceException("竞拍价格必须高于当前最高的竞拍价格");
            }
        } else {
            if (auctionrecord.getAuctionprice().compareTo(auction.getAuctionstartprice()) < 1) {
                throw new AuctionPriceException("竞拍价格必须高于起拍价");
            }
        }
        return mapper.insert(auctionrecord);
    }
}
