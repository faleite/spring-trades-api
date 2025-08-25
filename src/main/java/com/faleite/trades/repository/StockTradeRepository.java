package com.faleite.trades.repository;

import com.faleite.trades.model.StockTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockTradeRepository extends JpaRepository<StockTrade, Long> {

    List<StockTrade> findByType(String type);
    List<StockTrade> findByUserId(Long userId);
    List<StockTrade> findByTypeAndUserId(String type, Long userId);
}
