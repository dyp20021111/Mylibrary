package com.ssm.service;
import com.ssm.dao.UserDao;
import com.ssm.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /**
     * 依赖注入
     */
    @Autowired
    private UserDao userDao;
     @Override
    public List<User> listUser() {
        return userDao.listUser();
    }
    @Override
    public User findUserByAccount(String account) {
        return userDao.findUserByAccount(account);
    }

    @Override
    public User getUser(String account, String password) {
        return userDao.getUser(account, password);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }
    @Override
    public int updateUser(User user) {
        return userDao.UpdateUser(user);
    }
    public int deleteUserById(int userid) {
        return userDao.deleteUserById(userid);
    }
    @Override
    public User queryuserById(int userid) {
        return userDao.queryuserById(userid);
    }
    @Override
    public User listBooksByUserid(Integer userid) {
        return userDao.listBooksByUserid(userid);
    }
}
