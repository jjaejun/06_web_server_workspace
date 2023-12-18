package edu.kh.test.user.model.service;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;
import org.apache.ibatis.session.SqlSession;

import static edu.kh.test.common.SqlSessionTemplate.getSqlsession;

public class UserService {

    private UserDAO userDao = new UserDAO();

    public UserDTO findByNo(int userNo) {
        SqlSession session = getSqlsession();
        UserDTO userDTO = userDao.findByNo(session, userNo);
        session.close();
        return userDTO;
    }
}
