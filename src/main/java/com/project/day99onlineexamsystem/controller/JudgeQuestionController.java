package com.project.day99onlineexamsystem.controller;

import com.project.day99onlineexamsystem.pojo.JudgeQuestion;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.service.JudgeQuestionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JudgeQuestionController {
    @Resource
    private JudgeQuestionService judgeQuestionService;

    /**
     * 添加判断题信息
     *
     * @param question 包含判断题信息的请求体
     * @return 返回添加成功的响应或是错误响应
     */
    @PostMapping("/judgeQuestion")
    public Result add(@RequestBody JudgeQuestion question) {
        if (question == null) {
            return Result.error("判断题信息为空");
        }

        boolean flag = judgeQuestionService.save(question);
        return flag ? Result.ok("添加成功").put("data", question) : Result.error("添加失败");
    }

    /**
     * 获取最后一条判断题的questionId。
     *
     * @return 返回包含最后一条判断题的questionId的成功响应
     */
    @GetMapping("/judgeQuestionId")
    public Result findOnlyQuestionId() {
        JudgeQuestion question = judgeQuestionService.findOnlyQuestionId();
        return Result.ok("查询成功").put("data", question);
    }
}
