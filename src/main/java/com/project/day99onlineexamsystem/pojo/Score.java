package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 分数实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("score")
public class Score {
    @TableId(type = IdType.AUTO, value = "scoreId")
    private Integer scoreId;
    private Integer examCode;
    private Integer studentId;
    private String subject;
    private Integer ptScore;
    private Integer etScore;
    private Integer score;
    private String answerDate;
}
