package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.day99onlineexamsystem.dao.TeacherMapper;
import com.project.day99onlineexamsystem.pojo.Teacher;
import com.project.day99onlineexamsystem.service.TeacherService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public int add(Teacher teacher) {
        return teacherMapper.add(teacher);
    }

    @Override
    public int updateByTeacherId(Teacher teacher) {
        return teacherMapper.updateByTeacherId(teacher);
    }
}
