package com.project.day99onlineexamsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.day99onlineexamsystem.pojo.ExamManage;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.service.ExamManageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ExamManageController {
    @Resource
    private ExamManageService examManageService;

    /**
     * 获取所有考试信息
     *
     * @return 所有考试信息
     */
    @GetMapping("/exams")
    public Result findAll() {
        List<ExamManage> list = examManageService.list();
        return Result.ok().put("data", list);
    }

    /**
     * 根据分页获取考试信息
     *
     * @param pageNo   分页页面
     * @param pageSize 分压大小
     * @return 分页查询结果
     */
    @GetMapping("/exam")
    public Result findAll(
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "3") Integer pageSize
    ) {
        QueryWrapper<ExamManage> examManageQueryWrapper = new QueryWrapper<>();
        IPage<ExamManage> examManagePage = new Page<>(pageNo, pageSize);
        examManagePage = examManageService.page(examManagePage, examManageQueryWrapper);
        return Result.ok().put("data", examManagePage);
    }

    /**
     * 根据考试编号获取考试信息
     *
     * @param id 考试编号
     * @return 查询结果
     */
    @GetMapping("/exam/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        if (id == null || id < 0) {
            return Result.error("ID有误");
        }

        ExamManage examManage = examManageService.getById(id);
        return examManage == null ? Result.error("不存在该ID的考试") : Result.ok().put("data", examManage);
    }

    /**
     * 根据考试编号删除考试信息
     *
     * @param id 考试编号
     * @return 删除结果
     */
    @DeleteMapping("/exam/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        if (id == null || id < 0) {
            return Result.error("ID有误");
        }

        boolean flag = examManageService.removeById(id);
        return flag ? Result.error("删除成功") : Result.ok("删除失败");
    }

    /**
     * 添加考试信息
     *
     * @param examManage 考试信息
     * @return 添加结果
     */
    @PostMapping("/exam")
    public Result add(@RequestBody ExamManage examManage) {
        if (examManage == null) {
            return Result.error("考试信息为空");
        }

        boolean flag = examManageService.save(examManage);
        return flag ? Result.ok("添加成功") : Result.error("添加失败");
    }


    /**
     * 更新考试信息
     *
     * @param examManage 考试信息
     * @return 更新结果
     */
    @PutMapping("/exam")
    public Result update(@RequestBody ExamManage examManage) {
        if (examManage == null) {
            return Result.error("考试信息为空");
        }

        boolean flag = examManageService.updateById(examManage);
        return flag ? Result.ok("更新成功") : Result.error("更新失败");
    }

    /**
     * 获取唯一的试卷管理ID。
     *
     * @return 返回包含唯一的试卷管理ID的响应或错误响应
     */
    @GetMapping("/examManagePaperId")
    public Result findOnlyPaperId() {
        ExamManage res = examManageService.findOnlyPaperId();
        return res == null ? Result.error(400, "请求失败").put("data", null) : Result.ok("请求成功").put("data", res);
    }
}
