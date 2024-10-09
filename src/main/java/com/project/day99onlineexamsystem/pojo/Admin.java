package com.project.day99onlineexamsystem.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.io.Serializable;

// 管理员实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("admin")
@EqualsAndHashCode(callSuper = true)
public class Admin extends User implements Serializable {
    @TableId(value = "adminId", type = IdType.AUTO)
    private Integer adminId;
    private String adminName;
    private String sex;
    private String phone;
    private String email;
    private String password;
    private String cardId;
    private String role;
}
