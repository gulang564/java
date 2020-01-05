<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/9 0009
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借阅管理</title>
    <script src="./utils/jquery-1.12.4.js"></script>
    <script src="./utils/js/bootstrap.js"></script>
    <script src="./utils/myjs/jieyueML.js"></script>
    <link rel="stylesheet" href="./utils/css/bootstrap.css">
    <style>
        td{
            vertical-align: middle !important;
        }
    </style>
</head>
<body>
<div class="container">

    <div class="page-header">
        <div class="list-group">
            <a href="/duzheML" class="list-group-item col-md-3">读者管理</a>
            <a href="/tushuML" class="list-group-item col-md-3">图书管理</a>
            <a href="/jieyueML" class="list-group-item col-md-3">借阅管理</a>
            <a href="/user" class="list-group-item col-md-3">用户管理</a>
        </div>
    </div>

    <div class="col-md-12" style="height:20px"></div>
            <div class="col-md-8">
                <table class="table table-hover">
                    <tr>
                        <%--<label for=""></label>没有高度--%>
                        <td class="col-md-4">读者姓名:&nbsp;&nbsp;<label id="rName"></label></td>

                        <td class="col-md-4">读者单位:&nbsp;&nbsp;<label id="danwei"></label></td>

                        <td class="col-md-4">读者类别:&nbsp;&nbsp;<label id="leibie"></label></td>

                    </tr>

                    <tr>
                        <td  class="col-md-2">可借书数量:&nbsp;&nbsp;<label id="shuliang"></label></td>

                        <td class="col-md-2">可借天数:&nbsp;&nbsp;<label id="kejietianshu"></label></td>


                        <td class="col-md-2">已借数量:&nbsp;&nbsp;<label id="yijieshuliang"></label></td>

                    </tr>
                </table>
            </div>
            <div class="input-group col-md-3">
                <input type="text" class="form-control" id="lendBookId" placeholder="Search for...">
                <span class="input-group-btn">
                                     <button class="btn btn-default" type="button" id="findBorrower">
                                         <span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span>  读者编号
                                     </button>
                        </span>
            </div>

    <div>
        <div>
            <table class="table table-hover" id="fanjingTable">
                <tr>
                    <td>图书ID</td>
                    <td>图书名称</td>
                    <td>图书作者 </td>
                    <td>续借次数</td>
                    <td>借阅日期</td>
                    <td>应还日期</td>
                    <td>超期天数</td>
                    <td>超期金额</td>
                </tr>
            </table>
        </div>
    </div>



    <div class="col-md-12" style="background-color: #fffcec; height: 10px;">
    </div>

<div>
    <div>
       <%-- <div class="input-group col-md-3">
            <input type="text" class="form-control" placeholder="Search for...">
            <span class="input-group-btn">
                                     <button class="btn btn-default" type="button" id="tushuxuhao">
                                         <span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span> 图书序号
                                     </button>
                        </span>
        </div>--%>

        <div class="input-group col-md-3">
            <input type="text" id="Info" class="form-control" placeholder="Search for...">
            <span class="input-group-btn">
                                     <button class="btn btn-default" type="button" id="tushumingcheng">
                                         <span class="glyphicon glyphicon-zoom-in" aria-hidden="true"></span> 图书名称
                                     </button>
                        </span>
        </div>
    </div>

    <div>
        <table class="table table-hover" id="bookInfo">
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
                    <lable>借阅</lable>
                </td>
            </tr>
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
                    <button type="button" class="btn" id="" data-toggle="modal" data-target="#myModal">
                        借阅
                    </button>
                </td>
            </tr>
        </table>
    </div>



    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/submitBorrowInfo">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">读者ID</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="jieyuehao" name="jieyuehao" placeholder="">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">图书号</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="tushuhao" name="tushuhao" placeholder="">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">借阅日期</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="jieyueriqi" name="jieyueriqi" placeholder="">
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="button" class="btn btn-default" id="submit">提交事件</button>
                            </div>
                        </div>

                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>


</div>


</div>

</body>
</html>
