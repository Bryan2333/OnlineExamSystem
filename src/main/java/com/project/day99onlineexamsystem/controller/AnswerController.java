package com.project.day99onlineexamsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.day99onlineexamsystem.pojo.AnswerVO;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.service.AnswerService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    @Resource
    private AnswerService answerService;

    /**
     * 根据分页获取题库信息
     *
     * @param pageNo   当前页码
     * @param pageSize 每页条目数
     * @return 包含题库信息分页结果的响应
     */
    @GetMapping("/answer")
    public Result findAllQuestion(
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "3") Integer pageSize
    ) {
        Page<AnswerVO> answerVOPage = new Page<>(pageNo, pageSize);
        IPage<AnswerVO> all = answerService.findAll(answerVOPage);
        return Result.ok().put("data", all);
    }
}
