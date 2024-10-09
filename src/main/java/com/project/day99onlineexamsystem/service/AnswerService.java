package com.project.day99onlineexamsystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.day99onlineexamsystem.pojo.AnswerVO;

public interface AnswerService {
    IPage<AnswerVO> findAll(Page<AnswerVO> page);
}
