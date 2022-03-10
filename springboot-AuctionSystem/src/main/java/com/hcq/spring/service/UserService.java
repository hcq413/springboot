package com.hcq.spring.service;

import com.hcq.spring.domain.Auctionuser;

public interface UserService {

    Auctionuser Login(String username, String password);

    Integer UserRegistered(Auctionuser user);

    boolean isExist(String username);

    Auctionuser LoginByUser(String username);
}
