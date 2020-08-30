<%@ page import="com.mycompany.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/28/2020
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserDetail</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <link rel="stylesheet" href="assets/css/userdetail.css" type="text/css">

</head>
<body style="overflow-x: hidden">
  <%User u = (User) session.getAttribute("loggedInUser");%>

  <div class="row"  >
      <div class="col-2" >
          <div class="tabsPanel" >
             <h1 style="text-align: center;margin-top: 50px;font-family: Papyrus;color: white ">SaleApp</h1>
              <div style="margin: 20px 0">
                  <ul class="nav nav-tabs" style="margin: 0 5%">
                      <li class="active"><a class="btn btn-success " style="padding: 50px 10px;background-color: #1D656A;border: 1px solid transparent;border-radius: 50%" data-toggle="tab" href="#onHand" onmouseover="this.style.backgroundColor='#6d0883'" onmouseout="this.style.backgroundColor='#1D656A'">On Hand Goods</a></li>
                      <li><a  class="btn btn-success" style="padding: 50px 10px;background-color: #1D656A;border: 1px solid transparent;border-radius: 50%" data-toggle="tab" href="#sale" onmouseover="this.style.backgroundColor='#6d0883'" onmouseout="this.style.backgroundColor='#1D656A'">Sale</a></li>
                      <li><a class="btn btn-success " style="padding: 50px 10px;background-color: #1D656A;border: 1px solid transparent;border-radius: 50%" data-toggle="tab" href="#soldGoods" onmouseover="this.style.backgroundColor='#6d0883'" onmouseout="this.style.backgroundColor='#1D656A'">Sold Goods</a></li>
                  </ul>
             </div>
             <form method="POST" action="logout" >
                 <button type="submit" style="margin-left: 30%" class="btn btn-warning btn-sm" name="logout"><i style="margin-right: 5px" class="fas fa-arrow-alt-circle-left"></i>LogOut</button>

             </form>
              <p  style="font-size: 9px;padding: 0 8px;color: aliceblue">Copyright © 2020 Developed by Mahammad Niyazli</p>
          </div>

      </div>

      <div class="col-10">
          <div class="tab-content">

              <div id="onHand" class="tab-pane  in active">
                  <jsp:include page="onHandGood.jsp" />
              </div>

              <div id="sale" class="tab-pane fade ">
                  <jsp:include page="sale.jsp" />
              </div>

              <div id="soldGoods" class="tab-pane fade ">
                  <jsp:include page="sold.jsp" />
              </div>

          </div>

      </div>

  </div>
</body>
</html>
