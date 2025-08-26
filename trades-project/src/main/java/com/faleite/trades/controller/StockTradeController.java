package com.faleite.trades.controller;

import com.faleite.trades.dto.StockTradeRequestDTO;
import com.faleite.trades.dto.StockTradeResponseDTO;
import com.faleite.trades.service.StockTradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class StockTradeController {

    private final StockTradeService stockTradeService;

    public StockTradeController(StockTradeService stockTradeService) {
        this.stockTradeService = stockTradeService;
    }

    @GetMapping
    public ResponseEntity<List<StockTradeResponseDTO>> getStocks(){
        List<StockTradeResponseDTO> trades = stockTradeService.getStocks();
        return ResponseEntity.ok(trades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStockById(@PathVariable Long id){
        StockTradeResponseDTO trade = stockTradeService.getStockById(id);
        return ResponseEntity.ok(trade);
    }

    @GetMapping("/")
    public ResponseEntity<?> getStockByFilter(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Long userId){

        if (type != null || userId != null){
            return ResponseEntity.ok(stockTradeService.filterBy(type, userId));
        }
        return ResponseEntity.ok(stockTradeService.getStocks());
    }

    /* Outros tipos de return
     // Se comporta igual mas é mais antigo
     return new ResponseEntity<>(created, HttpStatus.CREATED);

     // Outra forma
     URI location = URI.create("/stocks/" + created.getId());
     return ResponseEntity.created(location).body(created);
     */
    @PostMapping
    public ResponseEntity<StockTradeResponseDTO> createNewStock(@RequestBody StockTradeRequestDTO stockTradeRequestDTO){
        StockTradeResponseDTO created = stockTradeService.createNewStock(stockTradeRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockById(@PathVariable Long id){
        stockTradeService.deleteStockTradeById(id);
        return ResponseEntity.noContent().build();
    }

}
