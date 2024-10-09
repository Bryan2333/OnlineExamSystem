package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

// 学生实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student")
@EqualsAndHashCode(callSuper = true)
public class Student extends User implements Serializable {
    @TableId(type = IdType.AUTO, value = "studentId")
    private Integer studentId;
    private String studentName;
    private String grade;
    private String major;
    private String clazz;
    private String institute;
    private String phone;
    private String email;
    private String password;
    private String cardId;
    private String sex;
    private String role;
}
