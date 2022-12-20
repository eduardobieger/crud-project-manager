package com.bieger.crudprojectmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bieger.crudprojectmanager.model.ListModel;
import com.bieger.crudprojectmanager.service.ListService;

@Controller
@RequestMapping("/list")
public class ListController {
    
    private final ListService listService;

    public ListController(ListService boardListService) {
        this.listService = boardListService;
    }
    
    @GetMapping
    public String findAllLists(Model model) {
        model.addAttribute("list", listService.findAll());
        return "list";
    }

    @GetMapping("/{listId}")
    public String findBoardById(@PathVariable("listId") Long id, Model model) {
        model.addAttribute("list", listService.findById(id));
        return "list_id";
    }

    @GetMapping("/create_list")
    public String createList(@RequestParam Long boardId, Model model) {
        ListModel list = new ListModel();
        list.setBoardId(boardId);
        model.addAttribute("list", list);
        return "create_list";
    }

    @PostMapping
    public String saveList(@ModelAttribute("list") ListModel list) {
        listService.create(list);
        return "redirect:/boards";
    }

    @PostMapping("/{listId}")
    public String updateList(@PathVariable("listId") Long id, @ModelAttribute("list") ListModel list, Model model) {
        ListModel foundList = listService.findById(id);
        foundList.setId(id);
        foundList.setTitle(list.getTitle());
        
        listService.update(foundList);
        return "redirect:/boards";
    }

    @GetMapping("/delete/{listId}")
    public String deleteList(@PathVariable("listId") Long id) {
        listService.delete(id);
        return "redirect:/boards";
    }

}
