package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.day99onlineexamsystem.dao.StudentMapper;
import com.project.day99onlineexamsystem.pojo.Student;
import com.project.day99onlineexamsystem.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Resource
    private StudentMapper studentMapper;

    @Override
    public int add(Student student) {
        return studentMapper.add(student);
    }

    @Override
    public int updateByStudentId(Student student) {
        return studentMapper.updateByStudentId(student);
    }

    @Override
    public int updatePassword(Integer studentId, String password) {
        return studentMapper.updatePasswordById(studentId, password);
    }
}
