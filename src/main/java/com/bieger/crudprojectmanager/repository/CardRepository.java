package com.bieger.crudprojectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bieger.crudprojectmanager.model.CardModel;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
    
}
