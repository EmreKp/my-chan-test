package com.emrekp.githubpage.controller;

import com.emrekp.githubpage.Model.Message;
import com.emrekp.githubpage.Model.User;
import com.emrekp.githubpage.repo.MessageRepository;
import com.emrekp.githubpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class MainController {

    private final MessageRepository repository;
    private final UserService userService;

    @Autowired
    public MainController(MessageRepository repository, UserService userService) {
        this.repository = repository;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("posts", repository.findAll(new Sort(Sort.Direction.DESC, "id")));
        model.addAttribute("message", new Message());
        return "hello";
    }

    @PostMapping("/")
    public String deletePost(@RequestParam Long deleteId, @RequestParam String password,
                             RedirectAttributes redirectAttributes) {
        Message message = repository.findById(deleteId).get();
        String deletePass = message.getDeletePass();
        if (!deletePass.isEmpty() && message.getDeletePass().equals(password)) {
            repository.deleteById(deleteId);
            redirectAttributes.addFlashAttribute("success", "Post deleted");
        } else {
            redirectAttributes.addFlashAttribute("error", "Password is not valid");
        }
        return "redirect:/";
    }

    @PostMapping("/send")
    public String sendMsg(@ModelAttribute Message message, Model model) {
        message.setSentAt(new Date());
        repository.save(message);
        return "redirect:/";
    }

    @GetMapping("/register")
    public String regForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String regUser(@ModelAttribute User user, Model model) {
        userService.save(user);
        return "redirect:/";
    }
}
