package com.emrekp.githubpage.service;

import com.emrekp.githubpage.Model.Message;
import com.emrekp.githubpage.Model.Reply;
import com.emrekp.githubpage.repo.MessageRepository;
import com.emrekp.githubpage.repo.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostService {
    private final MessageRepository msgRepo;
    private final ReplyRepository replyRepo;

    @Autowired
    public PostService(MessageRepository msgRepo, ReplyRepository replyRepo) {
        this.msgRepo = msgRepo;
        this.replyRepo = replyRepo;
    }

    public Message getMessage(Long id) {
        return msgRepo.findById(id).get();
    }

    public List<Reply> getReplies(Long messageId) {
        return replyRepo.findAllByMessageId(messageId);
    }

    public void replyToMessage(Reply reply) {
        reply.setSentAt(new Date());
        replyRepo.save(reply);
    }
}
