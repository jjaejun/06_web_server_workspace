package edu.kh.test.user.controller;

import edu.kh.test.user.model.service.UserService;
import edu.kh.test.user.model.vo.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectUser")
public class SelectUserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        int userNo = Integer.parseInt(req.getParameter("userNo"));
        System.out.println(userNo);

        UserDTO userDTO = userService.findByNo(userNo);
        req.setAttribute("userDTO", userDTO);
        System.out.println(userDTO);

        String location;
        if (userDTO != null) {
            location = "/WEB-INF/views/searchSuccess.jsp";
        } else {
            location = "/WEB-INF/views/searchFail.jsp";
        }
        req.getRequestDispatcher(location).forward(req, resp);
    }
}
