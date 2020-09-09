package com.tyamap.simple_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyamap.simple_servlet.domain.Employee;
import com.tyamap.simple_servlet.domain.Event;

public class NewEvents extends HttpServlet {

    private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("com.tyamap.simple_servlet.jpa");

    // preflightリクエストに正しくレスポンスを返す
    @Override
    protected void doOptions(HttpServletRequest request, HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "http://localhost");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "content-type");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            // // getParameter()の前にgetReaderなどで直接読み取ると、getParameterに失敗する。
            // BufferedReader reader = request.getReader();
            // String body = reader.readLine();
            // System.out.println(body);

            String p_title = request.getParameter("title");
            String p_strDate = request.getParameter("date");
            String p_hostId = request.getParameter("host_id");

            // 日付文字列をDate型に変換
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date p_date = sdFormat.parse(p_strDate);

            // 主催者Employeeを検索
            Employee host = (Employee) entityManager
                .createQuery("from Employee e where e.id = " + p_hostId)
                .getResultList()
                .get(0);

            host.addEvent(new Event(p_title, p_date));

            entityManager.getTransaction().begin();

            // TODO: persist？ Update的な処理をしたい。
            entityManager.persist( host );
            entityManager.flush();

            entityManager.getTransaction().commit();
            entityManager.close();

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "http://localhost");
            out.print("OK:{}");
            out.flush();
        } catch (Exception e) {
           // 接続・SQL文エラー
            System.out.println(e.toString());
        }
    }
}