package com.faleite.trades.repository;

import com.faleite.trades.model.TradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<TradeEntity, Long> {

    List<TradeEntity> findByType(String type);
    List<TradeEntity> findByUserId(Long userId);
    List<TradeEntity> findByTypeAndUserId(String type, Long UserId);
}
