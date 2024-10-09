package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.day99onlineexamsystem.dao.AnswerMapper;
import com.project.day99onlineexamsystem.pojo.AnswerVO;
import com.project.day99onlineexamsystem.service.AnswerService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Resource
    private AnswerMapper answerMapper;

    @Override
    public IPage<AnswerVO> findAll(Page<AnswerVO> page) {
        return answerMapper.findAll(page);
    }
}
