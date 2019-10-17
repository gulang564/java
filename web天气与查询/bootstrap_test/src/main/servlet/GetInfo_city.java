package main.servlet;

import main.java.dao.Get_connection;
import main.java.domain.Weather;
import net.sf.json.JSONArray;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@WebServlet(value = "/GetInfo_city")
public class GetInfo_city extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");

            QueryRunner runner=new QueryRunner(Get_connection.getDataSource());
            String province= request.getParameter("province");
            System.out.println("province is "+ province);
            String sql="select*from chinaCity where Province_CN=?";

            List list=  runner.query(sql,new BeanListHandler<>(Weather.class), province);
            System.out.println("list----size----------"+list.size());

           /* for (int i = 0; i <list.size() ; i++) {
                System.out.println(list.get(i));
            }
            request.setAttribute("list",list);*/
            JSONArray js = JSONArray.fromObject(list);

           // System.out.println(js.toString());
            response.getWriter().print(js);

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
}
