package com.faleite.trades.dto;

import com.faleite.trades.model.StockTrade;

public class StockTradeRequestDTO {

    private String type;
    private Long userId;
    private String symbol;
    private Integer shares;
    private Double price;

    public StockTradeRequestDTO() {}

    // Converter DTO -> Entity
    public StockTrade toEntity() {
        StockTrade stockTrade = new StockTrade();
        stockTrade.setType(this.type);
        stockTrade.setUserId(this.userId);
        stockTrade.setSymbol(this.symbol);
        stockTrade.setShares(this.shares);
        stockTrade.setPrice(this.price);
        return stockTrade;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
