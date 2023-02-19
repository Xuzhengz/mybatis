package com.xzz.dao;

import com.xzz.pojo.User;
import com.xzz.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){
        /**
         * Type interface com.xzz.dao.UserDAO is not known to the MapperRegistry.
         * 每一个mapper.xml都需要在配置中心注册
         *
         * The error may exist in com.xzz.dao.UserMapper.xml
         *
         *
         */
        //获取sqlsession对象
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        //执行sql，方式一：getMapper
//        UserDAO userDAO = sqlSession.getMapper(UserDAO.class);
//        List<User> userList = userDAO.getUserList();
//        for (User user : userList) {
//            System.out.println(user.toString());
//        }

        //方式二：selectList
        List<User> userList = sqlSession.selectList("com.xzz.dao.UserDAO.getUserList");
        for (User user : userList) {
            System.out.println(user.toString());
        }
        //关闭sqlsession
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMApper userMApper= sqlSession.getMapper(UserMApper.class);
        User user = userMApper.getUserById(1);
        System.out.println(user);
        sqlSession.close();

    }

    @Test
    public void test3(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMApper userMApper= sqlSession.getMapper(UserMApper.class);
        userMApper.addUser(User.builder().uname("xzz2").pwd("123456").email("123@qq.com").role(0).build());
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test4(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMApper userMApper= sqlSession.getMapper(UserMApper.class);
        userMApper.updateUser(User.builder().id(25).uname("xzz1").pwd("123456").email("123@qq.com").role(0).build());
        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test5(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMApper userMApper= sqlSession.getMapper(UserMApper.class);
        userMApper.deleteUser(25);
        sqlSession.commit();
        sqlSession.close();

    }
}
