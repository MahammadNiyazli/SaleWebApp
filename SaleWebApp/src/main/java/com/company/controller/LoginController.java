package com.company.controller;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.mycompany.Main.Context;
import com.mycompany.dao.inter.UserDaoInter;
import com.mycompany.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginController",urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String submit = req.getParameter("submit");
        if(submit.equals("Login")){
           try {
               String email = req.getParameter("email");
               String password = req.getParameter("password");

               UserDaoInter userDao = Context.instanceUserDao();
               User user = userDao.findByEmail(email);
               if(user==null){
                   throw new IllegalArgumentException("This user not exist");
               }

               BCrypt.Verifyer verify = BCrypt.verifyer();
               BCrypt.Result rs = verify.verify(password.toCharArray(),user.getPassword().toCharArray());

               if(!rs.verified){
                   throw new IllegalArgumentException("Password doesn't exist");
               }

               req.getSession().setAttribute("loggedInUser",user);
               resp.sendRedirect("userdetail");
           }catch (Exception ex){
               resp.sendRedirect("error?msg="+ex.getMessage());
           }


        }else if(submit.equals("Sign Up")){
            resp.sendRedirect("signup");
        }
    }
}
