package com.bieger.crudprojectmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bieger.crudprojectmanager.model.BoardModel;
import com.bieger.crudprojectmanager.repository.BoardRepository;

@Service
public class BoardService {
    
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    
    public List<BoardModel> findAll() {
        return boardRepository.findAll();
    }

    public BoardModel findById(Long id) {
        return boardRepository.findById(id).get();
    }

    public BoardModel create(BoardModel board) {
        return boardRepository.save(board);
    }

    public BoardModel update(BoardModel board) {
        return boardRepository.save(board);
    }

    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

}
