package com.emrekp.githubpage.repo;

import com.emrekp.githubpage.Model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
