package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// 填空题实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("fill_question")
public class FillQuestion implements Serializable {
    @TableId(type = IdType.AUTO, value = "questionId")
    private Integer questionId;
    private String subject;
    private String question;
    private String answer;
    private Integer score;
    private String level;
    private String section;
    private String analysis;
}
