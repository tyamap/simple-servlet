package com.tyamap.simple_servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
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
            BufferedReader reader = request.getReader();
            String body = reader.readLine();
            System.out.println(body);

            // TODO: jsonをうまいこと処理して入力内容通りのEventを生成
            // 多分Jacksonでやるのがいい

            Employee host = (Employee) entityManager.createQuery("from Employee e where e.id = " + 1).getResultList().get(0);
            System.out.println(host.getName());
            host.addEvent(new Event("title", new Date()));

            entityManager.getTransaction().begin();

            // TODO: persist？ Update的な処理をしたい。
            entityManager.persist( host );
            entityManager.flush();

            entityManager.getTransaction().commit();
            entityManager.close();

            System.out.println("Done");

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "http://localhost");
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "content-type");
            out.print("OK:{}");
            out.flush();
        } catch (Exception e) {
           // 接続・SQL文エラー
            System.out.println(e.toString());
        }
    }
}