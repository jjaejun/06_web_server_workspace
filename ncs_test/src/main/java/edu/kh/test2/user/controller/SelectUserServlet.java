package edu.kh.test2.user.controller;

import edu.kh.test2.user.model.service.UserService;
import edu.kh.test2.user.model.vo.User;

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

        String userId = req.getParameter("userId");

        User user = userService.findById(userId);
        req.setAttribute("user", user);

        String location;
        if (user != null) {
            location = "/WEB-INF/views/searchSuccess.jsp";
        } else {
            location = "/WEB-INF/views/searchFail.jsp";
        }
        req.getRequestDispatcher(location).forward(req, resp);
    }
}
