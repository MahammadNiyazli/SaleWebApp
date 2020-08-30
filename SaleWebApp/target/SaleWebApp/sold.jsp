<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="com.mycompany.dao.inter.SoldGoodDaoInter" %>
<%@ page import="com.mycompany.Main.Context" %>
<%@ page import="com.mycompany.entity.User" %>
<%@ page import="com.mycompany.entity.SoldGood" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: User
  Date: 8/30/2020
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SoldGood</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
    <script src="assets/js/sold.js"></script>
</head>
<body>

<%
    List<SoldGood> list=new ArrayList<>();
    if(request.getParameter("date")!=null && !request.getParameter("date").equals("") && request.getParameter("submit").equals("Search")){
        User user = (User) request.getSession().getAttribute("loggedInUser");
        String dateStr = request.getParameter("date");
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        SoldGoodDaoInter soldGoodDao = Context.instanceSoldGoodDao();
        list = soldGoodDao.getSoldGoodByUserIdAndDate(user,date);
    }

%>
<div class="container" >

<div class="container" style="margin-top: 50px">
  <form class="form-inline" method="POST" action="sold" style="display: inline">
      <div class="form-group" style="display: inline">
          <label for="date" style="margin-right: 5px;display: inline">Date:</label>
          <input type="date" name="date" class="form-control" id="date" required>
      </div>

      <div class="form-group" style="margin-left: 5px;display: inline">
          <input type="submit"  name="submit" class="form-control btn btn-info" value="Search">
      </div>

  </form>

    <form class="form-inline" method="POST" action="userdetail" style="display: inline">

        <div class="form-group" style="margin-left: 5px;display: inline" >
            <input type="submit"  name="submit" class="form-control btn btn-info" value="Reset">
        </div>

    </form>

</div>
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
            <%for (SoldGood good : list){%>
            <tr>
                <td><%=good.getOnHandGoodId().getName()%></td>
                <td><%=good.getPrice()%></td>
                <td><%=good.getCount()%></td>
                <td><%=good.getVahid()%></td>
                <td><%=new SimpleDateFormat("yyyy-MM-dd").format(good.getSalesDate())%></td>
                <td><button class="btn btn-info" type="button" data-toggle="modal" data-target="#updateModel1" value="update" onclick="forUpdatesold(<%=good.getPrice()%>,<%=good.getCount()%>,'<%=good.getVahid()%>',<%=good.getId()%>,<%=good.getOnHandGoodId().getId()%>)" ><i style="font-size:15px"class="fas fa-pen-square"></i></button></td>
                <td><button class="btn btn-danger" type="submit" value="delete" data-toggle="modal" data-target="#exampleModal" onclick="setIdForDeletesold(<%=good.getId()%>,<%=good.getOnHandGoodId().getId()%>)">
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
                        <input type="hidden" name="idSale" value="" id="idSalesold">
                        <input type="hidden" name="idGood" value="" id="idGoodsold">
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
                            <label for="priceUpsold">Price/azn:</label>
                            <input type="number" step="any" class="form-control" name="priceUps"  id="priceUpsold" value="" >
                        </div>

                        <div class="form-group ">
                            <label for="countUpsold">Count:</label>
                            <input type="number" step="any" class="form-control" name="countUps"  id="countUpsold" value="" >
                        </div>

                        <div class="form-group ">
                            <label for="unitUpsold">Unit:</label>
                            <input type="text" class="form-control" name="unitUps"  id="unitUpsold" value="" >
                        </div>

                        <input type="hidden" class="form-control" name="idUps"  id="idUpsold" value="" >
                        <input type="hidden" class="form-control" name="idHandGood"  id="idHandGoodsold" value="" >
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
