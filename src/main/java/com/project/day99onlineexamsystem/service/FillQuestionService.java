package com.project.day99onlineexamsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.day99onlineexamsystem.pojo.FillQuestion;

import java.util.List;

public interface FillQuestionService extends IService<FillQuestion> {
    List<FillQuestion> findByIdAndType(Integer paperId);

    List<Integer> findBySubject(String subject, Integer pageNo);

    FillQuestion findOnlyQuestionId();
}
