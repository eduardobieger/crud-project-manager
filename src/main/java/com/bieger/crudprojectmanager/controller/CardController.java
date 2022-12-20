package com.bieger.crudprojectmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bieger.crudprojectmanager.model.CardModel;
import com.bieger.crudprojectmanager.service.CardService;

@Controller
@RequestMapping("/card")
public class CardController {
    
    private CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping
    public String findAllCards(Model model) {
        model.addAttribute("cards", cardService.findAll());
        return "cards";
    }

    @GetMapping("/{cardId}")
    public String findCardById(@PathVariable("cardId") Long id, Model model) {
        model.addAttribute("card", cardService.findById(id));
        return "card_id";
    }

    @GetMapping("/create_card")
    public String createCard(@RequestParam Long listId, Model model) {
        CardModel card = new CardModel();
        card.setListId(listId);
        model.addAttribute("card", card);
        return "create_card";
    }

    @PostMapping
    public String saveCard(@ModelAttribute("card") CardModel card) {
        cardService.create(card);
        return "redirect:/boards";
    }

    @PostMapping("/{cardId}")
    public String updateCard(@PathVariable("cardId") Long id, @ModelAttribute("card") CardModel card, Model model) {
        CardModel foundCard = cardService.findById(id);
        foundCard.setId(id);
        foundCard.setTitle(card.getTitle());
        foundCard.setDescription(card.getDescription());
        foundCard.setBackgroundColor(card.getBackgroundColor());
        foundCard.setListId(card.getListId());

        cardService.update(foundCard);
        return "redirect:/boards";
    }

    @GetMapping("/delete/{cardId}")
    public String deleteCard(@PathVariable("cardId") Long id) {
        cardService.delete(id);
        return "redirect:/boards";
    }
    
}
