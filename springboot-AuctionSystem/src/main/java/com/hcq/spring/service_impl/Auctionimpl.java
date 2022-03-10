package com.hcq.spring.service_impl;

import com.hcq.spring.domain.Auction;
import com.hcq.spring.domain.AuctionExample;
import com.hcq.spring.mapper.AuctionMapper;
import com.hcq.spring.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class Auctionimpl implements AuctionService {

    @Autowired
    AuctionMapper mapper;

    @Override
    public ArrayList<Auction> getAllActions(Auction auction) {
        AuctionExample example = new AuctionExample();
        AuctionExample.Criteria criteria = example.createCriteria();
        if (auction != null) {
            //商品名称,描述都是模糊查询
            if (auction.getAuctionname() != null && !"".equals(auction.getAuctionname())) {
                criteria.andAuctionnameLike("%" + auction.getAuctionname() + "%");
            }
            if (auction.getAuctiondesc() != null && !"".equals(auction.getAuctiondesc())) {
                criteria.andAuctiondescLike("%" + auction.getAuctiondesc() + "%");
            }
            //起始时间 >
            if (auction.getAuctionstarttime() != null) {
                criteria.andAuctionstarttimeGreaterThan(auction.getAuctionstarttime());
            }
            //结束时间<
            if (auction.getAuctionendtime() != null) {
                criteria.andAuctionendtimeLessThan(auction.getAuctionendtime());
            }
            //起拍价
            if (auction.getAuctionstartprice() != null) {
                criteria.andAuctionstartpriceGreaterThan(auction.getAuctionstartprice());
            }
            //起拍时间降序排序
            example.setOrderByClause("auctionstarttime desc");
        }
        return (ArrayList<Auction>) mapper.selectByExample(example);
    }

    @Override
    public Integer addAction(Auction auction) {
        return mapper.insert(auction);
    }

    @Override
    public Integer updateAction(Auction auction) {
        return mapper.updateByPrimaryKey(auction);
    }

    @Override
    public Auction selectByid(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Auction anctionamdauctionrecordbyuser(int auctionId) {
        return mapper.anctionamdauctionrecordbyuser(auctionId);
    }

    @Override
    public ArrayList<Auction> findAuctionEndedGoods() {
        return (ArrayList<Auction>) mapper.AuctionEndedGoods();
    }

    @Override
    public ArrayList<Auction> findAuctionFinishedEndGoods() {
        return (ArrayList<Auction>) mapper.AuctionFinishedEndGoods();
    }
}
