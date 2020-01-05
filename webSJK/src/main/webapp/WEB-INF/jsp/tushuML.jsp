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
    <title>Title</title>
    <script src="./utils/jquery-1.12.4.js"></script>
    <script src="./utils/js/bootstrap.js"></script>
    <script src="./utils/myjs/tushuML.js"></script>
    <link rel="stylesheet" href="./utils/css/bootstrap.css">
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
    <br>
    <br>

    <div>
        <div class="col-md-2">
            <div class="list-group">

                <a href="#" class="list-group-item">新书入库</a>
                <a href="/tushuchaxun" class="list-group-item">图书查询</a>

            </div>
        </div>


    
    <div class="col-md-10">
        <div>
            <form action="/addBook" enctype="multipart/form-data" id="bookInfo" method="post">
                            <table>
                                <tr>
                                    <td class="col-md-4">
                                        <table>
                                            <tr>
                                                <td>
                                                    <label >图书起始序号:</label>
                                                    <input type="text" class="form-control" id="bkID" name="bkID">
                                                </td>

                                                <td>
                                                    <label >图书编号:</label>
                                                    <input type="text" class="form-control" id="bkCode" name="bkCode">
                                                </td>

                                            </tr>

                                            <tr>
                                                <td>
                                                    <label >图书名称:</label>
                                                    <input type="text" class="form-control" id="bkName" name="bkName">
                                                </td>
                                                <td>
                                                    <label >图书作者:</label>
                                                    <input type="text" class="form-control" id="bkAuthor" name="bkAuthor">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label >出版社:</label>
                                                    <input type="text" class="form-control" id="bkPress" name="bkPress">
                                                </td>
                                                <td>
                                                    <label >出版日期:</label>
                                                    <input type="text" class="form-control" id="bkDatePress" name="bkDatePress">
                                                </td>
                                            </tr>
                                            <tr>
                                                <td>
                                                    <label >分类名:</label>
                                                    <select class="form-control" id="Leibie">
                                                        <option>科学</option>
                                                        <option>历史</option>
                                                        <option>政治</option>
                                                        <option>人文</option>
                                                    </select>
                                                    <input type="hidden" id="bkLeibie" name="bkLeibie">
                                                </td>

                                                <td>
                                                    <label >语种:</label>
                                                    <select class="form-control" id="language">
                                                        <option>中文</option>
                                                        <option>英文</option>
                                                        <option>日文</option>
                                                        <option>俄文</option>
                                                        <option>法文</option>
                                                    </select>
                                                    <input type="hidden" id="bkLanguage" name="bkLanguage">
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <label >入馆日期:</label>
                                                    <input type="text" class="form-control" id="bkDateIn" name="bkDateIn">
                                                </td>
                                                <td>
                                                    <label >图书页数:</label>
                                                    <input type="text" class="form-control" id="bkPages" name="bkPages">
                                                </td>
                                            </tr>

                                            <tr>
                                                <td>
                                                    <label >在馆数量:</label>
                                                    <input type="text" class="form-control" id="bkNum" name="bkNum">
                                                </td>
                                                <td>
                                                    <label >状态:</label>
                                                    <input type="text" class="form-control" id="bkStatus" name="bkStatus">
                                                </td>
                                            </tr>
                                        </table>

                                    </td>

                                    <td class="col-md-4">
                                        <div>
                                            <h3>内容简介</h3>
                                            <textarea class="form-control" rows="17" id="jianjie"></textarea>
                                            <input type="hidden" name="bkBrief" id="bkBrief">
                                        </div>
                                    </td>

                                    <td class="col-md-4">
                                        <div>
                                            <h3>封面</h3>
                                            <img src="./utils/images/rdPhoto/1.png" alt="..." id="img" class="img-circle img-responsive" style="height: 200px;width: 200px;">
                                            <div>
                                                <input type="file" id="fileUpload" name="fileUpload">
                                                <input type="hidden" name="bkCover">
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                 </table>

            </form>
        </div>



        <div class="btn-group btn-group-justified" role="group" aria-label="...">
            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default" id="add">添加</button>
            </div>

            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default" id="change">确认修改</button>
            </div>


            <div class="btn-group" role="group">
                <button type="button" class="btn btn-default" id="quxiao">取消</button>
            </div>

        </div>

    </div>

    <div>


    </div>

    </div>
    

</div>

</body>
</html>
