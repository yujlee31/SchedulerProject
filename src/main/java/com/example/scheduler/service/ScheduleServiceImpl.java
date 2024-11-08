package com.example.scheduler.service;

import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;
import com.example.scheduler.entity.Schedule;
import com.example.scheduler.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getTitle(), requestDto.getContent(), requestDto.getUserId(), requestDto.getPasswd());
        return scheduleRepository.saveSchedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findAllSchedules(String edittime, Long userId) {
        List<ScheduleResponseDto> allSchedules = scheduleRepository.findAllSchedules(edittime, userId);

        return allSchedules;
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);
        return new ScheduleResponseDto(schedule);
    }

    @Transactional
    @Override
    public ScheduleResponseDto updateSchedule(Long id, String title, String content, Long userId, String passwd) {

        //passwd 일치해야 수정 가능하도록 처리
        String schedulePasswd = scheduleRepository.findScheduleByIdOrElseThrow(id).getPasswd();
        if (!schedulePasswd.equals(passwd)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong password for id=" + id);
        }

        int updatedRow = scheduleRepository.updateSchedule(id, title, content, userId);

        if (updatedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id=" + id);
        }

        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrow(id);

        return new ScheduleResponseDto(schedule);
    }

//    @Override
//    public ScheduleResponseDto updateTitle(Long id, String title, String content, Long userId) {
//        Schedule schedule = scheduleRepository.findScheduleById(id);
//
//        if (schedule == null) {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id="+id);
//        }
//
//        if (title == null || content != null) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
//        }
//
//        schedule.updateTitle(title);
//
//        return new ScheduleResponseDto(schedule);
//    }

    @Override
    public void deleteSchedule(Long id, String passwd) {
        //passwd 일치해야 수정 가능하도록 처리
        String schedulePasswd = scheduleRepository.findScheduleByIdOrElseThrow(id).getPasswd();
        if (!schedulePasswd.equals(passwd)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Wrong password for id=" + id);
        }

        int deletedRow = scheduleRepository.deleteSchedule(id);

        if (deletedRow == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id="+id);
        }
    }
}
