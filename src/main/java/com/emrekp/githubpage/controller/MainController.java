package com.emrekp.githubpage.controller;

import com.emrekp.githubpage.Model.Message;
import com.emrekp.githubpage.repo.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class MainController {

    private final MessageRepository repository;

    @Autowired
    public MainController(MessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", repository.findAll(new Sort(Sort.Direction.DESC, "id")));
        model.addAttribute("message", new Message());
        return "hello";
    }

    @PostMapping("/send")
    public String sendMsg(@ModelAttribute Message message, Model model) {
        message.setSentAt(new Date());
        repository.save(message);
        return "redirect:/";
    }
}
