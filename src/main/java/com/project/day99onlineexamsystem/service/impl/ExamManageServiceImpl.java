package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.day99onlineexamsystem.pojo.ExamManage;
import com.project.day99onlineexamsystem.dao.ExamManageMapper;
import com.project.day99onlineexamsystem.service.ExamManageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ExamManageServiceImpl extends ServiceImpl<ExamManageMapper, ExamManage> implements ExamManageService {
    @Resource
    private ExamManageMapper examManageMapper;
    @Override
    public ExamManage findOnlyPaperId() {
        return examManageMapper.findOnlyPaperId();
    }
}
