package com.example.deal.controller;

import com.example.deal.dto.DealRequest;
import com.example.deal.dto.DealResponse;
import com.example.deal.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deals")
public class DealController {

    private final DealService dealService;

    @Autowired
    public DealController(DealService dealService) {
        this.dealService = dealService;
    }

    @PostMapping
    public ResponseEntity<DealResponse> createDeal(@Validated @RequestBody DealRequest request) {
        DealResponse response = dealService.createDeal(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<DealResponse>> getAllDeal() {
        List<DealResponse> response = dealService.getAll();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DealResponse> getDealById(@PathVariable Long id) {
        DealResponse response = dealService.getDealById(id);
        return ResponseEntity.ok(response);
    }
}
