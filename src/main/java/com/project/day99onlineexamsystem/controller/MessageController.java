package com.project.day99onlineexamsystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.project.day99onlineexamsystem.pojo.Message;
import com.project.day99onlineexamsystem.pojo.Result;
import com.project.day99onlineexamsystem.service.impl.MessageServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/message")
public class MessageController {
    @Resource
    private MessageServiceImpl messageService;

    /**
     * 按分页大小获取留言信息
     *
     * @param pageNo   当前页码
     * @param pageSize 每页条目数
     * @return 返回包含留言信息分页结果的响应
     */
    @GetMapping
    public Result findAllMessage(
            @RequestParam(required = false, defaultValue = "1") Integer pageNo,
            @RequestParam(required = false, defaultValue = "3") Integer pageSize
    ) {
        IPage<Message> messageIPage = messageService.page(pageNo, pageSize);
        return Result.ok().put("data", messageIPage);
    }

    /**
     * 根据留言编号删除留言信息
     *
     * @param id 留言编号
     * @return 返回删除成功的响应或错误响应
     */
    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable("id") Integer id) {
        if (id == null || id < 0) {
            return Result.error("删除失败");
        }

        boolean flag = messageService.removeById(id);
        return flag ? Result.ok("删除成功") : Result.error("删除失败");
    }

    /**
     * 添加留言信息
     *
     * @param message 包含留言信息的请求体
     * @return 返回添加成功的响应或错误响应
     */
    @PostMapping
    public Result add(@RequestBody Message message) {
        if (message == null) {
            return Result.error("留言为空，保存失败");
        }

        boolean flag = messageService.save(message);
        return flag ? Result.ok("添加成功") : Result.error("添加失败");
    }

    /**
     * 更新留言信息
     *
     * @param message 包含留言信息的请求体
     * @return 返回更新成功的响应或错误响应
     */
    @PutMapping
    public Result update(@RequestBody Message message) {
        if (message == null) {
            return Result.error("留言为空，修改失败");
        }

        boolean flag = messageService.updateById(message);
        return flag ? Result.ok("更新成功") : Result.error("更新失败");
    }
}
