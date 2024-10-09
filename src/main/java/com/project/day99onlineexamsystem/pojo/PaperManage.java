package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 试卷实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("paper_manage")
public class PaperManage {
    @TableId(type = IdType.AUTO)
    private Integer paperId;
    private Integer questionType;
    private Integer questionId;
}
