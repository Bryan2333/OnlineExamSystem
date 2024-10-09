package com.project.day99onlineexamsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.pojo.Teacher;
import com.project.day99onlineexamsystem.service.TeacherService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherService;

    /**
     * 获取所有教师信息。
     *
     * @param pageNo   当前页码（可选，默认为1）
     * @param pageSize 每页条目数（可选，默认为3）
     * @return 返回包含所有教师信息分页结果的成功响应
     */
    @GetMapping
    public Result findAll(
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "3") Integer pageSize
    ) {
        QueryWrapper<Teacher> teacherQueryWrapper = new QueryWrapper<>();
        IPage<Teacher> teacherPage = new Page<>(pageNo, pageSize);
        teacherPage = teacherService.page(teacherPage, teacherQueryWrapper);
        return Result.ok().put("data", teacherPage);
    }

    /**
     * 根据教师ID获取教师信息。
     *
     * @param id 教师ID
     * @return 返回包含教师信息的成功响应或错误响应
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        if (id == null || id < 0) {
            return Result.error("ID有误");
        }

        Teacher teacher = teacherService.getById(id);
        return teacher == null ? Result.error("不存在该ID的教师") : Result.ok().put("data", teacher);
    }

    /**
     * 根据教师ID删除教师信息。
     *
     * @param id 教师ID
     * @return 返回删除成功的响应或错误响应
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        if (id == null || id < 0) {
            return Result.error("ID有误");
        }

        boolean flag = teacherService.removeById(id);
        return flag ? Result.ok("删除成功") : Result.error(400, "删除失败");
    }

    /**
     * 添加教师信息。
     *
     * @param teacher 包含教师信息的请求体
     * @return 返回添加成功的响应或错误响应
     */
    @PostMapping
    public Result add(@RequestBody Teacher teacher) {
        if (teacher == null) {
            return Result.error();
        }

        int row = teacherService.add(teacher);
        return row == 1 ? Result.ok("添加成功") : Result.error(400, "添加失败");
    }

    /**
     * 更新教师信息。
     *
     * @param teacher 包含更新后的教师信息的请求体
     * @return 返回更新成功的响应或错误响应
     */
    @PutMapping
    public Result update(@RequestBody Teacher teacher) {
        if (teacher == null) {
            return Result.error();
        }

        int row = teacherService.updateByTeacherId(teacher);
        return row == 1 ? Result.ok("更新成功") : Result.error(400, "更新失败");
    }
}
