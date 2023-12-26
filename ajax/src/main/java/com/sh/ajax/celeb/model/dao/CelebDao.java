package com.sh.ajax.celeb.model.dao;

import com.sh.ajax.celeb.model.entity.Celeb;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CelebDao {
    public List<Celeb> findAll(SqlSession session) {
        return session.selectList("celeb.findAll");
    }

    public Celeb findById(SqlSession session, long id) {
        return session.selectOne("celeb.findById", id);
    }

    public Celeb findByName(SqlSession session, String name) {
        return session.selectOne("celeb.findByName", name);
    }

    public int insertCeleb(SqlSession session, Celeb celeb) {
        return session.insert("celeb.insertCeleb", celeb);
    }

    public int updateCeleb(SqlSession session, Celeb celeb) {
        return session.update("celeb.updateCeleb",celeb);
    }

    public int deleteCeleb(SqlSession session, Long id) {
        return session.delete("celeb.deleteCeleb", id);
    }
}
