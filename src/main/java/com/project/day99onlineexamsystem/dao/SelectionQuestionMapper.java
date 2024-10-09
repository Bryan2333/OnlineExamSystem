package com.project.day99onlineexamsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.day99onlineexamsystem.pojo.SelectionQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SelectionQuestionMapper extends BaseMapper<SelectionQuestion> {
    /**
     * 根据学科查找选择题
     *
     * @param subject 学科
     * @param pageNo  分页页码
     * @return 对应学科的选择题集合
     */
    @Select("SELECT questionId FROM selection_question  WHERE subject = #{subject} ORDER BY RAND() DESC LIMIT #{pageNo}")
    List<Integer> findBySubject(String subject, Integer pageNo);

    @Select("SELECT questionId FROM selection_question ORDER BY questionId DESC LIMIT 1")
    SelectionQuestion findOnlyQuestionId();

    @Select("SELECT * FROM selection_question WHERE questionId IN (SELECT questionId FROM paper_manage WHERE questionType = 1 AND paperId = #{paperId})")
    List<SelectionQuestion> findByIdAndType(Integer PaperId);
}
