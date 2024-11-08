package com.example.scheduler.controller;

import com.example.scheduler.dto.ScheduleRequestDto;
import com.example.scheduler.dto.ScheduleResponseDto;
import com.example.scheduler.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ScheduleResponseDto> findAllSchedules(@RequestBody ScheduleRequestDto requestDto) {
        return scheduleService.findAllSchedules(requestDto.getEdittime(), requestDto.getUserId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long id,
                                                              @RequestBody ScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id, requestDto.getTitle(), requestDto.getContent(), requestDto.getUserId(), requestDto.getPasswd()), HttpStatus.OK);
    }

//    @PatchMapping("/{id}")
//    public ResponseEntity<ScheduleResponseDto> updateTitle(@PathVariable Long id,
//                                                           @RequestBody ScheduleRequestDto requestDto) {
//        return new ResponseEntity<>(scheduleService.updateTitle(id, requestDto.getTitle(), requestDto.getContent(), requestDto.getUserId()), HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id,
                                               @RequestBody ScheduleRequestDto requestDto) {
        scheduleService.deleteSchedule(id, requestDto.getPasswd());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
