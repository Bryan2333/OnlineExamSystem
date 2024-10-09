package com.project.day99onlineexamsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.day99onlineexamsystem.pojo.SelectionQuestion;

import java.util.List;

public interface SelectionQuestionService extends IService<SelectionQuestion> {
    List<SelectionQuestion> findByIdAndType(Integer paperId);

    List<Integer> findBySubject(String subject, Integer pageNo);

    SelectionQuestion findOnlyQuestionId();
}
