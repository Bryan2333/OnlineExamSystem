package com.project.day99onlineexamsystem.controller;

import com.project.day99onlineexamsystem.pojo.*;
import com.project.day99onlineexamsystem.service.FillQuestionService;
import com.project.day99onlineexamsystem.service.JudgeQuestionService;
import com.project.day99onlineexamsystem.service.PaperManageService;
import com.project.day99onlineexamsystem.service.SelectionQuestionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin
public class PaperManageController {
    @Resource
    private PaperManageService paperManageService;

    @Resource
    private FillQuestionService fillQuestionService;

    @Resource
    private JudgeQuestionService judgeQuestionService;

    @Resource
    private SelectionQuestionService selectionQuestionService;

    /**
     * 获取所有试卷信息
     *
     * @return 返回包含所有试卷信息的成功响应
     */
    @GetMapping("/papers")
    public Result findAllPaper() {
        List<PaperManage> list = paperManageService.list();
        return Result.ok().put("data", list);
    }

    /**
     * 根据试卷编号获取试卷信息
     *
     * @param paperId 试卷编号
     * @return 返回包含试卷信息的成功响应
     */
    @GetMapping("/paper/{paperId}")
    public Result findByPaperId(@PathVariable("paperId") Integer paperId) {
        List<SelectionQuestion> selectionQuestions = selectionQuestionService.findByIdAndType(paperId);
        List<FillQuestion> fillQuestions = fillQuestionService.findByIdAndType(paperId);
        List<JudgeQuestion> judgeQuestions = judgeQuestionService.findByIdAndType(paperId);
        HashMap<Integer, List<?>> map = new HashMap<>();
        map.put(1, selectionQuestions);
        map.put(2, fillQuestions);
        map.put(3, judgeQuestions);
        return Result.ok().put("data", map);
    }

    /**
     * 添加试卷
     *
     * @param paperManage 包含试卷信息的请求体
     * @return 返回添加成功的响应或错误响应
     */
    @PostMapping("/paperManage")
    public Result add(@RequestBody PaperManage paperManage) {
        boolean flag = paperManageService.save(paperManage);
        return flag ? Result.ok("添加成功") : Result.error("添加失败");
    }
}
