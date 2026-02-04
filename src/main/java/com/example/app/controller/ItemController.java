package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.repository.ItemRepository;
import com.example.app.model.Item;

@Controller
public class ItemController {

  private final ItemRepository repo;

  public ItemController(ItemRepository repo) {
    this.repo = repo;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("items", repo.findAll());
    return "index";
  }

  @PostMapping("/add")
  public String add(@RequestParam String name) {
    Item item = new Item();
    item.setName(name);
    repo.save(item);
    return "redirect:/";
  }
}
