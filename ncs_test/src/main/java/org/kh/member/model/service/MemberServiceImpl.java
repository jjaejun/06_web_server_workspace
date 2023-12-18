package org.kh.member.model.service;

import org.apache.ibatis.session.SqlSession;
import org.kh.member.model.dao.MemberDAO;
import org.kh.member.model.vo.MemberVO;

import static edu.kh.test.common.SqlSessionTemplate.getSqlsession;

public class MemberServiceImpl {

    private MemberDAO memberDAO = new MemberDAO();

    public int insertMember(MemberVO mOne) {
        int result = 0;
        SqlSession session = getSqlsession();
        try {
            result = memberDAO.insertMember(session, mOne);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }
}
