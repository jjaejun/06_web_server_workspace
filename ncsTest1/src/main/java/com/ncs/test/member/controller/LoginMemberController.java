package com.ncs.test.member.controller;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginMemberController extends HttpServlet {
    private MemberService memberService = new MemberService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 사용자 입력값 인코딩 처리
        req.setCharacterEncoding("utf-8");

        // 2. 사용자 입력값 가져오기
        String memberId = req.getParameter("memberId");
        String memberPwd = req.getParameter("memberPwd");
        System.out.println("id = " + memberId);
        System.out.println("pw = " + memberPwd);

        // 3. 업무로직
        Member member = memberService.loginMember(memberId);
        System.out.println(member);

        HttpSession session = req.getSession();
        if(member != null && memberPwd.equals(member.getMemberPwd())) {
            session.setAttribute("loginMember", member);

            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            resp.sendRedirect(req.getContextPath() + "/");
            session.setAttribute("msg", "로그인 실패");
        }
    }
}
