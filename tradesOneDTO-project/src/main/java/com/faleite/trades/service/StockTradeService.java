package com.faleite.trades.service;

import com.faleite.trades.dto.StockTradeDTO;
import com.faleite.trades.exceptions.ResourceNotFoundException;
import com.faleite.trades.model.StockTrade;
import com.faleite.trades.repository.StockTradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockTradeService {

    private final StockTradeRepository stockTradeRepository;

    public StockTradeService(StockTradeRepository stockTradeRepository) {
        this.stockTradeRepository = stockTradeRepository;
    }

    public List<StockTradeDTO> getStocks(){
        return stockTradeRepository.findAll()
                .stream()
                .map(StockTradeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public StockTradeDTO getStockById(Long id){
        StockTrade entity = stockTradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock ID " +id+ " not found"));
        return StockTradeDTO.fromEntity(entity);
    }

    public StockTradeDTO createNewStock(StockTradeDTO stockTradeDTO){
        StockTrade entity = stockTradeDTO.toEntity();
        StockTrade saved = stockTradeRepository.save(entity);
        return StockTradeDTO.fromEntity(saved);
    }

    public List<StockTradeDTO> filterBy(String type, Long userId){
        List<StockTrade> entity;

        if (type != null && userId != null){
            entity = stockTradeRepository.findByTypeAndUserId(type, userId);
        } else if (type != null){
            entity = stockTradeRepository.findByType(type);
        } else if (userId != null){
            entity = stockTradeRepository.findByUserId(userId);
        } else {
            entity = stockTradeRepository.findAll();
        }
        return entity.stream()
                .map(StockTradeDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteStockTradeById(Long id){
        if (!stockTradeRepository.existsById(id)){
            throw new ResourceNotFoundException("Stock ID " +id+ " not found");
        }
        stockTradeRepository.deleteById(id);
    }

}
