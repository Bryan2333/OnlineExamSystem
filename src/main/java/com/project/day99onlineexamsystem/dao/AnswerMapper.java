package com.project.day99onlineexamsystem.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.project.day99onlineexamsystem.pojo.AnswerVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnswerMapper {
    /**
     *
     * @param page 分页信息(分页页码，分页大小)
     * @return 查询结果
     */
    @Select("select question, subject, score, section,level, \"选择题\" as type from selection_question " +
            "union select  question, subject, score, section,level, \"判断题\" as type  from judge_question " +
            "union select  question, subject, score, section,level, \"填空题\" as type from fill_question")
    IPage<AnswerVO> findAll(Page<?> page);
}
