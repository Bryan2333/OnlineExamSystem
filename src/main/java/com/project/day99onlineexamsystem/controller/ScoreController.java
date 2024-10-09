package com.project.day99onlineexamsystem.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.pojo.Score;
import com.project.day99onlineexamsystem.service.ScoreService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ScoreController {
    @Resource
    private ScoreService scoreService;

    /**
     * 获取所有考试成绩
     *
     * @return 返回包含所有考试成绩的成功响应
     */
    @GetMapping("/scores")
    public Result findAll() {
        List<Score> list = scoreService.list();
        return Result.ok().put("data", list);
    }

    /**
     * 按分页大小获取某个学生的成绩
     *
     * @param pageNo    当前页码
     * @param pageSize  每页条目数
     * @param studentId 学生ID
     * @return 返回包含某个学生的成绩分页结果的成功响应或错误响应
     */
    @GetMapping("/score")
    public Result findByStudentIdWithPage(
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "3") Integer pageSize,
            Integer studentId
    ) {
        if (studentId == null || studentId < 0) {
            return Result.error("学生ID有误");
        }

        QueryWrapper<Score> scoreQueryWrapper = new QueryWrapper<>();
        scoreQueryWrapper.eq("studentId", studentId);
        Page<Score> scorePage = new Page<>(pageNo, pageSize);
        Page<Score> page = scoreService.page(scorePage, scoreQueryWrapper);
        return Result.ok().put("data", page);
    }

    /**
     * 获取某个学生的所有成绩
     *
     * @param studentId 学生ID
     * @return 返回包含某个学生的所有成绩的成功响应或错误响应
     */
    @GetMapping("/score/{studentId}")
    public Result findByStudentId(@PathVariable("studentId") Integer studentId) {
        if (studentId == null || studentId < 0) {
            return Result.error("学生ID有误");
        }

        List<Score> res = scoreService.findByStudentId(studentId);
        return Result.ok().put("data", res);
    }

    /**
     * 添加考试成绩
     *
     * @param score 包含考试成绩的请求体
     * @return 返回添加成功的响应或错误响应
     */
    @PostMapping("/score")
    public Result add(@RequestBody Score score) {
        if (score == null) {
            return Result.error("成绩为空");
        }
        boolean flag = scoreService.save(score);
        return flag ? Result.ok("成绩添加成功") : Result.error("成绩添加失败");
    }

    /**
     * 获取某次考试的学生成绩
     *
     * @param examCode 考试编号
     * @return 返回包含某次考试的学生成绩列表的成功响应或错误响应
     */
    @GetMapping("/scores/{examCode}")
    public Result findByExamCode(@PathVariable("examCode") Integer examCode) {
        if (examCode == null || examCode < 0) {
            return Result.error("考试编号有误");
        }

        List<Score> list = scoreService.list(new QueryWrapper<Score>().eq("examCode", examCode));
        return Result.ok().put("data", list);
    }
}
