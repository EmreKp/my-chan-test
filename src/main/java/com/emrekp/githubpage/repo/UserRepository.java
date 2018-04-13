package com.emrekp.githubpage.repo;

import com.emrekp.githubpage.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
