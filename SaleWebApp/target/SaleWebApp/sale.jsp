<%@ page import="com.mycompany.entity.OnHandGood" %>
<%@ page import="com.mycompany.entity.User" %>
<%@ page import="com.mycompany.dao.inter.OnHandGoodDaoInter" %>
<%@ page import="com.mycompany.Main.Context" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.dao.inter.SoldGoodDaoInter" %>
<%@ page import="com.mycompany.entity.SoldGood" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/30/2020
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>Sale</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="assets/js/sale.js"></script>
</head>
<body>
<%
    User user = (User) session.getAttribute("loggedInUser");

    OnHandGoodDaoInter onHandDao = Context.instanceOnHandGoodDao();
    List<OnHandGood> listOnHand =  onHandDao.getOnHandGoodByUserId(user);
    Date date = new Date();
    SoldGoodDaoInter soldDao = Context.instanceSoldGoodDao();
    List<SoldGood> listSold = soldDao.getSoldGoodByUserIdAndDate(user,date);



%>
<div class="container">
<form method="POST" action="sale" class="form-inline" >
    <div class="form-group" >
        <label for="onHandGood">Name:</label>
        <input list="goods" name="onHandGood" class="form-control" id="onHandGood" required>
        <datalist id="goods" >
            <%for (OnHandGood good : listOnHand){%>
            <option value="<%=good.getName()%>,<%=good.getId()%>" >
                    <%}%>
        </datalist>
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
        <input type="submit" style="margin-left: 10px"  class="form-control btn btn-info" name="sell" value="Sell" >
    </div>

</form >



<div class="container" style="margin-top: 50px" >
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th>Price/azn</th>
            <th>Count</th>
            <th>Unit</th>
            <th>Sales Date</th>
        </tr>
        </thead>
        <tbody>
        <%for (SoldGood good : listSold){%>
        <tr>
            <td><%=good.getOnHandGoodId().getName()%></td>
            <td><%=good.getPrice()%></td>
            <td><%=good.getCount()%></td>
            <td><%=good.getVahid()%></td>
            <td><%=new SimpleDateFormat("yyyy-MM-dd").format(good.getSalesDate())%></td>
            <td><button class="btn btn-info" type="button" data-toggle="modal" data-target="#updateModel1" value="update" onclick="forUpdate(<%=good.getPrice()%>,<%=good.getCount()%>,'<%=good.getVahid()%>',<%=good.getId()%>,<%=good.getOnHandGoodId().getId()%>)" ><i style="font-size:15px"class="fas fa-pen-square"></i></button></td>
            <td><button class="btn btn-danger" type="submit" value="delete" data-toggle="modal" data-target="#exampleModal" onclick="setIdForDelete(<%=good.getId()%>,<%=good.getOnHandGoodId().getId()%>)">
                <i style="font-size:15px" class="far fa-trash-alt"></i></button></td>
        </tr>
        <%}%>
        </tbody>
    </table>
</div>

    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Delete</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Are you sure?
                </div>
                <div class="modal-footer">
                    <form action="updateSale" method="POST">
                        <input type="hidden" name="idSale" value="" id="idSale">
                        <input type="hidden" name="idGood" value="" id="idGood">
                        <input type="hidden" name="submit" value="delete" >
                        <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                        <button type="submit" class="btn btn-danger" >Delete</button>
                    </form>
                </div>
            </div>
        </div>
    </div>

<div class="modal fade" id="updateModel1" tabindex="-1" role="dialog" aria-labelledby="UpdateModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="UpdateModalLabel">Update</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="updateSale" method="POST" >
                <div class="modal-body">


                    <div class="form-group ">
                        <label for="priceUps">Price/azn:</label>
                        <input type="number" step="any" class="form-control" name="priceUps"  id="priceUps" value="" >
                    </div>

                    <div class="form-group ">
                        <label for="countUps">Count:</label>
                        <input type="number" step="any" class="form-control" name="countUps"  id="countUps" value="" >
                    </div>

                    <div class="form-group ">
                        <label for="unitUps">Unit:</label>
                        <input type="text" class="form-control" name="unitUps"  id="unitUps" value="" >
                    </div>

                    <input type="hidden" class="form-control" name="idUps"  id="idUps" value="" >
                    <input type="hidden" class="form-control" name="idHandGood"  id="idHandGood" value="" >
                    <input type="hidden" name="submit" value="update" >
                </div>
                <div class="modal-footer">

                    <button type="button" class="btn btn-success" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger"  name="update" >Update</button>

                </div>
            </form>
        </div>
      </div>
  </div>
</div>
</body>
</html>
