package com.project.day99onlineexamsystem.controller;

import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.pojo.SelectionQuestion;
import com.project.day99onlineexamsystem.service.SelectionQuestionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class SelectionQuestionController {
    @Resource
    private SelectionQuestionService selectionQuestionService;

    /**
     * 获取最后一条选择题的题目信息。
     *
     * @return 返回包含最后一条选择题的题目信息的成功响应
     */
    @GetMapping("/selectionQuestionId")
    public Result findOnlyQuestion() {
        SelectionQuestion question = selectionQuestionService.findOnlyQuestionId();
        return Result.ok("查询成功").put("data", question);
    }

    /**
     * 添加选择题信息。
     *
     * @param selectionQuestion 包含选择题信息的请求体
     * @return 返回添加成功的响应或错误响应
     */
    @PostMapping("/selectionQuestion")
    public Result add(@RequestBody SelectionQuestion selectionQuestion) {
        if (selectionQuestion == null) {
            return Result.error("选择题信息为空");
        }

        boolean flag = selectionQuestionService.save(selectionQuestion);
        return flag ? Result.ok().put("data", selectionQuestion.getQuestionId()) : Result.error("添加失败");
    }
}
