package com.bieger.crudprojectmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bieger.crudprojectmanager.model.ListModel;
import com.bieger.crudprojectmanager.repository.ListRepository;

@Service
public class ListService {
    
    private final ListRepository listRepository;

    public ListService(ListRepository listRepository) {
        this.listRepository = listRepository;
    }
    
    public List<ListModel> findAll() {
        return listRepository.findAll();
    }

    public ListModel findById(Long id) {
        return listRepository.findById(id).get();
    }

    public ListModel create(ListModel list) {
        return listRepository.save(list);
    }

    public ListModel update(ListModel list) {
        return listRepository.save(list);
    }

    public void delete(Long id) {
        listRepository.deleteById(id);
    }

}
