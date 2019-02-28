package com.lanou;

import com.lanou.dao.GirlDao;
import com.lanou.dao.UserDao;
import com.lanou.pojo.Girl;
import com.lanou.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {


    private SqlSessionFactory sqlSessionFactory;

    @BeforeEach
    void test() throws IOException {
        //通过XML配置文件,创建sqlSessionFactory
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(resourceAsStream);
        System.out.println(sqlSessionFactory);
    }

    @Test
    void test1() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("selectAll");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    void test2() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
//        省略了实现的部分
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.selectByID(1);
        System.out.println(user);

   //    sqlSession.selectOne("selectByID",new )
    }

    @Test
    void test3() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int row = userDao.delete(1);
        System.out.println(row);
    }

    @Test
    void test4() {
        //openSession获取数据库链接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        int row = userDao.add("123", "qqq");
        System.out.println(row);
    }

    @Test
    void test5() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        List<Girl> list = girlDao.selectAll();
        for (Girl girl : list) {
            System.out.println(girl);
        }
    }

    @Test
    void test6() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        int row = girlDao.insert("如花", 15);
        System.out.println(row);
    }

    @Test
    void test7() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl girl=new Girl();
        girl.setName("如花呀");
        girl.setAge(19);
        int row = girlDao.insert1(girl);
        System.out.println(row);

    }

    @Test
    void test8() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        int row = girlDao.update1(3, "周杰伦");
        System.out.println(row);
    }

    @Test
    void test9() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl girl=new Girl();
        girl.setName("安妮");
        girl.setAge(19);
        girl.setId(2);
        int row = girlDao.update4(girl);
        System.out.println(row);
    }

    @Test
    void test10() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        GirlDao girlDao = sqlSession.getMapper(GirlDao.class);
        Girl girl=new Girl();
        girl.getAge();
        girl.getName();
        girl.getId();
        List<Girl> list = girlDao.selectAll1(girl);
        for (Girl girl1 : list) {
            System.out.println(girl1);
        }
    }
}
