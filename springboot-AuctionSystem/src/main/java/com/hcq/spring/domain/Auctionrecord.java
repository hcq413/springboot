package com.hcq.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auctionrecord {
    private Integer id;

    private Integer userid;

    private Integer auctionid;

    private Date auctiontime;

    private BigDecimal auctionprice;

    private Auctionuser auctionUser;
}