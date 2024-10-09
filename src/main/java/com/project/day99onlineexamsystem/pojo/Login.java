package com.project.day99onlineexamsystem.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 登录信息实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    private Integer username;
    private String password;
}
