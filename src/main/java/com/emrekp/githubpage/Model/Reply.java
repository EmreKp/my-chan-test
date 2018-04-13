package com.emrekp.githubpage.Model;

import javax.persistence.*;

@Entity
public class Reply extends Post {
    private Long messageId;

    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }
}
