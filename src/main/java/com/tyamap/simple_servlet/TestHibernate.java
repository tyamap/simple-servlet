package com.tyamap.simple_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tyamap.simple_servlet.domain.Event;

@WebServlet("/test-hibernate.json")
public class TestHibernate extends HttpServlet {

    // Exposeアノテーションがついていないものは除外する
    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    private EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory( "com.tyamap.simple_servlet.jpa" );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            String jsonEvents = this.gson.toJson(result);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(jsonEvents);
            out.flush();
        } catch (Exception e) {
            // 接続・SQL文エラー
            e.printStackTrace(out);
        }
    }
}