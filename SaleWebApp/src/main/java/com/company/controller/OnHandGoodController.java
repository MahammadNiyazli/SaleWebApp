package com.company.controller;

import com.mycompany.Main.Context;
import com.mycompany.dao.inter.OnHandGoodDaoInter;
import com.mycompany.entity.OnHandGood;
import com.mycompany.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OnHandGoodController" , urlPatterns = {"/onhand"})
public class OnHandGoodController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = (User) req.getSession(false).getAttribute("loggedInUser");
        String name = req.getParameter("name");
        float price = Float.parseFloat(req.getParameter("price"));
        float count = Float.parseFloat(req.getParameter("count"));
        String vahid = req.getParameter("unit");

        OnHandGood good = new OnHandGood(name,price,count,vahid,user);

        OnHandGoodDaoInter onHandGoodDao = Context.instanceOnHandGoodDao();
        onHandGoodDao.addOnHandGood(good);
        resp.sendRedirect("userdetail");

    }
}
