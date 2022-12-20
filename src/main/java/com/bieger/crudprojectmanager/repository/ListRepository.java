package com.bieger.crudprojectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bieger.crudprojectmanager.model.ListModel;

@Repository
public interface ListRepository extends JpaRepository<ListModel, Long> {
    
}
