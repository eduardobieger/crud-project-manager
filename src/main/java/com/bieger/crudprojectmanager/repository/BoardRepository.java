package com.bieger.crudprojectmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bieger.crudprojectmanager.model.BoardModel;

@Repository
public interface BoardRepository extends JpaRepository<BoardModel, Long> {
    
}
