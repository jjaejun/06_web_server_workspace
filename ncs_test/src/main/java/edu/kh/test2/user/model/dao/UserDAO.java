package edu.kh.test2.user.model.dao;

import edu.kh.test2.user.model.vo.User;
import org.apache.ibatis.session.SqlSession;

public class UserDAO {
    public User findById(SqlSession session, String userId) {
        return session.selectOne("user.findById", userId);
    }
}
