package com.project.day99onlineexamsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.day99onlineexamsystem.pojo.Teacher;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    /**
     * 教师登录验证
     *
     * @param teacherId 教师ID
     * @param password  教师密码
     * @return 符合条件的教师信息
     */
    @Select("SELECT * FROM teacher WHERE teacherId = #{teacherId} AND password = SHA2(#{password}, 256)")
    Teacher loginAuthenticate(@Param("teacherId") Integer teacherId, @Param("password") String password);

    /**
     * 添加教师信息
     *
     * @param teacher 教师实体类
     * @return 受影响的行数
     */
    @Insert("INSERT INTO teacher (teacherId, teacherName, institute, sex, phone, email, password, cardId, type, role) " +
            "VALUES (#{teacherId}, #{teacherName}, #{institute}, #{sex}, #{phone}, #{email}, SHA2(#{password}, 256), #{cardId}, #{type}, #{role});")
    int add(Teacher teacher);

    /**
     * 更新教师信息
     *
     * @param teacher 教师实体类
     * @return 受影响的行数
     */
    @Update("UPDATE teacher SET" +
            " teacherName = #{teacherName}, institute = #{institute}, sex = #{sex}, phone = #{phone}, email = #{email}, " +
            "password = SHA2(#{password}, 256), cardId = #{cardId}, type = #{type}, role = #{role} " +
            " WHERE teacherId = #{teacherId};")
    int updateByTeacherId(Teacher teacher);
}
