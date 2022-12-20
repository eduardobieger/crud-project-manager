package com.bieger.crudprojectmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bieger.crudprojectmanager.model.CardModel;
import com.bieger.crudprojectmanager.repository.CardRepository;

@Service
public class CardService {
    
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<CardModel> findAll() {
        return cardRepository.findAll();
    }
    
    public CardModel findById(Long id){
        return cardRepository.findById(id).get();
    }

    public CardModel create(CardModel card) {
        return cardRepository.save(card);
    }

    public CardModel update(CardModel card) {
        return cardRepository.save(card);
    }

    public void delete(Long id) {
        cardRepository.deleteById(id);
    }
    
}
