package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 判断题实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("judge_question")
public class JudgeQuestion {
    @TableId(type = IdType.AUTO, value = "questionId")
    private Integer questionId;
    private String subject;
    private String question;
    private String answer;
    private String level;
    private String section;
    private Integer score;
    private String analysis;
}
