package com.faleite.trades.dto;

import com.faleite.trades.model.TradeEntity;

import java.math.BigDecimal;

public class ResponseDTO {

    private Long id;
    private String type;
    private Long userId;
    private String symbol;
    private Integer shares;
    private BigDecimal price;
//    private String timestamp;

    public ResponseDTO() {
    }

    public ResponseDTO(TradeEntity trade) {
        this.id = trade.getId();
        this.type = trade.getType();
        this.userId = trade.getUserId();
        this.symbol = trade.getSymbol();
        this.shares = trade.getShares();
        this.price = trade.getPrice();
//        this.timestamp = trade.getTimestamp();
    }

    public static  ResponseDTO fromEntity(TradeEntity trade){
        return new ResponseDTO(trade);
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public Long getUserId() {
        return userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public Integer getShares() {
        return shares;
    }

    public BigDecimal getPrice() {
        return price;
    }

//    public String getTimestamp() {
//        return timestamp;
//    }
}
