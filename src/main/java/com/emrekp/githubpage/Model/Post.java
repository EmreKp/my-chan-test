package com.emrekp.githubpage.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String nick;
    @Lob
    private String text;
    private Date sentAt;
    private String deletePass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getText() {
        return text;
    }

    public void setText(String message) {
        this.text = message;
    }

    public Date getSentAt() {
        return sentAt;
    }

    public void setSentAt(Date sentAt) {
        this.sentAt = sentAt;
    }

    public String getDeletePass() {
        return deletePass;
    }

    public void setDeletePass(String deletePass) {
        this.deletePass = deletePass;
    }
}
