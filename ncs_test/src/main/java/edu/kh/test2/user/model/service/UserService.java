package edu.kh.test2.user.model.service;

import edu.kh.test2.user.model.dao.UserDAO;
import edu.kh.test2.user.model.vo.User;
import org.apache.ibatis.session.SqlSession;

import static edu.kh.test.common.SqlSessionTemplate.getSqlsession;

public class UserService {
    private UserDAO userDAO = new UserDAO();
    public User findById(String userId) {
        SqlSession session = getSqlsession();
        User user = userDAO.findById(session, userId);
        session.close();
        return user;
    }
}
