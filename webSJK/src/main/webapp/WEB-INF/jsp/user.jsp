<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/9 0009
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户页面</title>
    <script src="${pageContext.request.contextPath}/utils/jquery-1.12.4.js"></script>
    <script src="${pageContext.request.contextPath}/utils/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/utils/myjs/user.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/utils/css/bootstrap.css">
</head>
<body>
<div class="container">

    <div>
        <div>
            <div class="list-group">
                <a href="/duzheML" class="list-group-item col-md-3">读者管理</a>
                <a href="/tushuML" class="list-group-item col-md-3">图书管理</a>
                <a href="/jieyueML" class="list-group-item col-md-3">借阅管理</a>
                <a href="/user" class="list-group-item col-md-3">用户管理</a>
            </div>
        </div>



        <div>

            <form class="form-inline" id="check">
                <div class="form-group">
                    <label>读者类别</label>
                    <select class="form-control" id="UserType">
                        <option>教师</option>
                        <option>本科生</option>
                        <option>研究生</option>
                        <option>博士</option>
                    </select>

                </div>

                <div class="form-group">
                    <label>单位:</label>
                    <select class="form-control" id="danwei">
                        <option>计算机科学学院</option>
                        <option>化工学院</option>
                    </select>
                </div>

                <div class="form-group">
                    <label >姓名:</label>
                    <input type="text" id="username" class="form-control">
                </div>

                <button type="button" class="btn btn-default" id="findUser">查找</button>
                <button type="button" class="btn btn-default">Excel</button>
            </form>

            <div>
                <table class="table table-hover">
                   <tr>
                       <td>ID</td>
                       <td>姓名</td>
                       <td>性别</td>
                       <td>类型</td>
                       <td>院系</td>
                       <td>电话</td>
                       <td>email</td>
                       <td>状态</td>
                       <td>已借书</td>
                       <td>注册日期</td>
                   </tr>
                    <tr id="findOut">

                    </tr>
                </table>
            </div>

            <div style="position: absolute;right:260px;bottom: 50px">
                <!-- Button trigger modal --><%--都锚点到模态框上面--%>
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="banlijieshuzheng">办理借书证</button>
                <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="biangeng" disabled>变更信息</button>

                <!-- Indicates a successful or positive action -->
                <button type="button" class="btn btn-success" id="guashi">挂失</button>

                <!-- Contextual button for informational alert messages -->
                <button type="button" class="btn btn-info" id="jiechuguashi">解除挂失</button>

                <!-- Indicates caution should be taken with this action -->
                <button type="button" class="btn btn-warning" id="zhuxiao">注销</button>

            </div>
        </div>

    </div>


    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">用户信息</h4>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/saveUser" enctype="multipart/form-data" id="userForm" method="post">
                    <div class="top">

                        <div class="col-md-6">

                            <table class="table table-hover">
                                <tr>
                                    <td>
                                        <label >借书证号:</label>
                                        <input type="text" class="form-control" id="rdId" name="rdID">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label >姓名:</label>
                                        <input type="text" class="form-control" id="rdName" name="rdName">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label >密码:</label>
                                        <input type="text" class="form-control" id="rdPwd" name="rdPwd">
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label >性别:</label>
                                        <select id="rdSex" class="form-control">
                                            <option>男</option>
                                            <option>女</option>
                                        </select>
                                        <input type='hidden' id="hidesex" name="rdSex"/>
                                     </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label >已借书:</label>
                                        <input type="text" id="rdBorrowQty" name="rdBorrowQty" class="form-control">
                                     </td>
                                </tr>
                                <tr>
                                    <td>
                                        <label >证件状态:</label>
                                        <input type="text" id="rdStatus" name="rdStatus" class="form-control">
                                    </td>
                                </tr>
                               <%-- <tr>
                                    <td>
                                        <label >读者角色:</label>
                                        <input type="text" id="jiaose" class="form-control"  placeholder="username">
                                    </td>
                                </tr>--%>

                            </table>
                        </div>

                        <div class="col-md-6">
                            <img src="" id="rdPhoto" style="width:200px;height: 150px;" alt="">
                            <br>
                            <br>
                            <div>
                                <input type="file" value="上传图片" id="fileUpload" name="fileUpload"/>
                            </div>

                        </div>

                    </div>

                    <div class="bottom">
                        <table>
                            <tr>
                                <td>
                                    <label >读者类别:</label>
                                    <select id="leibie" class="form-control">
                                        <option>教师</option>
                                        <option>博士</option>
                                        <option>本科生</option>
                                        <option>研究生</option>
                                    </select>
                                    <input type='hidden' id="hideleibie" name="rdLeibie"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label >单位:</label>
                                    <select id="rdDept" class="form-control">
                                        <option>计算机科学学院</option>
                                        <option>化工学院</option>
                                    </select>
                                    <input type='hidden' id="hideDept" name="rdDept"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label >电话号码:</label>
                                    <input id="rdPhone" type="text" name="rdPhone" class="form-control">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label >电子邮件:</label>
                                    <input id="rdEmail" type="text" class="form-control" name="rdEmail">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label >办证日期:</label>
                                    <input id="rdDateReg" name="rdDateReg" type="text" class="form-control">
                                </td>
                            </tr>
                        </table>
                    </div>
                    </form>

                </div>
                <div class="modal-footer">

                    <div class="btn-group btn-group-justified" role="group" aria-label="...">
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-default" id="querenbanzheng">确认办证</button>
                        </div>
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-default" id="querenChange">确认变更</button>
                        </div>
                        <div class="btn-group" role="group">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
