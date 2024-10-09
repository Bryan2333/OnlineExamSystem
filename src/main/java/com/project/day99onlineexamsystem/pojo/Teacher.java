package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// 教师实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("teacher")
@EqualsAndHashCode(callSuper = true)
public class Teacher extends User implements Serializable {
    @TableId(type = IdType.AUTO, value = "teacherId")
    private Integer teacherId;
    private String teacherName;
    private String institute;
    private String sex;
    private String phone;
    private String email;
    private String password;
    private String cardId;
    private String type;
    private String role;
}
