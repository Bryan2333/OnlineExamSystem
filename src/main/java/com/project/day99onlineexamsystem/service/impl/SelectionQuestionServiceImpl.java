package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.day99onlineexamsystem.dao.PaperManageMapper;
import com.project.day99onlineexamsystem.dao.SelectionQuestionMapper;
import com.project.day99onlineexamsystem.pojo.PaperManage;
import com.project.day99onlineexamsystem.pojo.SelectionQuestion;
import com.project.day99onlineexamsystem.service.SelectionQuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelectionQuestionServiceImpl extends ServiceImpl<SelectionQuestionMapper, SelectionQuestion> implements SelectionQuestionService {
    @Resource
    private SelectionQuestionMapper selectionQuestionMapper;

    public List<SelectionQuestion> findByIdAndType(Integer paperId) {
        return selectionQuestionMapper.findByIdAndType(paperId);
    }


    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return selectionQuestionMapper.findBySubject(subject, pageNo);
    }

    @Override
    public SelectionQuestion findOnlyQuestionId() {
        return selectionQuestionMapper.findOnlyQuestionId();
    }
}
