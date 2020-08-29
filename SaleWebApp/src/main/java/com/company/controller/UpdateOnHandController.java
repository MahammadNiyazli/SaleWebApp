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

@WebServlet(name = "UpdateOnHandController" , urlPatterns = {"/updateOnHand"})
public class UpdateOnHandController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("nameUp");
        String unit = req.getParameter("unitUp");
        float price = Float.parseFloat(req.getParameter("priceUp"));
        float count = Float.parseFloat(req.getParameter("countUp"));
        int id = Integer.parseInt(req.getParameter("idUp"));

        OnHandGoodDaoInter goodDao = Context.instanceOnHandGoodDao();
        OnHandGood good = goodDao.getOnHandGoodById(id);
        good.setCount(count);
        good.setName(name);
        good.setPrice(price);
        good.setVahid(unit);
        goodDao.updateOnHandGood(good);
        resp.sendRedirect("userdetail");
    }
}
