package com.project.day99onlineexamsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.day99onlineexamsystem.dao.StudentMapper;
import com.project.day99onlineexamsystem.pojo.Student;
import jakarta.annotation.Resource;

public interface StudentService extends IService<Student> {
    int add(Student student);

    int updateByStudentId(Student student);

    int updatePassword(Integer studentId, String password);
}
