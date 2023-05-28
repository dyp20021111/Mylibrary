package com.ssm.dao;
import org.apache.ibatis.annotations.Param;

public interface UserAndBookDao {

    /**
     * 用户借书
     * @param bookid
     * @param userid
     * @return
     */
    int borrowBook(@Param("bookid") Integer bookid, @Param("userid") Integer userid);

    /**
     * 用户还书
     * @param bookid
     * @param userid
     * @return
     */
    int returnBook(@Param("bookid") Integer bookid, @Param("userid") Integer userid);

    /**
     * 判断用户是否已经借过此书(假设每种书每人只能借一本)
     * @param bookid
     * @param userid
     * @return
     */
    Integer checkIfBorrow(@Param("bookid") Integer bookid, @Param("userid") Integer userid);
}
