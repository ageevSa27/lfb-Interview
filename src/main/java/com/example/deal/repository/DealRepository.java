package com.example.deal.repository;

import com.github.javafaker.Faker;
import model.Deal;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DealRepository {
    private static final Map<Long, Deal> STORAGE = new HashMap<>();

    private static final Faker faker = new Faker();

    public Deal saveDeal(Deal deal) {
        if (getById(deal.getId()) != null) {
            throw new IllegalArgumentException("Сделка с  id '%s' уже есть".formatted(deal.getId()));
        }

        Long id = faker.number().randomNumber();
        deal.setId(id);

        STORAGE.put(id, deal);

        return deal;
    }

    public Deal getById(Long id) {
        return STORAGE.get(id);
    }

    public List<Deal> getAll(){
        return new ArrayList<>(STORAGE.values());
    }
}
