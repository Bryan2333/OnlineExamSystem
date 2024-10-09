package com.project.day99onlineexamsystem.service.impl;

import com.project.day99onlineexamsystem.dao.AdminMapper;
import com.project.day99onlineexamsystem.dao.StudentMapper;
import com.project.day99onlineexamsystem.dao.TeacherMapper;
import com.project.day99onlineexamsystem.pojo.*;
import com.project.day99onlineexamsystem.service.LoginService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    private AdminMapper adminMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public User userLoginAuthenticate(Login login) {
        Integer username = login.getUsername();
        String password = login.getPassword();

        Admin admin = adminMapper.loginAuthenticate(username, password);
        if (admin != null) {
            return admin;
        }

        Student student = studentMapper.loginAuthenticate(username, password);
        if (student != null) {
            return student;
        }

        return teacherMapper.loginAuthenticate(username, password);
    }
}
