package mypackage;

import java.io.*;
import java.sql.*;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.*;

public class Test  extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        try{

            // コネクション取得
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/test_db");
            Connection con = ds.getConnection();

            // SQL文送信
            PreparedStatement st = con.prepareStatement("select * from test_table");
            // 実行＆結果受け取り
            ResultSet rs = st.executeQuery();

            // データの表示
            while (rs.next()) {
                out.println(
                    rs.getInt("id")      + ":" + 
                    rs.getString("name")
                );
            }

            // データベース切断
            st.close();
            con.close();

        } catch (Exception e) {
            // 接続・SQL文エラー
            e.printStackTrace(out);

        }
    }

}