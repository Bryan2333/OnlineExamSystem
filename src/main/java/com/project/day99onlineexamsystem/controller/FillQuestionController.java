package com.project.day99onlineexamsystem.controller;

import com.project.day99onlineexamsystem.pojo.FillQuestion;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.service.FillQuestionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FillQuestionController {
    @Resource
    private FillQuestionService fillQuestionService;

    /**
     * 添加填空题信息
     *
     * @param fillQuestion 包含填空题信息的请求体
     * @return 返回添加成功的响应或错误响应
     */
    @PostMapping("/fillQuestion")
    public Result add(@RequestBody FillQuestion fillQuestion) {
        if (fillQuestion == null) {
            return Result.error("填空题信息为空");
        }

        boolean flag = fillQuestionService.save(fillQuestion);
        return flag ? Result.ok("添加成功").put("data", fillQuestion.getQuestionId()) : Result.error("添加失败");
    }

    /**
     * 获取最后一条questionId的填空题
     *
     * @return 返回包含最后一条填空题的questionId的成功响应
     */
    @GetMapping("/fillQuestionId")
    public Result findOnlyQuestionId() {
        FillQuestion question = fillQuestionService.findOnlyQuestionId();
        return Result.ok("查询成功").put("data", question);
    }
}
