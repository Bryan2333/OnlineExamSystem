package com.project.day99onlineexamsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.day99onlineexamsystem.pojo.ExamManage;

public interface ExamManageService extends IService<ExamManage> {
    ExamManage findOnlyPaperId();
}
