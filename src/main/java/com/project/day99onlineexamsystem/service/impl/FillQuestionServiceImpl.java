package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.day99onlineexamsystem.dao.FillQuestionMapper;
import com.project.day99onlineexamsystem.dao.PaperManageMapper;
import com.project.day99onlineexamsystem.pojo.FillQuestion;
import com.project.day99onlineexamsystem.pojo.PaperManage;
import com.project.day99onlineexamsystem.pojo.SelectionQuestion;
import com.project.day99onlineexamsystem.service.FillQuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FillQuestionServiceImpl extends ServiceImpl<FillQuestionMapper, FillQuestion> implements FillQuestionService {
    @Resource
    private FillQuestionMapper fillQuestionMapper;

    public List<FillQuestion> findByIdAndType(Integer paperId) {
        return fillQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return fillQuestionMapper.findBySubject(subject, pageNo);
    }

    @Override
    public FillQuestion findOnlyQuestionId() {
        return fillQuestionMapper.findOnlyQuestionId();
    }
}
