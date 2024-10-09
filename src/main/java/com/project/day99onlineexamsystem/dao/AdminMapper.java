package com.project.day99onlineexamsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.day99onlineexamsystem.pojo.Admin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 管理员登陆验证
     *
     * @param adminId  管理员ID
     * @param password 管理员密码
     * @return 符合条件的管理员信息
     */
    @Select("SELECT * FROM admin WHERE adminId = #{adminId} AND password = SHA2(#{password}, 256)")
    Admin loginAuthenticate(@Param("adminId") Integer adminId, @Param("password") String password);

    /**
     * 添加管理员信息
     *
     * @param admin 管理员信息
     * @return 受影响的行数
     */
    @Insert("INSERT INTO admin (adminId, adminName, sex, phone, email, password, cardId, role) " +
            "VALUES (#{adminId}, #{adminName}, #{sex}, #{phone}, #{email}, SHA2(#{password}, 256), #{cardId}, #{role});")
    int add(Admin admin);
}
