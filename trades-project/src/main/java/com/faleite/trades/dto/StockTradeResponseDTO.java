package com.faleite.trades.dto;

import com.faleite.trades.model.StockTrade;

public class StockTradeResponseDTO {

    private Long id;
    private String type;
    private Long userId;
    private String symbol;
    private Integer shares;
    private Double price;
    private Long timestamp;

    public StockTradeResponseDTO() {}

    // Construtor a partir da Entity
    public StockTradeResponseDTO(StockTrade stockTrade) {
        this.id = stockTrade.getId();
        this.type = stockTrade.getType();
        this.userId = stockTrade.getUserId();
        this.symbol = stockTrade.getSymbol();
        this.shares = stockTrade.getShares();
        this.price = stockTrade.getPrice();
        this.timestamp = stockTrade.getTimestamp();
    }

    // Método estático para conversão
    public static StockTradeResponseDTO fromEntity(StockTrade stockTrade) {
        return new StockTradeResponseDTO(stockTrade);
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

    public Double getPrice() {
        return price;
    }

    public Long getTimestamp() {
        return timestamp;
    }
}
