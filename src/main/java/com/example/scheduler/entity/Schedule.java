package com.example.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String title;
    private String content;
    private Long userId;
    private String passwd;
    private Date regTime;
    private Date editTime;

    public Schedule(String title, String content, Long userId, String passwd) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.passwd = passwd;
    }

    public Schedule(long id, String title, String content, long userId, String passwd) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.passwd = passwd;
    }

    public void update(String title, String content, Long userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }

    public void updateUser(Long userId) {
        this.userId = userId;
    }
}
