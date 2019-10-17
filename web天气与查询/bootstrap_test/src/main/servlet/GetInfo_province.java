package main.servlet;

import main.java.dao.Get_connection;
import main.java.domain.Weather;
import net.sf.json.JSONArray;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(value = "/GetInfo_province")
public class GetInfo_province extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {


            Connection connection=  Get_connection.getDataSource().getConnection();
            String sql="select distinct Province_CN from chinacity;";
            List list=new LinkedList();

            ResultSet rs= connection.createStatement().executeQuery(sql);

            while (rs.next()){
               list.add(rs.getString("Province_CN"));
            }

            System.out.println(list);

            JSONArray js = JSONArray.fromObject(list);

            // System.out.println(js.toString());
            System.out.println(js);
            response.getWriter().print(js);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
