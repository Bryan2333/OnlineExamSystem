package com.project.day99onlineexamsystem.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.project.day99onlineexamsystem.pojo.Reply;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.service.ReplyService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/reply")
public class ReplyController {
    @Resource
    private ReplyService replyService;

    /**
     * 添加回复
     *
     * @param reply 包含回复信息的请求体
     * @return 添加回复成功的响应或错误响应
     */
    @PostMapping
    public Result add(@RequestBody Reply reply) {
        if (reply == null) {
            return Result.error("回复为空，添加失败");
        }
        boolean flag = replyService.save(reply);
        return flag ? Result.ok("回复成功") : Result.error("回复失败");
    }

    /**
     * 根据留言编号获取所有回复信息
     *
     * @param messageId 留言编号
     * @return 返回包含回复信息的成功响应或错误响应
     */
    @GetMapping("/{messageId}")
    public Result findByMessageId(@PathVariable("messageId") Integer messageId) {
        if (messageId == null || messageId < 0) {
            return Result.error("留言ID有误");
        }
        List<Reply> list = replyService.list(new QueryWrapper<Reply>().eq("messageId", messageId));
        return list == null ? Result.error("回复为空") : Result.ok().put("data", list);
    }
}
