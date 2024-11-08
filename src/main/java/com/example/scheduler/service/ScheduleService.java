package com.example.scheduler.service;

import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);

    List<ScheduleResponseDto> findAllSchedules(String edittime, Long userId);

    ScheduleResponseDto findScheduleById(Long id);

    ScheduleResponseDto updateSchedule(Long id, String title, String content, Long userId, String passwd);

//    ScheduleResponseDto updateTitle(Long id, String title, String content, Long userId);

//    ScheduleResponseDto updateContent(Long id, String title, String content, Long userId);

//    ScheduleResponseDto updateUser(Long id, String title, String content, Long userId);

    void deleteSchedule(Long id, String passwd);
}

