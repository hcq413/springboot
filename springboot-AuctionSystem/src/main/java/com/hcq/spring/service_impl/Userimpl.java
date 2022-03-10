package com.hcq.spring.service_impl;

import com.hcq.spring.domain.Auctionuser;
import com.hcq.spring.domain.AuctionuserExample;
import com.hcq.spring.mapper.AuctionuserMapper;
import com.hcq.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userimpl implements UserService {

    @Autowired
    AuctionuserMapper mapper;

    @Override
    public Auctionuser Login(String username, String password) {
        AuctionuserExample example = new AuctionuserExample();
        AuctionuserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andUserpasswordEqualTo(password);
        List<Auctionuser> byExample = mapper.selectByExample(example);
        if (byExample != null && byExample.size() > 0) {
            return byExample.get(0);
        }
        return null;
    }

    @Override
    public Integer UserRegistered(Auctionuser user) {
        user.setUserisadmin(0);
        return mapper.insert(user);
    }

    @Override
    public boolean isExist(String username) {
        AuctionuserExample example = new AuctionuserExample();
        AuctionuserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Auctionuser> byExample = mapper.selectByExample(example);
        if (byExample != null && byExample.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Auctionuser LoginByUser(String username) {
        AuctionuserExample example = new AuctionuserExample();
        AuctionuserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Auctionuser> byExample = mapper.selectByExample(example);
        if (byExample != null && byExample.size() > 0) {
            return byExample.get(0);
        }
        return null;
    }
}
