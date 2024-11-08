package com.example.scheduler.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    //private Long id;
    private String title;
    private String content;
    private Long userId;
    private String passwd;
    private String edittime;
}
