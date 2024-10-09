package com.project.day99onlineexamsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 题目通用模型（用于展示题库）
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerVO {
    private String question;
    private String subject;
    private String score;
    private String section;
    private String level;
    private String type;
}
