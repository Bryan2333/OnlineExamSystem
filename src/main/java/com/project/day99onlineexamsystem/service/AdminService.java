package com.project.day99onlineexamsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.project.day99onlineexamsystem.dao.AdminMapper;
import com.project.day99onlineexamsystem.pojo.Admin;
import com.project.day99onlineexamsystem.pojo.Student;
import com.project.day99onlineexamsystem.pojo.Teacher;
import jakarta.annotation.Resource;

public interface AdminService extends IService<Admin> {
    int add(Admin entity);
}
