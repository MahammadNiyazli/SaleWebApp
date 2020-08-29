<%@ page import="com.mycompany.entity.User" %>
<%@ page import="com.mycompany.dao.inter.OnHandGoodDaoInter" %>
<%@ page import="com.mycompany.Main.Context" %>
<%@ page import="com.mycompany.entity.OnHandGood" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/29/2020
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OnHandGood</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="assets/css/onhand.css">
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="assets/js/onhand.js"></script>

</head>
<body>

<%
    User user = (User) session.getAttribute("loggedInUser");

    OnHandGoodDaoInter onHandDao = Context.instanceOnHandGoodDao();
    String search = request.getParameter("search");
    String reset = request.getParameter("reset");
    List<OnHandGood> listOnHand;
    List<OnHandGood> listOnHand2 =  onHandDao.getOnHandGoodByUserId(user);
    if(search!=null){
       try {
           String goodStr = request.getParameter("onHandGood");
           String[] arr = goodStr.split(",");
           int id = Integer.parseInt(arr[1]);
           OnHandGood good = onHandDao.getOnHandGoodById(id);
           listOnHand = Arrays.asList(good);
       }catch (Exception ex){
           listOnHand =  onHandDao.getOnHandGoodByUserId(user);
       }
    }else{
        listOnHand =  onHandDao.getOnHandGoodByUserId(user);
    }



%>
<div class="container">
<form method="POST" action="onhand" class="form-inline">
    <div class="form-group ">
        <label for="name">Name:</label>
        <input type="text" class="form-control" name="name" placeholder="Enter name" id="name" required>
    </div>
    <div class="form-group">
        <label for="price">Price:</label>
        <input type="number" class="form-control" step="any" name="price" placeholder="Enter price/azn" id="price" required>
    </div>
    <div class="form-group">
        <label for="count">Count:</label>
        <input type="number" class="form-control" step="any" name="count" placeholder="Enter count" id="count" required>
    </div>
    <div class="form-group">
        <label for="unit">Unit:</label>
        <select class="form-control" name="unit" id="unit" required >
            <option>kq</option>
            <option>metr</option>
            <option>unit</option>
        </select>
    </div>
    <div class="form-group">
        <input type="submit" class="form-control btn btn-info" name="submit" value="Add" >
    </div>
</form >
  <form method="POST" action="userdetail" class="form-inline" style="margin-left: 69%">
      <div class="form-group" >
          <input list="goods" name="onHandGood" class="form-control" id="onHandGood" required>
          <datalist id="goods" >
              <%for (OnHandGood good : listOnHand2){%>
              <option value="<%=good.getName()%>,<%=good.getId()%>">
                      <%}%>
          </datalist>
          <input type="submit" style="margin-left: 10px"  class="form-control btn btn-info" name="search" value="Search" >
      </div>
  </form >
    <form method="POST" action="userdetail" class="form-inline" style="margin-left: 89.5%">
            <input type="submit" style="margin-left: 10px"  class="form-control btn btn-info" name="reset" value="Reset" >
    </form>

</div>
  <div class="container" >
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price/azn</th>
            <th>Count</th>
            <th>Unit</th>
        </tr>
        </thead>
        <tbody>
          <%for (OnHandGood good : listOnHand){%>
            <tr>
                <td><%=good.getName()%></td>
                <td><%=good.getPrice()%></td>
                <td><%=good.getCount()%></td>
                <td><%=good.getVahid()%></td>
                <td><button class="btn btn-info" type="button" data-toggle="modal" data-target="#updateModel" value="update" onclick="forUpdate('<%=good.getName()%>',<%=good.getPrice()%>,<%=good.getCount()%>,'<%=good.getVahid()%>',<%=good.getId()%>)" ><i style="font-size:15px"class="fas fa-pen-square"></i></button></td>
            </tr>
         <%}%>
        </tbody>
    </table>
  </div>

<div class="modal fade" id="updateModel" tabindex="-1" role="dialog" aria-labelledby="UpdateModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="UpdateModalLabel">Update</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="updateOnHand" method="POST" >
            <div class="modal-body">
                <div class="form-group ">
                    <label for="nameUp">Name:</label>
                    <input type="text" class="form-control" name="nameUp"  id="nameUp" value="" >
                </div>

                <div class="form-group ">
                    <label for="priceUp">Price/azn:</label>
                    <input type="number" step="any" class="form-control" name="priceUp"  id="priceUp" value="" >
                </div>

                <div class="form-group ">
                    <label for="countUp">Count:</label>
                    <input type="number" step="any" class="form-control" name="countUp"  id="countUp" value="" >
                </div>

                <div class="form-group ">
                    <label for="unitUp">Unit:</label>
                    <input type="text" class="form-control" name="unitUp"  id="unitUp" value="" >
                </div>

                <input type="hidden" class="form-control" name="idUp"  id="idUp" value="" >
            </div>
            <div class="modal-footer">

                    <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger" >Update</button>

            </div>
        </form>
        </div>
    </div>
</div>

</body>
</html>
