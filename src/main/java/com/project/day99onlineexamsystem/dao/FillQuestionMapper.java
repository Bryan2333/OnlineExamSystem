package com.project.day99onlineexamsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.day99onlineexamsystem.pojo.FillQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FillQuestionMapper extends BaseMapper<FillQuestion> {
    /**
     * 根据学科查询填空题
     *
     * @param subject 学科
     * @param pageNo  分页页面
     * @return 对应学科的填空题集合
     */
    @Select("SELECT questionId FROM fill_question WHERE subject = #{subject} ORDER BY RAND() DESC LIMIT #{pageNo}")
    List<Integer> findBySubject(String subject, Integer pageNo);

    @Select("SELECT questionId FROM fill_question ORDER BY questionId DESC LIMIT 1")
    FillQuestion findOnlyQuestionId();

    @Select("SELECT * FROM fill_question WHERE questionId IN (SELECT questionId FROM paper_manage WHERE questionType = 2 AND paperId = #{paperId})")
    List<FillQuestion> findByIdAndType(@Param("paperId") Integer paperId);
}
