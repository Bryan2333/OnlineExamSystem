package com.project.day99onlineexamsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.project.day99onlineexamsystem.pojo.Score;

import java.util.List;

public interface ScoreService extends IService<Score> {
    List<Score> findByStudentId(Integer studentId);
}
