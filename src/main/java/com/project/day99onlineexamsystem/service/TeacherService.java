package com.project.day99onlineexamsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.day99onlineexamsystem.pojo.Teacher;

public interface TeacherService extends IService<Teacher> {
    int add(Teacher teacher);

    int updateByTeacherId(Teacher teacher);
}
