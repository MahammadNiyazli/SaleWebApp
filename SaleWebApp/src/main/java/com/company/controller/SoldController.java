package com.company.controller;

import com.mycompany.Main.Context;
import com.mycompany.dao.inter.OnHandGoodDaoInter;
import com.mycompany.dao.inter.SoldGoodDaoInter;
import com.mycompany.entity.OnHandGood;
import com.mycompany.entity.SoldGood;
import com.mycompany.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "SoldController" , urlPatterns = {"/sold"})
public class SoldController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.getRequestDispatcher("sold.jsp").forward(req, resp);

    }
}
