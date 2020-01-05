$(function () {
   $("#submit").click(function () {
       var text = $("#jiashuoziduan").find("option:selected").val();
       var info=$("#Info").val();
       $.ajax({
           url:"/findBook",
           data:"field="+text+"&&"+"Info="+info,
           method:"get",
           dataType:"json",
           success:function (rs) {
               console.log(rs);
               var table=$("#table");
               table.empty();
               var first=$(" <tr>\n" +
                   "        <td>图书封面</td>\n" +
                   "        <td>ID</td>\n" +
                   "        <td>索书号</td>\n" +
                   "        <td>书名</td>\n" +
                   "        <td>作者</td>\n" +
                   "        <td>出版社</td>\n" +
                   "        <td>出版日期</td>\n" +
                   "        <td>类别</td>\n" +
                   "        <td>语种</td>\n" +
                   "        <td>页数</td>\n" +
                   "        <td>入馆时间</td>\n" +
                   "        <td>状态</td>\n" +
                   "  </tr>");

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
                   " </tr>");

                   first.after(tr);
               }
           }
       })

   })


$("#submitSelects").click(function () {
    var table=$("#selectsTable");
    table.empty();

    table.append($(" <tr>\n" +
        "        <td>图书封面</td>\n" +
        "        <td>ID</td>\n" +
        "        <td>索书号</td>\n" +
        "        <td>书名</td>\n" +
        "        <td>作者</td>\n" +
        "        <td>出版社</td>\n" +
        "        <td>出版日期</td>\n" +
        "        <td>类别</td>\n" +
        "        <td>语种</td>\n" +
        "        <td>页数</td>\n" +
        "        <td>入馆时间</td>\n" +
        "        <td>状态</td>\n" +
        "  </tr>"));

    $.ajax({
        url:"/findBookBySelects",
        data:"bookName="+$("#bookName").val()+"&&"+"AuthorName="+$("#AuthorName").val()+"&&"+"bookBrief="+$("#bookBrief").val()+"&&"
        +"PressName="+$("#PressName").val()+"&&"+"sort="+$("#sort").val()+"&&"+"PressDate="+$("#PressDate").val(),
        method:"get",
        dataType:"json",
        success:function (rs) {

            console.log(rs);
            for (var i = 0; i <rs.length ; i++) {
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
                    " </tr>");
                table.append(tr);
            }
        }
    })
})

})