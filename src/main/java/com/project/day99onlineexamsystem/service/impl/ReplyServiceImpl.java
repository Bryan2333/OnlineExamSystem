package com.project.day99onlineexamsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.project.day99onlineexamsystem.dao.ReplyMapper;
import com.project.day99onlineexamsystem.pojo.Reply;
import com.project.day99onlineexamsystem.service.ReplyService;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {
}
