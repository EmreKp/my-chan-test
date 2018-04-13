package com.emrekp.githubpage.service;

import com.emrekp.githubpage.Model.User;
import com.emrekp.githubpage.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepo;

    private final BCryptPasswordEncoder bCrypt;

    @Autowired
    public UserService(UserRepository userRepo, BCryptPasswordEncoder bCrypt) {
        this.userRepo = userRepo;
        this.bCrypt = bCrypt;
    }

    public void save(User user) {
        user.setPassword(bCrypt.encode(user.getPassword()));
        user.setRole("user"); //roles will be specified by admin later if necessary
        userRepo.save(user);
    }

    public User findByNick(String nick) {
        return userRepo.findByUsername(nick);
    }
}
