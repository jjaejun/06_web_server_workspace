package com.sh.mvc.board.model.dao;

import com.sh.mvc.board.model.entity.Attachment;
import com.sh.mvc.board.model.entity.Board;
import com.sh.mvc.board.model.vo.BoardVO;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class BoardDao {

    public List<BoardVO> findAll(SqlSession session) {
        return session.selectList("board.findAll");
    }

    public int getTotalCount(SqlSession session) {
        return session.selectOne("board.getTotalCount");
    }

    public BoardVO findById(SqlSession session, long id) {
        return session.selectOne("board.findById", id);
    }

    public List<BoardVO> findAll(SqlSession session, Map<String, Object> param) {
        int page = (int) param.get("page");
        int limit = (int) param.get("limit");
        int offset = (page - 1) * limit;
        return session.selectList("board.findAll", null, new RowBounds(offset, limit));
    }

    public int insertBoard(SqlSession session, Board board) {
        return session.insert("board.insertBoard", board);
    }

    public int updateBoard(SqlSession session, Board board) {
        return session.update("board.updateBoard", board);
    }

    public int deleteBoard(SqlSession session, long id) {
        return session.delete("board.deleteBoard", id);
    }

    public int insertAttachment(SqlSession session, Attachment attach) {
        return session.insert("board.insertAttachment", attach);
    }
}
