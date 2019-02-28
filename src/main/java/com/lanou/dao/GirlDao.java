package com.lanou.dao;

import com.lanou.pojo.Girl;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface GirlDao {

    List<Girl> selectAll();

    int insert(@Param("name") String name, @Param("age") int age);

    int insert1(Girl girl);

    int update1(@Param("id") int id,@Param("name") String name);
    int update2(@Param("id") int id,@Param("age") int age);
    int update3(@Param("id") int id,@Param("name") String name,@Param("age") int age);

    int update4(Girl girl);

    List<Girl> selectAll1(Girl girl);


}
