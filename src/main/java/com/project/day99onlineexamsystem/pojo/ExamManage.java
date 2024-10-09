package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 考试实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("exam_manage")
public class ExamManage {
    @TableId(type = IdType.AUTO, value = "examCode")
    private Integer examCode;
    private String description;
    private String source;
    private Integer paperId;
    private String examDate;
    private Integer totalTime;
    private String grade;
    private String term;
    private String major;
    private String institute;
    private Integer totalScore;
    private String type;
    private String tips;
}
