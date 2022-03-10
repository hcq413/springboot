package com.hcq.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Auction {
    private Integer auctionid;

    private String auctionname;

    private BigDecimal auctionstartprice;

    private BigDecimal auctionupset;

    private Date auctionstarttime;

    private Date auctionendtime;

    private String auctionpic;

    private String auctionpictype;

    private String auctiondesc;

    private List<Auctionrecord> auctionRecordList;

}