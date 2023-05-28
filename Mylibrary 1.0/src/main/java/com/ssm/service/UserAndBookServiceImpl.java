package com.ssm.service;
import com.ssm.dao.UserAndBookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAndBookServiceImpl implements UserAndBookService {

    /**
     * 依赖注入
     */
    @Autowired
    private UserAndBookDao userAndBookDao;

    @Override
    public int borrowBook(Integer bookid, Integer userid) {
        return userAndBookDao.borrowBook(bookid, userid);
    }

    @Override
    public int returnBook(Integer bookid, Integer userid) {
        return userAndBookDao.returnBook(bookid, userid);
    }

    @Override
    public Integer checkIfBorrow(Integer bookid, Integer userid) {
        return userAndBookDao.checkIfBorrow(bookid, userid);
    }
}

