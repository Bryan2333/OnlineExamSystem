package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;

// 消息的回复实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("reply")
public class Reply implements Serializable {
    @TableId(type = IdType.AUTO, value = "replyId")
    private Integer replyId;
    private Integer messageId;
    private String reply;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone="GMT+8")
    private Date replyTime;
}
