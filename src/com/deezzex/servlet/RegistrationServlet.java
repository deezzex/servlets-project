/**
 * @author deezzex <3
 */


package com.deezzex.servlet;

import com.deezzex.entity.dto.CreateUserDto;
import com.deezzex.entity.enums.Role;
import com.deezzex.exception.ValidationException;
import com.deezzex.service.UserService;
import com.deezzex.util.EnumHelper;
import com.deezzex.util.JspHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    private final UserService userService = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("roles", EnumHelper.roles());
        req.setAttribute("genders", EnumHelper.genders());

        req.getRequestDispatcher(JspHelper.getPath("registration"))
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var birthday = userService.buildBirthday(
                req.getParameter("day"),
                req.getParameter("month"),
                req.getParameter("year"));

        var createUserDto = CreateUserDto.builder()
                .userName(req.getParameter("username"))
                .firstName(req.getParameter("firstname"))
                .lastName(req.getParameter("lastname"))
                .email(req.getParameter("email"))
                .birthday(birthday)
                .role("ADMIN")
                .gender(req.getParameter("gender"))
                .password(req.getParameter("password"))
                .build();

        try {
            userService.create(createUserDto);
            resp.sendRedirect("/login");
        }catch (ValidationException exception){
            req.setAttribute("errors", exception.getErrors());
            doGet(req, resp);
        }
    }
}
