package com.example.deal.service;

import com.example.deal.dto.DealRequest;
import com.example.deal.dto.DealResponse;
import com.example.deal.ex.DealNotFoundException;
import com.example.deal.repository.DealRepository;
import model.Deal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class DealService {

    private final DealRepository dealRepository;

    @Autowired
    public DealService(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    public List<DealResponse> getAll() {
        var deals = dealRepository.getAll();
        return deals.stream().map(this::convertToResponse).toList();
    }

    public DealResponse createDeal(DealRequest request) {
        Deal deal = new Deal();
        deal.setCreatedAt(LocalDateTime.now());
        deal.setTitle(request.getTitle());
        deal.setDescription(request.getDescription());
        deal.setAmount(request.getAmount());
        deal.setCustomerName(request.getCustomerName());
        deal.setCustomerEmail(request.getCustomerEmail());
        deal.setStatus(request.getStatus());

        Deal savedDeal = dealRepository.saveDeal(deal);
        return convertToResponse(savedDeal);
    }

    private DealResponse convertToResponse(Deal deal) {
        DealResponse response = new DealResponse();
        response.setId(deal.getId());
        response.setTitle(deal.getTitle());
        response.setDescription(deal.getDescription());
        response.setAmount(deal.getAmount());
        response.setStatus(deal.getStatus());
        response.setCustomerName(deal.getCustomerName());
        response.setCustomerEmail(deal.getCustomerEmail());
        response.setCreatedAt(deal.getCreatedAt());
        response.setUpdatedAt(deal.getUpdatedAt());
        return response;
    }

    public DealResponse getDealById(Long id) {
        Deal deal = dealRepository.findById(id)
                .orElseThrow(() -> new DealNotFoundException("Deal not found with id: " + id));
        return convertToResponse(deal);
    }

}
