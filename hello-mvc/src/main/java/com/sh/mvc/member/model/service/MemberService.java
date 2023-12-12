package com.sh.mvc.member.model.service;

import com.sh.mvc.member.model.dao.MemberDao;
import com.sh.mvc.member.model.entity.Member;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.sh.mvc.common.SqlSessionTemplate.getSqlsession;


public class MemberService {
    private MemberDao memberDao = new MemberDao();

    public Member findById(String id) {
        SqlSession session = getSqlsession();
        Member member = memberDao.findById(session, id);
        session.close();
        return member;
    }

    public List<Member> findAll() {
        SqlSession session = getSqlsession();
        List<Member> members = memberDao.findAll(session);
        session.close();
        return members;
    }

    public List<Member> findByName(String name) {
        SqlSession session = getSqlsession();
        List<Member> members = memberDao.findByName(session, name);
        session.close();
        return members;
    }

    public List<Member> findByGender(String gender) {
        SqlSession session = getSqlsession();
        List<Member> members = memberDao.findByGender(session, gender);
        session.close();
        return members;
    }

    public int insertMember(Member member) {
        int result = 0;
        SqlSession session = getSqlsession();
        try {
            result = memberDao.insertMember(session, member);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            throw e;
        } finally {
            session.close();
        }
        return result;
    }

    public int updateMember(Member member) {
        int result = 0;
        SqlSession session = getSqlsession();
        try {
            result = memberDao.updateMember(session, member);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public int updatePassword(Member member) {
        int result = 0;
        SqlSession session = getSqlsession();
        try {
            result = memberDao.updatePassword(session, member);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public int updateRole(Member member) {
        int result = 0;
        SqlSession session = getSqlsession();
        try {
            result = memberDao.updateRole(session, member);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public int deleteMember(String id) {
        int result = 0;
        SqlSession session = getSqlsession();
        try {
            result = memberDao.deleteMember(session, id);
            session.commit();
        } catch (Exception e) {
            session.rollback();
        } finally {
            session.close();
        }
        return result;
    }
}
