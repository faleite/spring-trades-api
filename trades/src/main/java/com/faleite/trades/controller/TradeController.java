package com.faleite.trades.controller;

import com.faleite.trades.dto.RequestDTO;
import com.faleite.trades.dto.ResponseDTO;
import com.faleite.trades.service.TradeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trades")
public class TradeController {

    private final TradeService tradeService;

    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> getTrades(){
        List<ResponseDTO> trades = tradeService.getTrades();
        return ResponseEntity.ok(trades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTradeById(@PathVariable Long id){
        ResponseDTO trade = tradeService.getTradeById(id);
        return ResponseEntity.ok(trade);
    }

    @GetMapping("/")
    public ResponseEntity<?> filterBy(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) Long userId){

        if (type != null || userId != null){
            return ResponseEntity.ok(tradeService.filterBy(type, userId));
        }
        return ResponseEntity.ok(tradeService.getTrades());
    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createNewTrade(@RequestBody RequestDTO requestDTO){
        ResponseDTO created = tradeService.createNewTrade(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTradeById(@PathVariable Long id){
        tradeService.deleteTradeById(id);
        return ResponseEntity.noContent().build();
    }
}
