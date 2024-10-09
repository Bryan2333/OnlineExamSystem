package com.project.day99onlineexamsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.day99onlineexamsystem.pojo.JudgeQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JudgeQuestionMapper extends BaseMapper<JudgeQuestion> {
    /**
     * 根据学科查询判断题
     *
     * @param subject 学科
     * @param pageNo  页码
     * @return 对应学科的判断题集合
     */
    @Select("SELECT questionId FROM judge_question  WHERE subject = #{subject}  ORDER BY RAND() DESC LIMIT #{pageNo}")
    List<Integer> findBySubject(String subject, Integer pageNo);

    @Select("SELECT questionId FROM judge_question ORDER BY questionId DESC LIMIT 1")
    JudgeQuestion findOnlyQuestionId();

    /**
     * 根据试卷编号和题目类型查找判断题列表。
     *
     * @param paperId 试卷编号
     * @return 符合条件的判断题列表
     */
    @Select("SELECT * FROM judge_question WHERE questionId IN (SELECT questionId FROM paper_manage WHERE questionType = 3 AND paperId = #{paperId})")
    List<JudgeQuestion> findByIdAndType(Integer paperId);
}
