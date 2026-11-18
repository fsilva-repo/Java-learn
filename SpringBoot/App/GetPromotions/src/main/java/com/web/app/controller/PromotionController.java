package com.web.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.app.domain.Category;
import com.web.app.repository.CategoryRepository;

@Controller
@RequestMapping("/promocao")
public class PromotionController {
  @Autowired
  CategoryRepository categoryRepository;
  public List<Category> getCategoryRepository() {
    return categoryRepository.findAll();
  }
  @GetMapping("/add")
  public String openRegister() {
    return "promo-add";
  }
}
