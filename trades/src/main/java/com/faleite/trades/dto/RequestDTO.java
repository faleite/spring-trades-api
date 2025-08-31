package com.faleite.trades.dto;

import com.faleite.trades.model.TradeEntity;

import java.math.BigDecimal;

public class RequestDTO {

    private String type;
    private Long userId;
    private String symbol;
    private Integer shares;
    private BigDecimal price;

    public RequestDTO() {
    }

    public TradeEntity toEntity(){
        TradeEntity entity = new TradeEntity();
        entity.setType(this.type);
        entity.setUserId(this.userId);
        entity.setSymbol(this.symbol);
        entity.setShares(this.shares);
        entity.setPrice(this.price);
        return entity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Integer getShares() {
        return shares;
    }

    public void setShares(Integer shares) {
        this.shares = shares;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
