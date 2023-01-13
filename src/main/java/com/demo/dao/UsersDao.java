package com.demo.dao;

import com.demo.domain.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UsersDao {
    //添加
    @Insert("insert into users values(#{loginId},#{loginPwd},#{nickName},#{tel},#{pic})")
    void insert(Users users);

    //修改
    @Update("update users set loginPwd=#{loginPwd},nickName=#{nickName},tel=#{tel},pic=#{pic} where " +
            "loginId=#{loginId}")
    void update(Users users);

    //删除
    @Delete("delete from users where loginId=#{loginId}")
    void delete(String id);

    //批量删除
    @Delete({"<script>",
            "delete from users where loginId in",
            "<foreach collection='array' item='loginId' open='(' close=')' separator=','>",
            "#{loginId}",
            "</foreach>",
            "</script>"})
    void deletes(@Param("array") String[] loginIds);

    //查询全部
    @Select("select * from users;")
    List<Users> selectAll();

    //根据id查询
    @Select("select * from users where loginId=#{LoginId}")
    Users selectById(String id);

    //分页查询
    @Select("select * from users limit #{start},#{pageSize}")
    List<Users> selectByPage(@Param("start") int start, @Param("pageSize") int pageSize);

    //模糊查询
    @Select("select * from users where nickName like #{nickName}")
    List<Users> selectByNickName(String nickName);

    //分页模糊查询
    @Select("select * from users where loginId like #{loginId} and nickName like #{nickName} limit #{start}," +
            "#{pageSize}")
    List<Users> selectByIdAndNickNameAndPage(@Param("loginId") String loginId,
                                             @Param("nickName") String nickName,
                                             @Param("start") int start, @Param("pageSize") int pageSize);

    // 查询总的数据数量
    @Select("select count(*) from users where loginId like #{loginId} and nickName like #{nickName}")
    int getCount(@Param("loginId") String loginId, @Param("nickName") String nickName);
}
