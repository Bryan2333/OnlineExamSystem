package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.day99onlineexamsystem.dao.MessageMapper;
import com.project.day99onlineexamsystem.dao.ReplyMapper;
import com.project.day99onlineexamsystem.pojo.Message;
import com.project.day99onlineexamsystem.pojo.Reply;
import com.project.day99onlineexamsystem.service.MessageService;
import com.project.day99onlineexamsystem.service.ReplyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements MessageService {
    @Resource
    private MessageMapper messageMapper;

    @Resource
    private ReplyMapper replyMapper;

    /**
     * 分页获取留言信息。
     *
     * @param pageNo   当前页码（可选，默认为1）
     * @param pageSize 每页条目数（可选，默认为3）
     * @return 返回包含留言信息分页结果的IPage对象
     */
    public IPage<Message> page(Integer pageNo, Integer pageSize) {
        Page<Message> messagePage = new Page<>(pageNo, pageSize);

        // 创建查询条件对象，仅选择指定的字段，并按ID降序排序
        QueryWrapper<Message> messageQueryWrapper = new QueryWrapper<>();
        messageQueryWrapper.select("id", "title", "content", "time");
        messageQueryWrapper.orderByDesc("id");

        // 使用分页参数和查询条件查询留言信息
        IPage<Message> result = messageMapper.selectPage(messagePage, messageQueryWrapper);

        // 获取分页结果中的记录列表
        List<Message> records = result.getRecords();

        // 遍历记录列表，为每条留言添加回复信息
        records.forEach(message -> {
            List<Reply> replies = replyMapper.selectList(new QueryWrapper<Reply>().eq("messageId", message.getId()));
            message.setReplies(replies);
        });

        return result;
    }
}
