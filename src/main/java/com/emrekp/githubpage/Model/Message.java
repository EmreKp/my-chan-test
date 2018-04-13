package com.emrekp.githubpage.Model;

import javax.persistence.*;

@Entity
public class Message extends Post {
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
