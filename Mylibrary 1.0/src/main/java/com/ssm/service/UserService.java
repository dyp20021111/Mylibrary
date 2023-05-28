package com.ssm.service;
import com.ssm.pojo.Bookxx;
import com.ssm.pojo.User;

import java.util.List;

/**
 * @Author: Luoxi
 * @Time: 2021-06-01 (星期二)
 * @Project: easy_library
 * @Package: com.ssm.service
 * @Version: JDK15
 * @Description:
 */

public interface UserService {

    List<User> listUser();
    User findUserByAccount(String account);
    User getUser(String account, String password);
    int addUser(User user);
    int updateUser(User user);
    User listBooksByUserid(Integer userid);
    int deleteUserById(int userid);
    User queryuserById(int userid);//根据id查询,返回一个user


}
