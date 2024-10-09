package com.project.day99onlineexamsystem.controller;

import com.project.day99onlineexamsystem.pojo.Item;
import com.project.day99onlineexamsystem.pojo.PaperManage;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.service.FillQuestionService;
import com.project.day99onlineexamsystem.service.JudgeQuestionService;
import com.project.day99onlineexamsystem.service.PaperManageService;
import com.project.day99onlineexamsystem.service.SelectionQuestionService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Resource
    private SelectionQuestionService selectionQuestionService;

    @Resource
    private FillQuestionService fillQuestionService;

    @Resource
    private JudgeQuestionService judgeQuestionService;

    @Resource
    private PaperManageService paperManageService;

    /**
     * 考试组卷
     *
     * @param item 包含组卷信息的请求体
     * @return 返回组卷成功的响应或错误响应
     */
    @PostMapping("/item")
    public Result add(@RequestBody Item item) {
        // 选择题数量
        Integer selectionNumber = item.getChangeNumber();

        // 判断题数量
        Integer judgeNumber = item.getJudgeNumber();

        // 填空题数量
        Integer fillNumber = item.getFillNumber();

        Integer paperId = item.getPaperId();

        List<Integer> selections = selectionQuestionService.findBySubject(item.getSubject(), selectionNumber);
        if (selections == null) {
            return Result.error(400, "获取选择题库失败");
        }

        for (Integer selection : selections) {
            PaperManage paperManage = new PaperManage(paperId, 1, selection);
            boolean flag = paperManageService.save(paperManage);
            if (!flag) {
                return Result.error(400, "选择题组卷保存失败");
            }
        }

        List<Integer> fillQuestions = fillQuestionService.findBySubject(item.getSubject(), fillNumber);
        if (fillQuestions == null) {
            return Result.error(400, "获取填空题库失败");
        }

        for (Integer fillQuestion : fillQuestions) {
            PaperManage paperManage = new PaperManage(paperId, 2, fillQuestion);
            boolean flag = paperManageService.save(paperManage);
            if (!flag) {
                return Result.error(400, "填空题组卷保存失败");
            }
        }

        List<Integer> judgeQuestions = judgeQuestionService.findBySubject(item.getSubject(), judgeNumber);
        if (judgeQuestions == null) {
            return Result.error(400, "获取判断题库失败");
        }

        for (Integer judgeQuestion : judgeQuestions) {
            PaperManage paperManage = new PaperManage(paperId, 3, judgeQuestion);
            boolean flag = paperManageService.save(paperManage);
            if (!flag) {
                return Result.error(400, "判断题组卷保存失败");
            }
        }

        return Result.ok();
    }
}
