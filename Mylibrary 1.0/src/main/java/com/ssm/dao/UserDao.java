package com.ssm.dao;

import com.ssm.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

      /**
       * 通过账号查找用户是否存在，用于用户注册
       * @param account 账号
       * @return 用户存在或null
       */
      User findUserByAccount(@Param("account") String account);

      /**
       * 用于用户登录
       * @param account 账号
       * @param password 密码
       * @return
       */
      User getUser(@Param("account") String account, @Param("password") String password);

      /**
       * 用户注册
       * @param
       * @return
       */
      List<User> listUser();
      int addUser( @Param("user") User user);
      int UpdateUser(User user);
      /**
       * 返回一个用户及其所借书籍的信息
       * @param userid 用户id
       * @return
       */
      User listBooksByUserid(@Param("userid") Integer userid);
      int deleteUserById(int userid);
      User queryuserById(int userid);
}
