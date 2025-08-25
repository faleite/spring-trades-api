package com.faleite.trades.controller;

import com.faleite.trades.dto.StockTradeDTO;
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
    public ResponseEntity<List<StockTradeDTO>> getStocks(){
        List<StockTradeDTO> trades = stockTradeService.getStocks();
        return ResponseEntity.ok(trades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStockById(@PathVariable Long id){
        StockTradeDTO trade = stockTradeService.getStockById(id);
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

    @PostMapping
    public ResponseEntity<StockTradeDTO> createNewStock(@RequestBody StockTradeDTO stockTradeDTO){
        StockTradeDTO created = stockTradeService.createNewStock(stockTradeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStockById(@PathVariable Long id){
        stockTradeService.deleteStockTradeById(id);
        return ResponseEntity.noContent().build();
    }

}
