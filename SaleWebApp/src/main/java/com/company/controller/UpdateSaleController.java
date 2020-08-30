package com.company.controller;

import com.mycompany.Main.Context;
import com.mycompany.dao.inter.OnHandGoodDaoInter;
import com.mycompany.dao.inter.SoldGoodDaoInter;
import com.mycompany.entity.OnHandGood;
import com.mycompany.entity.SoldGood;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateSaleController" , urlPatterns = {"/updateSale"})
public class UpdateSaleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      if(req.getParameter("submit").equals("update")){
          String unit = req.getParameter("unitUps");
          float price = Float.parseFloat(req.getParameter("priceUps"));
          float count = Float.parseFloat(req.getParameter("countUps"));
          int id = Integer.parseInt(req.getParameter("idUps"));

          int idHandGood = Integer.parseInt(req.getParameter("idHandGood"));

          OnHandGoodDaoInter handGoodDao = Context.instanceOnHandGoodDao();
          OnHandGood handGood = handGoodDao.getOnHandGoodById(idHandGood);

          SoldGoodDaoInter goodDao = Context.instanceSoldGoodDao();
          SoldGood good = goodDao.getSoldGoodById(id);

          handGood.setCount(handGood.getCount()+good.getCount()-count);

          handGoodDao.updateOnHandGood(handGood);

          good.setCount(count);
          good.setPrice(price);
          good.setVahid(unit);
          goodDao.updateSoldGood(good);
          resp.sendRedirect("userdetail");
      }else if(req.getParameter("submit").equals("delete")){
          int idSoldGood = Integer.parseInt(req.getParameter("idSale"));
          int idOnHandGood = Integer.parseInt(req.getParameter("idGood"));

          SoldGoodDaoInter soldgoodDao = Context.instanceSoldGoodDao();
          SoldGood soldgood = soldgoodDao.getSoldGoodById(idSoldGood);

          OnHandGoodDaoInter goodDao = Context.instanceOnHandGoodDao();
          OnHandGood good = goodDao.getOnHandGoodById(idOnHandGood);

          good.setCount(good.getCount()+soldgood.getCount());
          goodDao.updateOnHandGood(good);

          soldgoodDao.removeSoldGood(idSoldGood);
          resp.sendRedirect("userdetail");
      }
    }
}
