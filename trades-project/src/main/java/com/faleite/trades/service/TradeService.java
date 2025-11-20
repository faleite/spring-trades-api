package com.faleite.trades.service;

import com.faleite.trades.dto.RequestDTO;
import com.faleite.trades.dto.ResponseDTO;
import com.faleite.trades.exceptions.ResourceNotFoundException;
import com.faleite.trades.model.StockTrade;
import com.faleite.trades.repository.StockTradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeService {

    private final StockTradeRepository stockTradeRepository;

    public TradeService(StockTradeRepository stockTradeRepository) {
        this.stockTradeRepository = stockTradeRepository;
    }


   /* public List<ResponseDTO> getStocks(){

    }

    public ResponseDTO getStockById(Long id){

    }

    public List<ResponseDTO> filterBy(String type, Long userId){

    }

    public ResponseDTO createNewStock(
    }

    public void deleteStockById(Long id){

    }*/
}
