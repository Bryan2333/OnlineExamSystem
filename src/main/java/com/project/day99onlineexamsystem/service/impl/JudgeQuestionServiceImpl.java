package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.day99onlineexamsystem.dao.JudgeQuestionMapper;
import com.project.day99onlineexamsystem.dao.PaperManageMapper;
import com.project.day99onlineexamsystem.pojo.FillQuestion;
import com.project.day99onlineexamsystem.pojo.JudgeQuestion;
import com.project.day99onlineexamsystem.pojo.PaperManage;
import com.project.day99onlineexamsystem.service.JudgeQuestionService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JudgeQuestionServiceImpl extends ServiceImpl<JudgeQuestionMapper, JudgeQuestion> implements JudgeQuestionService {
    @Resource
    private JudgeQuestionMapper judgeQuestionMapper;

    public List<JudgeQuestion> findByIdAndType(Integer paperId) {
        return judgeQuestionMapper.findByIdAndType(paperId);
    }

    @Override
    public List<Integer> findBySubject(String subject, Integer pageNo) {
        return judgeQuestionMapper.findBySubject(subject, pageNo);
    }

    @Override
    public JudgeQuestion findOnlyQuestionId() {
        return judgeQuestionMapper.findOnlyQuestionId();
    }
}
