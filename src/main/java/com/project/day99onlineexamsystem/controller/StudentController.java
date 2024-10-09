package com.project.day99onlineexamsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.pojo.Student;
import com.project.day99onlineexamsystem.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;

    /**
     * 获取所有学生信息。
     *
     * @param pageNo   当前页码（可选，默认为1）
     * @param pageSize 每页条目数（可选，默认为5）
     * @return 返回包含所有学生信息分页结果的成功响应
     */
    @GetMapping
    public Result findAllStudent(
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        QueryWrapper<Student> studentQueryWrapper = new QueryWrapper<>();
        IPage<Student> studentPage = new Page<>(pageNo, pageSize);
        studentPage = studentService.page(studentPage, studentQueryWrapper);
        return Result.ok().put("data", studentPage);
    }

    /**
     * 根据学生ID获取学生信息。
     *
     * @param id 学生ID
     * @return 返回包含学生信息的成功响应或错误响应
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        if (id == null || id < 0) {
            return Result.error("学生ID有误");
        }

        Student stu = studentService.getById(id);
        return stu == null ? Result.error("不存在该ID的学生") : Result.ok().put("data", stu);
    }

    /**
     * 根据学生ID删除学生信息。
     *
     * @param id 学生ID
     * @return 返回删除成功的响应或错误响应
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        if (id == null || id < 0) {
            return Result.error("学生ID有误");
        }

        boolean flag = studentService.removeById(id);
        return flag ? Result.ok("删除成功") : Result.error(400, "删除失败");
    }

    /**
     * 添加学生信息。
     *
     * @param student 包含学生信息的请求体
     * @return 返回添加成功的响应或错误响应
     */
    @PostMapping
    public Result add(@RequestBody Student student) {
        if (student == null) {
            return Result.error("学生信息为空");
        }

        int row = studentService.add(student);
        return row == 1 ? Result.ok("添加成功") : Result.error(400, "添加失败");
    }

    /**
     * 更新学生信息。
     *
     * @param student 包含更新后的学生信息的请求体
     * @return 返回更新成功的响应或错误响应
     */
    @PutMapping
    public Result update(@RequestBody Student student) {
        if (student == null) {
            return Result.error("学生信息为空");
        }

        int row = studentService.updateByStudentId(student);
        return row == 1 ? Result.ok("更新成功") : Result.error("更新失败");
    }

    /**
     * 重置学生密码。
     *
     * @param student 包含学生信息的请求体(只包含学生ID、新的密码)
     * @return 返回重置密码成功的响应或错误响应
     */
    @PutMapping("/reset-password")
    public Result updatePwd(@RequestBody Student student) {
        Integer studentId = student.getStudentId();
        String password = student.getPassword();
        if (studentId < 0) {
            return Result.error("学生ID有误");
        }

        int row = studentService.updatePassword(studentId, password);
        return row == 1 ? Result.ok("更新密码成功") : Result.error("更新密码失败");
    }
}
