package com.typeconverter.controller;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class FormatterController {

    @GetMapping("/formatter/edit")
    public String formatterForm(Model model) {
        Form form = new Form();
        form.setNumber(10000);
        form.setLocalDateTime(LocalDateTime.now());
        model.addAttribute("form", form);
        return "formatter-form";
    }

    @PostMapping("/formatter/edit")
    public String formatterEdit(@ModelAttribute Form form) { // model에 자동으로 담김
        return "formatter-view";
    }

    @Data
    static class Form {
        @NumberFormat(pattern = "###,###") // Spring 기본제공 formatter
        private Integer number;

        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") // Spring 기본제공 formatter
        private LocalDateTime localDateTime;
    }

}
