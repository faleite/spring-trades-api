package com.faleite.trades.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "trades")
public class TradeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;
    private Long userId;
    private String symbol;
    private Integer shares;
    private BigDecimal price;
//    private String timestamp;

    public TradeEntity() {
    }

    public TradeEntity(String type, Long userId, String symbol, Integer shares, BigDecimal price, String timestamp) {
        this.type = type;
        this.userId = userId;
        this.symbol = symbol;
        this.shares = shares;
        this.price = price;
//        this.timestamp = timestamp;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

//    public String getTimestamp() {
//        return timestamp;
//    }
//
//    public void setTimestamp(String timestamp) {
//        this.timestamp = timestamp;
//    }
}
