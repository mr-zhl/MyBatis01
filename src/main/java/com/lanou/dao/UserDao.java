package com.lanou.dao;

import com.lanou.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhaohongliang
 */
public interface UserDao {
    List<User> selectAll();
    User selectByID(int id);
    //删除
    int delete(int id);
    //添加
    int add(@Param("username") String username,@Param("password")String password);







}
