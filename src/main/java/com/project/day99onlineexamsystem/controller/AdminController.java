package com.project.day99onlineexamsystem.controller;

import com.project.day99onlineexamsystem.pojo.Admin;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    /**
     * 获取所有管理员信息
     *
     * @return 返回管理员信息
     */
    @GetMapping
    public Result findAll() {
        List<Admin> list = adminService.list();
        return Result.ok("success").put("data", list);
    }

    /**
     * 根据ID获取管理员信息
     *
     * @param id 管理员ID
     * @return 返回管理员信息或者错误响应
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        if (id == null) {
            return Result.error("ID为空");
        }

        Admin admin = adminService.getById(id);
        return admin == null ? Result.error("不存在该ID的管理员") : Result.ok().put("data", admin);
    }

    /**
     * 根据ID删除管理员信息
     *
     * @param id 管理员ID
     * @return 返回删除成功的响应或错误响应
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        if (id == null || id < 0) {
            return Result.error("ID有误");
        }
        boolean flag = adminService.removeById(id);
        return flag ? Result.ok("删除成功") : Result.error("删除失败");
    }

    /**
     * 添加管理员信息
     *
     * @param admin 包含管理员信息的请求体
     * @return 返回添加成功的响应或错误响应
     */
    @PostMapping
    public Result add(@RequestBody Admin admin) {
        if (admin == null) {
            return Result.error();
        }
        int row = adminService.add(admin);
        return row == 1 ? Result.ok("添加成功") : Result.error("添加失败");
    }

    /**
     * 根据ID更新管理员信息
     *
     * @param admin 包含管理员信息的请求体
     * @return 返回更新成功的响应或错误响应
     */
    @PutMapping
    public Result update(@RequestBody Admin admin) {
        if (admin == null) {
            return Result.error();
        }
        boolean flag = adminService.updateById(admin);
        return flag ? Result.ok("更新成功") : Result.error();
    }
}
