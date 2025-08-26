package com.faleite.trades.service;

import com.faleite.trades.dto.StockTradeRequestDTO;
import com.faleite.trades.dto.StockTradeResponseDTO;
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

    // Listar todos os trades → sempre devolve ResponseDTO
    public List<StockTradeResponseDTO> getStocks(){
        return stockTradeRepository.findAll()
                .stream()
                .map(StockTradeResponseDTO::fromEntity) // Entity → ResponseDTO
                .collect(Collectors.toList());
    }

    // Buscar por ID → retorna ResponseDTO
    public StockTradeResponseDTO getStockById(Long id){
        StockTrade entity = stockTradeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock ID " +id+ " not found"));
        return StockTradeResponseDTO.fromEntity(entity);
    }

    // Criar novo trade → recebe RequestDTO, salva entity, retorna ResponseDTO
    public StockTradeResponseDTO createNewStock(StockTradeRequestDTO stockTradeRequestDTO){
        StockTrade entity = stockTradeRequestDTO.toEntity();  // RequestDTO → Entity
        StockTrade saved = stockTradeRepository.save(entity);
        return StockTradeResponseDTO.fromEntity(saved); // Entity → ResponseDTO
    }

    // Filtro → sempre retorna ResponseDTO
    public List<StockTradeResponseDTO> filterBy(String type, Long userId){
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
                .map(StockTradeResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public void deleteStockTradeById(Long id){
        if (!stockTradeRepository.existsById(id)){
            throw new ResourceNotFoundException("Stock ID " +id+ " not found");
        }
        stockTradeRepository.deleteById(id);
    }

}
