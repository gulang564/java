$(function () {
    /*$("#findBorrower").click(function () {
        $.ajax({
            type: "get",
            url: "/getReaderType",
            data: "",
            dataType: "json",
            success: function (rs){
                console.log(rs);
            }
        })
    })*/

    $("#findBorrower").click(function () {
        var rname= $("#rName");
        var danwei =$("#danwei");
        var leibie= $("#leibie");
        var shuliang= $("#shuliang");
        var kejietianshu= $("#kejietianshu");
        var yijieshuliang= $("#yijieshuliang");

        $.ajax({
            type: "get",
            url: "/findManyInfo",
            data: "jieyuehao="+$("#lendBookId").val(),
            dataType: "json",
            success: function (rs){
                $("#fanjingTable").empty();
                $("#fanjingTable").append($(" <tr>\n" +
                    "                    <td>图书ID</td>\n" +
                    "                    <td>图书名称</td>\n" +
                    "                    <td>图书作者 </td>\n" +
                    "                    <td>续借次数</td>\n" +
                    "                    <td>借阅日期</td>\n" +
                    "                    <td>应还日期</td>\n" +
                    "                    <td>超期天数</td>\n" +
                    "                    <td>超期金额</td>\n" +
                    "                </tr>"))



                console.log("我也是醉了 ");

                console.log(rs);

                rname.append($("<label >"+rs.name+"</label>"));
                danwei.append($("<label >"+rs.dept+"</label>"));
                leibie.append($("<label >"+rs.leibie+"</label>"));
                shuliang.append($("<label >"+rs.CanLendbookNum+"</label>"));
                kejietianshu.append($("<label >"+rs.lendDay+"</label>"));
                yijieshuliang.append($("<label >"+rs.hasLendBookNum+"</label>"));


                console.log(rs.zonghe);

                for (var i = 0; i < rs.zonghe.length; i++) {
                    console.log("进入table");
                    var latertr=$("<tr>\n" +
                        "                    <td>"+rs.zonghe[i].bookID+"</td>\n" +
                        "                    <td>"+rs.zonghe[i].bookName+"</td>\n" +
                        "                    <td>"+rs.zonghe[i].bookAuth+" </td>\n" +
                        "                    <td>"+rs.zonghe[i].xujiecishu+"</td>\n" +
                        "                    <td>"+rs.zonghe[i].jieyueriqi+"</td>\n" +
                        "                    <td>"+rs.zonghe[i].yinghuanriqi.slice(0,10)+"</td>\n" +
                        "                    <td>"+rs.zonghe[i].chaoqitianshu+"</td>\n" +
                        "                    <td>"+rs.zonghe[i].chaoqijinge+"</td>\n" +
                        "                </tr>");

                    $("#fanjingTable").append(latertr);

                }
            }
        })
    })

    $("#bookInfo").on("click","button",function (event) {
      var code=  $(event.target).attr("id");
        $("#tushuhao").val(code);
    });

    $("#jieyueriqi").focus(function () {
        $(this).val("");
        var myDate = new Date();

        var year=myDate.getFullYear();        //获取当前年
        var month=myDate.getMonth()+1;   //获取当前月
        var date=myDate.getDate();            //获取当前日

        var now=year+'-'+month+"-"+(date);
        $(this).val(now);
    })


    $("#submit").click(function () {
        $.ajax({
            url:"/submitBorrowInfo",
            method:"get",
            data:{
                jieyuehao:$("#jieyuehao").val(),
                tushuhao:$("#tushuhao").val(),
                jieyueriqi:$("#jieyueriqi").val()
            },
            dataType:"json",
            success:function (rs) {
                console.log(rs.success);
                $('#myModal').modal('hide');
                alert("借阅成功");
            }

            })


        })




    $("#tushumingcheng").click(function () {
        var info=$("#Info").val();
        $.ajax({
            url:"/findBook",
            data:"field=书名"+"&&"+"Info="+info,
            method:"get",
            dataType:"json",
            success:function (rs) {
                console.log(rs);
                var table=$("#bookInfo");
                table.empty();
                var first=$(" <tr>\n" +
                    "                <td>图书封面</td>\n" +
                    "                <td>ID</td>\n" +
                    "                <td>索书号 </td>\n" +
                    "                <td>书名</td>\n" +
                    "                <td>作者</td>\n" +
                    "                <td>出版社</td>\n" +
                    "                <td>出版日期</td>\n" +
                    "                <td>类别</td>\n" +
                    "                <td>语种</td>\n" +
                    "                <td>页数</td>\n" +
                    "                <td>入馆时间</td>\n" +
                    "                <td>状态</td>\n" +
                    "                <td>\n" +
                    "                    <lable>借阅</lable>\n" +
                    "                </td>\n" +
                    "            </tr>");

                table.append(first);



                for (var i = 0; i < rs.length ; i++) {
                    var tr=$(" <tr>\n" +
                        " <td><img src="+rs[i].bkCover+" style=\"width: 80px;height: 100px;\"></td>\n" +
                        " <td>"+rs[i].bkID+"</td>\n" +
                        "     <td>"+rs[i].bkCode+"</td>\n" +
                        "     <td>"+rs[i].bkName+"</td>\n" +
                        "     <td>"+rs[i].bkAuthor+"</td>\n" +
                        "     <td>"+rs[i].bkPress+"</td>\n" +
                        "     <td>"+rs[i].bkDatePress+"</td>\n" +
                        "     <td>"+rs[i].bkLeibie+"</td>\n" +
                        "     <td>"+rs[i].bkLanguage+"</td>\n" +
                        "     <td>"+rs[i].bkPages+"</td>\n" +
                        "     <td>"+rs[i].bkDateIn+"</td>\n" +
                        "     <td>"+rs[i].bkStatus+"</td>\n" +
                       " <td>\n" +
                        "                    <button type=\"button\" class=\"btn\" id="+rs[i].bkID+" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
                        "                        借阅\n" +
                        "                    </button>\n" +
                        "                </td>"+
                        " </tr>");

                    first.after(tr);
                }
            }
        })


    })

})