<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/8 0008
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="./utils/jquery-1.12.4.js"></script>
    <script src="./utils/js/bootstrap.js"></script>
    <link rel="stylesheet" href="./utils/css/bootstrap.css">
</head>
<body>

<div class="container">
    <div class="container">
        <div class="page-header">
            <h1>欢迎来到登录页面1 <small>good</small></h1>
        </div>
    </div>
    <div class="container">
        <div class="col-md-6 col-md-offset-3">
            <form action="/check">
                <div>
                    <%--<label for="exampleInputEmail1">用户名</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" placeholder="username">--%>
                    <label >用户编号</label>
                    <input type="text" class="form-control" name="username">
                </div>
                <br>
                <div>
                    <label>用户密码</label>
                    <input type="password" class="form-control"  name="password">
                </div>
                <br>
                <br>

                <button type="button" class="btn btn-default col-md-4">退出</button>
                <label class="col-md-4"></label>
                <button type="submit" class="btn btn-default col-md-4">登录</button>

            </form>
        </div>
    </div>
</div>

</body>
</html>
