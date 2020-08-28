package com.company.controller;

import com.mycompany.Main.Context;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.font.FontRenderContext;
import java.io.IOException;

@WebServlet(name = "SignupController",urlPatterns = {"/signup"})
public class SignupController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("signup.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try{
           String name = req.getParameter("name");
           String surname = req.getParameter("surname");
           String email = req.getParameter("email");
           String password = req.getParameter("password");
           String place = req.getParameter("place");

           User user = new User(name,surname,place,email,password,0);
           UserDaoInter userDao = Context.instanceUserDao();
           userDao.addUser(user);
           resp.sendRedirect("login");
       }catch (Exception ex){
           resp.sendRedirect("error?msg=warning");
       }


    }
}
