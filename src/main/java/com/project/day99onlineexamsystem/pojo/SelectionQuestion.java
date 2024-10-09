package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 选择题(单选、多选)实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("selection_question")
public class SelectionQuestion {
    @TableId(type = IdType.AUTO, value = "questionId")
    private Integer questionId;
    private String subject;
    private String section;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String question;
    private String level;
    private String rightAnswer;
    private String analysis;
    private Integer score;
}
