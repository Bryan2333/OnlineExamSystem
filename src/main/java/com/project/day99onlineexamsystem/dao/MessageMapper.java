package com.project.day99onlineexamsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.day99onlineexamsystem.pojo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}
