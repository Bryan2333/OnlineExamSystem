package com.project.day99onlineexamsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.day99onlineexamsystem.pojo.ExamManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ExamManageMapper extends BaseMapper<ExamManage> {
    @Select("SELECT paperId FROM exam_manage ORDER BY paperId DESC LIMIT 1")
    ExamManage findOnlyPaperId();
}
