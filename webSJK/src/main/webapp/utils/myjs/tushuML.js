$(function () {
    $("#fileUpload").change(function () {
        var  fileObj = this.files[0];
        // 生成一个文件读取的内置对象
        var fileReader = new FileReader();
        // 将文件对象传递给内置对象
        fileReader.readAsDataURL(fileObj); //这是一个异步执行的过程，所以需要onload回调函数执行读取数据后的操作
        // 将读取出文件对象替换到img标签
        fileReader.onload = function(){  // 等待文件阅读器读取完毕再渲染图片
            $('#img').attr('src',fileReader.result)
        }
    })

    $("#add").click(function () {
        var language= $("#language").val();
        console.log(language);

        var Leibie=$("#Leibie").val();
        console.log(Leibie);

        var jianjie=$("#jianjie").val();
        console.log(jianjie);
        $("#bkBrief").val(jianjie);


        $("#bkLanguage").val(language);
        $("#bkLeibie").val(Leibie);

        alert("提交完成返回当前页面，可再次提交，点击确定即可");
        $("#bookInfo").submit();
    })


    $("#change").click(function () {
        var language= $("#language").val();
        console.log(language);

        var Leibie=$("#Leibie").val();
        console.log(Leibie);

        var jianjie=$("#jianjie").val();
        console.log(jianjie);
        $("#bkBrief").val(jianjie);


        $("#bkLanguage").val(language);
        $("#bkLeibie").val(Leibie);
        alert("修改完成返回当前页，点击确定即可修改");
        $("#bookInfo").attr("action","updateBookInfo")
        $("#bookInfo").submit();

    })

    $("#quxiao").click(function () {
      $("#bkID").val("");
        $("#bkCode").val("");
        $("#bkName").val("");
        $("#bkAuthor").val("");
        $("#bkPress").val("");
        $("#bkDatePress").val("");
        $("#bkLeibie").val("");
        $("#bkLanguage").val("");
        $("#bkPages").val("");
        $("#bkNum").val("");
        $("#bkStatus").val("");
        $("#jianjie").val("");
        $("#fileUpload").val("");
        $("#hidden").val("");

    })

})