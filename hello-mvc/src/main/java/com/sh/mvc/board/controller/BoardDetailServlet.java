package com.sh.mvc.board.controller;

import com.sh.mvc.board.model.service.BoardService;
import com.sh.mvc.board.model.vo.BoardVO;
import com.sh.mvc.common.HelloMvcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet {
    private BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자 입력값 처리
        long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);

        // 2. 업무로직
        BoardVO board = boardService.findById(id);
        System.out.println(board);

        // 개행문자 (\n) -> <br>
        board.setContent(HelloMvcUtils.convertLineFeedToBr(board.getContent()));
        req.setAttribute("board", board);

        // 3. forward
        req.getRequestDispatcher("/WEB-INF/views/board/boardDetail.jsp").forward(req, resp);
    }
}