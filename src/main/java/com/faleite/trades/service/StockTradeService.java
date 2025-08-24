package com.faleite.trades.service;

import com.faleite.trades.exceptions.ResourceNotFoundException;
import com.faleite.trades.model.StockTrade;
import com.faleite.trades.repository.StockTradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockTradeService {

    private final StockTradeRepository stockTradeRepository;

    public StockTradeService(StockTradeRepository stockTradeRepository) {
        this.stockTradeRepository = stockTradeRepository;
    }

    public StockTrade createNewStock(StockTrade stockTrade){
        return stockTradeRepository.save(stockTrade);
    }

    public List<StockTrade> getStock(){
        return stockTradeRepository.findAll();
    }

    public StockTrade getStockById(Long id){
        return stockTradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock ID " +id+ " not found"));
    }

}
