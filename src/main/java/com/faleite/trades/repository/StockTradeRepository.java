package com.faleite.trades.repository;

import com.faleite.trades.model.StockTrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockTradeRepository extends JpaRepository<StockTrade, Long> {
}
