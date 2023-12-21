package com.sh.mvc.board.controller;

import com.sh.mvc.board.model.service.BoardService;
import com.sh.mvc.board.model.vo.BoardVO;
import com.sh.mvc.common.HelloMvcUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * XSS 공격
 * - Cross-site Scripting 공격
 * - 악성스크립트를 웹페이지에 삽입해서 클라이언트 개인정보를 탈취하는 공격법
 * - script태그로 구성된 내용을 필터링 없이 그대로 화면에 출력할때 취햑할 수 있다.
 * - Escape Html처리를 통해서 사용자 입력값이 html요소로 작동하지 못하게 해야 한다.
 */
@WebServlet("/board/boardDetail")
public class BoardDetailServlet extends HttpServlet {
    private BoardService boardService = new BoardService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자 입력값 처리
        long id = Long.parseLong(req.getParameter("id"));
        System.out.println(id);

        // 2. 업무로직
        // 조회수 관련처리
        Cookie[] cookies = req.getCookies();
        List<String> boardCookieValues = getBoardCookieValues(cookies);
        boolean hasRead = boardCookieValues.contains(String.valueOf(id)); // 현재 게시글 읽음 여부
        System.out.println(hasRead); // true라면 이미 읽은 상태, false라면 처음 읽은 상태이다.

        // 조회
        BoardVO board = boardService.findById(id, hasRead);
        System.out.println(board);

        // xss 공격대비 escaoeHTML처리
        String safeHTML = HelloMvcUtils.escapeHTML(board.getContent());
        // 개행문자 (\n) -> <br>
        board.setContent(HelloMvcUtils.convertLineFeedToBr(safeHTML));
        req.setAttribute("board", board);

        // 응답 쿠키 생성
        // 만료시간 쿠키종류
        // - session cookie -1 지정한 경우, session이 만료되면 쿠키 자동 삭제
        // - persistant cookie n초 지정한 경우
        if(!hasRead) {
            boardCookieValues.add(String.valueOf(id)); // 현재 게시글 id를 추가
            String value = String.join("/", boardCookieValues);
            Cookie cookie = new Cookie("board", value);
            cookie.setMaxAge(365 * 24 * 60 * 60); // 1년 유지 쿠기, 음수인 경우 session종료시 삭제, 0인 경우 즉시 삭제
            cookie.setPath(req.getContextPath() + "/board/boardDetail"); // 지정한 경로일때만 클라이언트에서 서버로 쿠키 전송
            resp.addCookie(cookie);
        }

        // 3. forward
        req.getRequestDispatcher("/WEB-INF/views/board/boardDetail.jsp").forward(req, resp);
    }

    private List<String> getBoardCookieValues(Cookie[] cookies) {
        List<String> boardCookieValues = new ArrayList<>();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                String value = cookie.getValue();
                System.out.println(name + " = " + value);
                if ("board".equals(name)) {
                    String[] temp = value.split("/"); // 23/34/56
                    for (String _id : temp) {
                        boardCookieValues.add(_id);
                    }
                }
            }
        }
        return boardCookieValues;
    }
}