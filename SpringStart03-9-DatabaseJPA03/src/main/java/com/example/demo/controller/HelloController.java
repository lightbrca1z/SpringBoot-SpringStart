package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entry.Person;
import com.example.demo.repository.PersonRepository;

import javax.annotation.PostConstruct;

import java.util.Optional;

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
    
    @PostConstruct
    public void init() {
    	//１つ目のダミーデーター作成。
    	Person p1 = new Person();
    	p1.setName("taro");
    	p1.setAge(39);
    	p1.setMail("taro@yamada");
    	repository.saveAndFlush(p1);
    	//2つ目のダミーデーター作成。
    	Person p2 = new Person();
    	p2.setName("hanako");
    	p2.setAge(28);
    	p2.setMail("hanako@flower");
    	repository.saveAndFlush(p2);
    	//１つ目のダミーデーター作成。
    	Person p3 = new Person();
    	p3.setName("sachiko");
    	p3.setAge(17);
    	p3.setMail("sachico@happy");
    	repository.saveAndFlush(p3);
    }
    
    @GetMapping("/edit/{id}")
    public ModelAndView editForm(@PathVariable("id") Long id, ModelAndView mav) {
        mav.setViewName("edit");
        mav.addObject("title", "edit Person.");
        Optional<Person> data = repository.findById(id);
        mav.addObject("formModel", data.orElseThrow());
        return mav;
    }

    // 更新（Update）
    @PostMapping("/edit")
    @Transactional
    public ModelAndView update(@ModelAttribute("formModel") Person person) {
        repository.save(person);
        return new ModelAndView("redirect:/");
    }
    
    // 削除確認画面（GET /delete/{id}）
    @GetMapping("/delete/{id}")
    public ModelAndView deleteForm(@PathVariable("id") Long id, ModelAndView mav) {
        mav.setViewName("delete");
        mav.addObject("title", "Delete Person.");
        mav.addObject("msg", "Can I delete this record?");
        Optional<Person> data = repository.findById(id);
        mav.addObject("formModel", data.orElseThrow());
        return mav;
    }
    
    @PostMapping("/reset")
    @Transactional
    public ModelAndView reset() {
        repository.truncateTable();   // 全件削除 + auto_increment初期化
        return new ModelAndView("redirect:/");
    }

}
