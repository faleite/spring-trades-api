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

    /*@GetMapping
    public ResponseEntity<List<ResponseDTO>> getStocks(){


    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getStockById(@PathVariable Long id){

    }

    @GetMapping("/")
    public ResponseEntity<List<ResponseDTO>> filterBy(

    }

    @PostMapping
    public ResponseEntity<ResponseDTO> createNewSocket(){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSocketById(@PathVariable Long id){

    }*/

}
