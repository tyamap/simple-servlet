package com.tyamap.simple_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tyamap.simple_servlet.util.HibernateUtil;

@WebServlet("/test-hibernate.json")
public class TestHibernate extends HttpServlet {

    // Exposeアノテーションがついていないものは除外する
    private Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        EventManager mgr = new EventManager();

        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List events = session.createQuery("from Event").list();
            session.getTransaction().commit();
            String jsonEvents = this.gson.toJson(events);

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