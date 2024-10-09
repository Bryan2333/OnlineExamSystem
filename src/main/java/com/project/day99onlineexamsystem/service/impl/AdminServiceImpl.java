package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.day99onlineexamsystem.dao.AdminMapper;
import com.project.day99onlineexamsystem.pojo.Admin;
import com.project.day99onlineexamsystem.pojo.Student;
import com.project.day99onlineexamsystem.pojo.Teacher;
import com.project.day99onlineexamsystem.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public int add(Admin admin) {
        return adminMapper.add(admin);
    }
}
