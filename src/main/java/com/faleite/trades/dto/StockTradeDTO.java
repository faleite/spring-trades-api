package com.faleite.trades.dto;

import com.faleite.trades.model.StockTrade;

import javax.swing.text.html.parser.Entity;

public class StockTradeDTO {

    private Long id;
    private String type;
    private Long userId;
    private String symbol;
    private Integer shares;
    private Double price;

    public StockTradeDTO() {
    }

    public StockTradeDTO(StockTrade stockTrade) {
        this.id = stockTrade.getId();
        this.type = stockTrade.getType();
        this.userId = stockTrade.getUserId();
        this.symbol = stockTrade.getSymbol();
        this.shares = stockTrade.getShares();
        this.price = stockTrade.getPrice();
    }

    // Método estático para conversão (alternativa ao construtor)
    public static StockTradeDTO fromEntity(StockTrade stockTrade){
        return new StockTradeDTO(stockTrade);
    }

    // Método para converter DTO em Entity
    public StockTrade toEntity(){
        StockTrade stockTrade = new StockTrade();
        stockTrade.setId(this.id);
        stockTrade.setType(this.type);
        stockTrade.setUserId(this.userId);
        stockTrade.setSymbol(this.symbol);
        stockTrade.setShares(this.shares);
        stockTrade.setPrice(this.price);

        // Note: timestamp não está no DTO, então você pode definir aqui ou no service
        // stockTrade.setTimestamp(System.currentTimeMillis());
        return stockTrade;
    }

    public Long getId() {
        return id;
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
