package com.faleite.trades.service;

import com.faleite.trades.dto.RequestDTO;
import com.faleite.trades.dto.ResponseDTO;
import com.faleite.trades.exceptions.ResourceNotFoundException;
import com.faleite.trades.model.TradeEntity;
import com.faleite.trades.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public List<ResponseDTO> getTrades(){
        return tradeRepository.findAll()
                .stream()
                .map(ResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ResponseDTO getTradeById(Long id){
        TradeEntity trade = tradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trade ID " +id+ " not found"));
        return ResponseDTO.fromEntity(trade);
    }

    public List<ResponseDTO> filterBy(String type, Long userId){
        List<TradeEntity> entity;

        if (type != null && userId != null){
            entity = tradeRepository.findByTypeAndUserId(type, userId);
        } else if (type != null) {
            entity = tradeRepository.findByType(type);
        }  else if (userId != null) {
            entity = tradeRepository.findByUserId(userId);
        } else {
            entity = tradeRepository.findAll();
        }
        return entity.stream()
                .map(ResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public ResponseDTO createNewTrade(RequestDTO requestDTO){
        TradeEntity entity = requestDTO.toEntity();
        TradeEntity saved = tradeRepository.save(entity);
        return ResponseDTO.fromEntity(saved);
    }

    public void deleteTradeById(Long id){
        if (!tradeRepository.existsById(id)){
            throw new ResourceNotFoundException("Trade ID " +id+ " not found");
        }
        tradeRepository.deleteById(id);
    }
}
