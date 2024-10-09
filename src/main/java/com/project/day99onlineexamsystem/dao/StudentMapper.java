package com.project.day99onlineexamsystem.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.project.day99onlineexamsystem.pojo.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    /**
     * 学生登录验证
     *
     * @param studentId 学生ID
     * @param password  学生密码
     * @return 符合条件的学生信息
     */
    @Select("SELECT * FROM student WHERE studentId = #{studentId} AND password = SHA2(#{password}, 256)")
    Student loginAuthenticate(@Param("studentId") Integer studentId, @Param("password") String password);

    /**
     * 添加学生信息
     *
     * @param student 学生实体类
     * @return 受影响的行数
     */
    @Insert("INSERT INTO student (studentId, studentName, grade, major, clazz, institute, phone, email, password, cardId, sex, role)" +
            " VALUES (#{studentId}, #{studentName}, #{grade}, #{major}, #{clazz}, #{institute}, #{phone}, #{email}, SHA2(#{password}, 256), #{cardId}, #{sex}, #{role});")
    int add(Student student);

    /**
     * 更新学生信息
     *
     * @param student 学生实体类
     * @return 受影响的行数
     */
    @Update("UPDATE student " +
            "SET studentName = #{studentName}, grade = #{grade}, major = #{major}, clazz = #{clazz}," +
            " institute = #{institute}, phone = #{phone}, email = #{email}, password = SHA2(#{password}, 256)," +
            " cardId = #{cardId}, sex = #{sex}, role = #{role}" +
            " WHERE studentId = #{studentId};")
    int updateByStudentId(Student student);

    /**
     * 更新学生登录密码
     *
     * @param studentId 学生ID
     * @param password  学生新的登录密码
     * @return 受影响的行数
     */
    @Update("UPDATE student SET password = SHA2(#{password}, 256) WHERE studentId = #{studentId};")
    int updatePasswordById(@Param("studentId") Integer studentId, @Param("password") String password);
}
