package com.project.day99onlineexamsystem.controller;

import com.project.day99onlineexamsystem.pojo.*;
import com.project.day99onlineexamsystem.service.LoginService;
import jakarta.annotation.Resource;
import org.apache.ibatis.annotations.Insert;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class LoginController {
    @Resource
    private LoginService loginService;

    /**
     * 验证登陆信息
     *
     * @param login 包含登录信息的请求体
     * @return 返回登录成功的响应或错误响应
     */
    @PostMapping
    public Result login(@RequestBody Login login) {
        if (login == null || login.getUsername() == null || login.getPassword() == null) {
            return Result.error();
        }

        User user = loginService.userLoginAuthenticate(login);

        if (user != null) {
            String roleName = null;
            String userName = null;
            String roleId = null;
            Integer userId = null;

            if (user instanceof Admin admin) {
                roleId = "0";
                roleName = "admin";
                userName = admin.getAdminName();
                userId = admin.getAdminId();
            } else if (user instanceof Teacher teacher) {
                roleId = "1";
                roleName = "teacher";
                userName = teacher.getTeacherName();
                userId = teacher.getTeacherId();
            } else if (user instanceof Student student) {
                roleId = "2";
                roleName = "student";
                userName = student.getStudentName();
                userId = student.getStudentId();
            }

            return Result.ok("登录成功")
                    .put("role", roleId)
                    .put(roleName + "Name", userName)
                    .put(roleName + "Id", userId);
        }

        return Result.error("登录失败");
    }
}
