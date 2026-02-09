package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entry.Person;
import com.example.demo.repository.PersonRepository;

@Controller
public class HelloController {

    @Autowired
    private PersonRepository repository;

    // 一覧表示
    @GetMapping("/")
    public ModelAndView index(ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("title", "Hello Spring!");
        mav.addObject("msg", "this is JPA sample data.");

        Iterable<Person> list = repository.findAll();
        mav.addObject("data", list);

        // フォーム用の空オブジェクト
        mav.addObject("formModel", new Person());

        return mav;
    }

    // 追加（Create）
    @PostMapping("/")
    @Transactional
    public ModelAndView create(@ModelAttribute("formModel") Person person) {
        // ★IDは通常セットしない（@GeneratedValueならnullのままでOK）
        repository.save(person);
        return new ModelAndView("redirect:/");
    }

    // 削除（Delete）
    @PostMapping("/delete")
    @Transactional
    public ModelAndView delete(@RequestParam("id") Long id) {
        repository.deleteById(id);
        return new ModelAndView("redirect:/");
    }
    
    @PostMapping("/reset")
    @Transactional
    public ModelAndView reset() {
        repository.truncateTable();   // 全件削除 + auto_increment初期化
        return new ModelAndView("redirect:/");
    }
}
