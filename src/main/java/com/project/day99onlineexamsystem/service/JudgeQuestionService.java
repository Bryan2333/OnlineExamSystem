package com.project.day99onlineexamsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.day99onlineexamsystem.pojo.JudgeQuestion;

import java.util.List;

public interface JudgeQuestionService extends IService<JudgeQuestion> {

    List<JudgeQuestion> findByIdAndType(Integer paperId);

    List<Integer> findBySubject(String subject, Integer pageNo);

    JudgeQuestion findOnlyQuestionId();
}
