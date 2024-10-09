package com.project.day99onlineexamsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 试卷的题目模型
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String subject;
    private Integer paperId;
    private Integer changeNumber;
    private Integer fillNumber;
    private Integer judgeNumber;
}
