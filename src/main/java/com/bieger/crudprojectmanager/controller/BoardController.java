package com.bieger.crudprojectmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bieger.crudprojectmanager.model.BoardModel;
import com.bieger.crudprojectmanager.service.BoardService;

@Controller
@RequestMapping("/boards")
public class BoardController {

    private final BoardService boardService;
    
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public String findAllBoards(Model model) {
        model.addAttribute("boards", boardService.findAll());
        return "boards";
    }

    @GetMapping("/{boardId}")
    public String findBoardById(@PathVariable("boardId") Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "board_id";
    }

    @GetMapping("/create_board")
    public String createBoard(Model model) {
        BoardModel board = new BoardModel();
        model.addAttribute("board", board);
        return "create_board";
    }

    @PostMapping
    public String saveBoard(@ModelAttribute("board") BoardModel board) {
        boardService.create(board);
        return "redirect:/boards";
    }

    @GetMapping("/edit/{boardId}")
    public String editBoardById(@PathVariable("boardId") Long id, Model model) {
        model.addAttribute("board", boardService.findById(id));
        return "edit_board_id";
    }

    @PostMapping("/{boardId}")
    public String updateBoard(@PathVariable("boardId") Long id, @ModelAttribute("board") BoardModel board, Model model) {
        BoardModel foundBoard = boardService.findById(id);
        foundBoard.setId(id);
        foundBoard.setTitle(board.getTitle());
        foundBoard.setBackgroundColor(board.getBackgroundColor());

        boardService.update(foundBoard);
        return "redirect:/boards";
    }

    @GetMapping("/delete/{boardId}")
    public String deleteBoard(@PathVariable("boardId") Long id) {
        boardService.delete(id);
        return "redirect:/boards";
    }
    
}
