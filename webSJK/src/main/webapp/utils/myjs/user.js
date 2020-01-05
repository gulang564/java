$(function(){

    var recordUser=null;

    $("#querenChange").attr("disabled",true);

    $("#findUser").click(function () {
        $("#rdPhoto").attr("src","");
        $("#biangeng").attr("disabled",true);

        var tr=$("#findOut");
        tr.empty();

        $("#rdId").val("");
        $("#rdBorrowQty").val("");
        $("#rdDateReg").val("");

        $("#rdEmail").val("");
        $("#rdPhone").val("");
        $("#rdName").val("");
        $("#rdStatus").val("");
        $("#rdPwd").val("");


        var userType= $("#UserType option:selected").text();
        console.log(userType);

        var danwei=$("#danwei option:selected").text();
        console.log(danwei);

        var username=$("#username").val();
        console.log(username);

        $.ajax({
            url:"/getUserMessage",
            data:"userType="+userType+"&&"+"danwei="+danwei+"&&"+"username="+username,
            method:"get",
            dataType:"json",
            success:function (rs){
                /*判断返回值类型的一种方法 */
                console.log(rs);
                if (rs.rdID!=0)
                {
                    console.log("1");
                    $("#banlijieshuzheng").attr("disabled",true);
                    $("#querenbanzheng").attr("disabled",true);
                    $("#querenChange").attr("disabled",false);

                    recordUser=rs.rdID;

                    tr.append("<td>"+rs.rdID+"</td>");
                    tr.append("<td>"+rs.rdName+"</td>");
                    tr.append("<td>"+rs.rdSex+"</td>");
                    tr.append("<td>"+userType+"</td>");
                    tr.append("<td>"+rs.rdDept+"</td>");
                    tr.append("<td>"+rs.rdPhone+"</td>");
                    tr.append("<td>"+rs.rdEmail+"</td>");
                    tr.append("<td>"+rs.rdStatus+"</td>");
                    tr.append("<td>"+rs.rdBorrowQty+"</td>");
                    tr.append("<td>"+rs.rdDateReg+"</td>");

                    $("#rdId").val(rs.rdID);
                    $("#rdBorrowQty").val(rs.rdBorrowQty);
                    $("#rdDateReg").val(rs.rdDateReg);

                    $("#rdEmail").val(rs.rdEmail);
                    $("#rdPhone").val(rs.rdPhone);
                    $("#rdName").val(rs.rdName);

                    /* $("#rdSex option[value="+rs.rdSex+"]");*/
                    /*select 框可以看成是一个input，设置值是，只要里面的option有对应的内容，就会被选中，
                    * 获取值是，获取当前被选中的option的值
                    * */
                    $("#rdSex").val(rs.rdSex)

                    $("#leibie").val(userType);
                    $("#rdDept").val(rs.rdDept);

                    $("#rdStatus").val(rs.rdStatus);
                    $("#rdPwd").val(rs.rdPwd);
                    $("#biangeng").attr("disabled",false);

                    console.log(rs.rdPhoto);
                    $("#rdPhoto").attr("src",rs.rdPhoto);

                } else
                {
                    alert("用户不存在，请先注册");
                    console.log("2");
                    $("#banlijieshuzheng").attr("disabled",false);
                    $("#querenbanzheng").attr("disabled",false);
                    $("#querenChange").attr("disabled",true)
                }
            }
        })
    })

    /*图片的实时显示*/
    $("#fileUpload").change(function () {
        var  fileObj = this.files[0];
        // 生成一个文件读取的内置对象
        var fileReader = new FileReader();
        // 将文件对象传递给内置对象
        fileReader.readAsDataURL(fileObj); //这是一个异步执行的过程，所以需要onload回调函数执行读取数据后的操作
        // 将读取出文件对象替换到img标签
        fileReader.onload = function(){  // 等待文件阅读器读取完毕再渲染图片
            $('#rdPhoto').attr('src',fileReader.result)
        }
    })

    /*当点击是直接获取时间*/
    $("#rdDateReg").focus(function () {

        $(this).val("");
        var myDate = new Date();

        var year=myDate.getFullYear();        //获取当前年
        var month=myDate.getMonth()+1;   //获取当前月
        var date=myDate.getDate();            //获取当前日

        var h=myDate.getHours();              //获取当前小时数(0-23)
        var m=myDate.getMinutes();          //获取当前分钟数(0-59)
        var s=myDate.getSeconds();

        var now=year+'-'+month+"-"+(date)+" "+(h)+':'+(m)+":"+(s);
        $(this).val(now);

    })
    

    $("#querenbanzheng").click(function () {
        /*规定什么都可以变，就是图书证不能变，如果所有的都写好太麻烦细节太多*/

      var rdSex=$("#rdSex").val()
      var leibie=$("#leibie").val();
      var rdDept= $("#rdDept").val();

      $("#hidesex").val(rdSex);
      $("#hideleibie").val(leibie);
      $("#hideDept").val(rdDept);

      $("#userForm").submit();
    })


    $("#querenChange").click(function () {

        var rdSex=$("#rdSex").val()

        var leibie=$("#leibie").val();
        var rdDept= $("#rdDept").val();

        $("#hidesex").val(rdSex);
        $("#hideleibie").val(leibie);
        $("#hideDept").val(rdDept);

        $("#userForm").attr("action","/updateUserInfo")
        $("#userForm").submit();

    })

    $("#guashi").click(function () {
        $.ajax({
            url:"/updateReaderStatusByID",
            data:{
                status:"挂失",
                readerID:recordUser
            },
            method:"get",
            dataType:"json",
            success:function (rs) {
                console.log(rs);
            }
        })

        $("#jiechuguashi").click(function () {
            $.ajax({
                url:"/updateReaderStatusByID",
                data:{
                    status:"激活",
                    readerID:recordUser
                },
                method:"get",
                dataType:"json",
                success:function (rs) {
                    console.log(rs);
                }
            })

            $("#zhuxiao").click(function () {

                $.ajax({
                    url:"/deleteReader",
                    data:{
                        readerID:recordUser
                    },
                    method:"get",
                    dataType:"json",
                    success:function (rs) {
                        console.log(rs);
                    }
                })
            })
            })

    })

})