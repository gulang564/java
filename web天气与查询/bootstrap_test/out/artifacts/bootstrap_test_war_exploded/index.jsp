<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/10/16 0016
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>$Title$</title>
    <script src="./utils/jquery-1.12.4.min.js"></script>
    <script src="./utils/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./utils/css/bootstrap.min.css">

  </head>
  <body>
  <div class="container">
    <div class="container">
      <div class="row">
        <div class="col-md-8" style="margin-top:30px"><p class="text-success show lead">...</p></div>
        <div class="col-md-4"><img src="./images/101.png" id="imgs"></div>

      </div>
    </div>

    <div class="container">

      <table class="table table-bordered">
        <tr class="active">
          <td>温度</td>
          <td>气压</td>
          <td>能见度</td>
        </tr>
        <tr class="top_one">
          <%--<td>温度--</td>
          <td>气压--</td>
          <td>能见度--</td>--%>
        </tr>

        <tr class="active">
          <td>风向</td>
          <td>风速</td>
          <td>风力</td>
        </tr>
        <tr class="top_two">
         <%-- <td>风向--</td>
          <td>风速--</td>
          <td>风力--</td>--%>
        </tr>
      </table>
    </div>

<div class="container">
  <form class="form-inline">
    <label class="sr-only" >选择省份和市区</label>
    <div class="form-group">

      <select class="form-control province">

      </select>
    </div>


    <div class="form-group">

      <select class="form-control city">

      </select>
    </div>
    <%--在浏览器中，如果button不写type  ie里面默认是button ，其他浏览器默认是 sumbit--%>
    <button type="button"  class="btn btn-default submit_btn">Sign in</button>
  </form>
</div>


  </div>
  </body>
</html>
<script>
  $(function () {
     function getInfo(city) {
        /* console.log(city);
         console.log(city!=null?city:"北京");*/
         $.ajax({
             url:'https://free-api.heweather.net/s6/weather/now?',
             data:{
                 location: city!=null?city:"北京",
                 key: 'f6eca8622f624c218571d6604cdddf4f'
             },
             success:function (result) {
                 console.log(result);
                 console.log(result.HeWeather6[0].now.cloud);
                 /*
                 * <tr class="top_one">
                    <td>tmp--</td>
                    <td>pres--</td>
                    <td>vis--</td>
                   </tr>

                   <tr class="top_two">
                    <td>wind_dir--</td>
                    <td>wind_spd--</td>
                    <td>wind_sc--</td>
                    </tr>
                 * */

                 $(".top_one").empty();
                 $(".top_two").empty();

                 $(".top_one").append("<td>"+result.HeWeather6[0].now.tmp+"摄氏度"+"</td>")
                     .append("<td>"+result.HeWeather6[0].now.pres+"大气压强"+"</td>")
                     .append("<td>"+result.HeWeather6[0].now.vis+"公里"+"</td>");

                 $(".top_two").append("<td>"+result.HeWeather6[0].now.wind_dir+"</td>")
                     .append("<td>"+result.HeWeather6[0].now.wind_spd+"公里/小时"+"</td>")
                     .append("<td>"+result.HeWeather6[0].now.wind_sc+"级"+"</td>");

                 $("#imgs").attr("src","./images/"+result.HeWeather6[0].now.cond_code+".png");
                 $(".show").text($(".province").val()+"省"+$(".city").val()+"市的天气")
                 return false;
             }
         })
     }

     function Get_province(){
         $.ajax({

             url:"/GetInfo_province",
             type:"get",
             success: function (res) {
                 /* var res= eval('(' + res + ')');*/
                 $(".province").empty();
                 res = eval('(' + res + ')');

                 for(var i in res){
                     $(".province").append($("<option>"+res[i]+"</option>"))
                 }
             }

         })
     }

     function Get_city(city){
         $.ajax({
             /* url: 'https://free-api.heweather.net/s6/weather/now?',
              data: {
                  location: that.data.regin[1],
                  key: 'f6eca8622f624c218571d6604cdddf4f'
              },*/
             url:"/GetInfo_city",
             type:"get",
             data:"province="+(city!=null?city:"北京"),
             success: function (res) {
                 xqo = eval('(' + res + ')');
                 // ;
                 $(".city").empty();
                 for(var i in xqo){
                     $(".city").append($("<option>"+xqo[i].city_CN+"</option>"))
                 }
             }

         })
     }

      Get_province();
     Get_city();
     getInfo(null);

      $(".province").change(function () {
          var IsOpened = $('.province option:selected').val();
          Get_city(IsOpened);
      });

      $(".submit_btn").click(function () {
          /* url: 'https://free-api.heweather.net/s6/weather/now?',
             data: {
                 location: that.data.regin[1],
                 key: 'f6eca8622f624c218571d6604cdddf4f'
             },*/
          //console.log($(".city").val());
         var city= $(".city").val()
        getInfo(city);
      })

  })

</script>