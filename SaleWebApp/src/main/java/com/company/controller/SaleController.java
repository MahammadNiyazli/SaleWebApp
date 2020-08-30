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

@WebServlet(name = "SaleController" , urlPatterns = {"/sale"})
public class SaleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("loggedInUser");
        OnHandGoodDaoInter onHandDao = Context.instanceOnHandGoodDao();
        SoldGoodDaoInter soldGoodDao = Context.instanceSoldGoodDao();
        String goodStr = req.getParameter("onHandGood");
        String[] arr = goodStr.split(",");
        int id = Integer.parseInt(arr[1]);
        OnHandGood good = onHandDao.getOnHandGoodById(id);

        String unit = req.getParameter("unit");
        float price = Float.parseFloat(req.getParameter("price"));
        float count = Float.parseFloat(req.getParameter("count"));
        good.setCount(good.getCount()-count);
        onHandDao.updateOnHandGood(good);
        Date date  = new Date();
        SoldGood soldGood = new SoldGood(0,date,price,count,unit,good,user);
        soldGoodDao.addSoldGood(soldGood);
        resp.sendRedirect("userdetail");

    }
}
