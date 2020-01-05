<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/9 0009
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="./utils/jquery-1.12.4.js"></script>
    <script src="./utils/js/bootstrap.js"></script>
    <script src="./utils/myjs/tushuchaxun.js"></script>
    <link rel="stylesheet" href="./utils/css/bootstrap.css">
    <style>
        .bottomdiv{
            position: absolute;
            right: 1px;
            bottom: 50px;
        }
        td{
            vertical-align: middle !important;
        }

    </style>
</head>
<body>
<div class="container">
    <div class="list-group">
        <a href="/duzheML" class="list-group-item col-md-3">读者管理</a>
        <a href="/tushuML" class="list-group-item col-md-3">图书管理</a>
        <a href="/jieyueML" class="list-group-item col-md-3">借阅管理</a>
        <a href="/user" class="list-group-item col-md-3">用户管理</a>
    </div>
    <br>
    <br>
    <div>

        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">简单查询</a></li>
            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">高级查询</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home">
                <table>
                    <tr>
                        <td class="col-md-9">
                                <div class="page-header">
                                    <h3>借阅管理 <small></small></h3>
                                </div>

                                <div>

                                    <table class="table table-hover" id="table">
                                        <tr>
                                            <td>图书封面</td>
                                              <td>ID</td>
                                              <td>索书号</td>
                                              <td>书名</td>
                                              <td>作者</td>
                                              <td>出版社</td>
                                              <td>出版日期</td>
                                              <td>类别</td>
                                              <td>语种</td>
                                              <td>页数</td>
                                              <td>入馆时间</td>
                                              <td>状态</td>
                                        </tr>
                                    </table>

                            </div>
                        </td>

                        <td class="col-md-3">
                            <div >

                                <form action="" id="Myform">
                                    <table>
                                        <tr>
                                            <td class="col-md-4">
                                                <label >检索字段:</label>
                                                <select class="form-control" id="jiashuoziduan" style="width: 200px;">
                                                    <option>书名</option>
                                                    <option>作者</option>
                                                    <option>出版社</option>
                                                </select>
                                                <input type="hidden" id="ziduan" name="field">
                                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                <input type="text" class="form-control" id="Info" name="Info" style="width: 200px;"  placeholder="username">

                                                <br>
                                                <button type="button" id="submit" class="btn btn-primary">查询</button>
                                            </td>

                                        </tr>
                                    </table>
                                </form>

                            </div>
                        </td>
                    </tr>
                </table>


                <div class="bottomdiv">
                    <div class="btn-group btn-group-justified" role="group" aria-label="...">
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-default">修改</button>
                                </div>
                                <div class="btn-group" role="group">
                                    <button type="button" class="btn btn-default">删除</button>
                                </div>
                                <div class="btn-group" role="group">
                                    <button type="button" class="btn btn-default">导出excel</button>
                                </div>
                                <div class="btn-group" role="group">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                                </div>
                    </div>
                </div>

            </div>

            <div role="tabpanel" class="tab-pane" id="profile">
                <br>
                <br>

                <table>
                    <tr>
                        <td class="col-md-3">
                            <form action="" id="findBookBySelects">
                                <div >
                                    <table>
                                        <tr>
                                            <td class="col-md-3">
                                                <label >图书名称:</label>
                                                <input type="text" class="form-control" name="bookName" id="bookName">
                                            </td>
                                            <td class="col-md-3">
                                                <label >图书作者:</label>
                                                <input type="text" class="form-control" name="AuthorName" id="AuthorName">
                                            </td>
                                            <td class="col-md-3">
                                                <label >图书概述:</label>
                                                <input type="text" class="form-control" name="bookBrief" id="bookBrief" >
                                            </td>
                                        </tr>

                                        <tr>
                                            <td class="col-md-3">
                                                <label >出版社名:</label>
                                                <input type="text" class="form-control" name="PressName" id="PressName">
                                            </td>
                                            <td class="col-md-3">
                                                <label >类型:</label>
                                                <input type="text" class="form-control" name="sort" id="sort">
                                            </td>
                                            <td class="col-md-3">
                                                <label >出版年:</label>
                                                <input type="text" class="form-control" name="PressDate" id="PressDate" placeholder="2000-2-1">
                                            </td>
                                            <td class="col-md-3">
                                                <label>&nbsp;</label>
                                                &nbsp;&nbsp;&nbsp;    <button class="btn btn-primary" type="button" id="submitSelects">查询</button>
                                            </td>
                                        </tr>

                                    </table>
                                </div>
                            </form>

                        </td>
                    </tr>



                    <tr>
                        <td class="col-md-9">
                            <div class="page-header">
                                <h3>查询结果 <small><button type="button" class="btn btn-link">导出Excel</button></small></h3>
                            </div>
                            <div>
                                <table class="table table-hover" id="selectsTable">
                                    <tr>
                                        <td>图书封面</td>
                                        <td>ID</td>
                                        <td>索书号 </td>
                                        <td>书名</td>
                                        <td>作者</td>
                                        <td>出版社</td>
                                        <td>出版日期</td>
                                        <td>类别</td>
                                        <td>语种</td>
                                        <td>页数</td>
                                        <td>入馆时间</td>
                                        <td>状态</td>
                                        <td>
                                            <lable>删除</lable>
                                        </td>
                                    </tr>

                                </table>
                            </div>
                        </td>

                    </tr>
                </table>
            </div>
        </div>


    </div>





</div>

</body>
</html>
