<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/9 0009
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读者管理</title>
    <script src="./utils/jquery-1.12.4.js"></script>
    <script src="./utils/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/utils/myjs/duzheML.js"></script>
    <link rel="stylesheet" href="./utils/css/bootstrap.css">
</head>
<body>
<%--读者管理，就是单纯的显示功能，遍历数据表就可以--%>
<div class="container">

        <div class="page-header">
            <div class="list-group">
                <a href="/duzheML" class="list-group-item col-md-3">读者管理</a>
                <a href="/tushuML" class="list-group-item col-md-3">图书管理</a>
                <a href="/jieyueML" class="list-group-item col-md-3">借阅管理</a>
                <a href="/user" class="list-group-item col-md-3">用户管理</a>
            </div>
        </div>
        <br>


    <div>
        <table class="table table-hover">
            <tr>
                <td>
                    <label >类型名称:</label>
                    <input type="text" class="form-control"  placeholder="username">
                </td>

                <td>
                    <label >可借数量:</label>
                    <input type="text" class="form-control"  placeholder="username">
                </td>

                <td>
                    <label >可借天数:</label>
                    <input type="text" class="form-control"  placeholder="username">
                </td>
            </tr>


            <tr>
                <td>
                    <label >可续借次数:</label>
                    <input type="text" class="form-control"  placeholder="username">
                </td>

                <td>
                    <label >罚金率:</label>
                    <input type="text" class="form-control"  placeholder="username">
                </td>

                <td>
                    <label >证件有效期:</label>
                    <input type="text" class="form-control"  placeholder="username">
                </td>
            </tr>
        </table>
    </div>



    <div>
        <div>
            <div class="page-header">
                <h2>查询结果 <small></small></h2>
            </div>
        </div>
        <div>
            <table class="table table-hover" id="table">
                <tr>
                    <td><label>读者类型</label></td>
                    <td><label>可借数量</label></td>
                    <td><label>可借天数</label></td>
                    <td><label>可续借次数</label></td>
                    <td><label>罚金率</label></td>
                    <td><label>这件有效期(年)</label></td>
                </tr>
            </table>
        </div>
    </div>


</div>
</body>
</html>
