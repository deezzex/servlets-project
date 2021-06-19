/**
 * @author deezzex <3
 */


package com.deezzex.servlet;

import com.deezzex.entity.dto.LoginUserDto;
import com.deezzex.exception.ValidationException;
import com.deezzex.service.UserService;
import com.deezzex.util.JspHelper;
import com.deezzex.validator.Error;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("error") != null){
            req.setAttribute("error", "Bad credentials");
        }
        req.getRequestDispatcher(JspHelper.getPath("login"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var userName = req.getParameter("userName");
        var password = req.getParameter("password");

            userService.login(userName, password).ifPresentOrElse(
                    user -> onLoginSuccess(user, req, resp),
                    () -> onLoginFailed(req, resp)
            );

    }

    @SneakyThrows
    private void onLoginFailed(HttpServletRequest req, HttpServletResponse resp) {
        resp.sendRedirect("/login?error&userName=" + req.getParameter("userName"));

    }

    @SneakyThrows
    private void onLoginSuccess(LoginUserDto user, HttpServletRequest req, HttpServletResponse resp){
        req.getSession().setAttribute("user", user);
        resp.sendRedirect("/products");
    }
}
