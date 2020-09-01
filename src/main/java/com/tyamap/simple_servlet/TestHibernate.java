package com.tyamap.simple_servlet;

import java.io.*;
import java.sql.*;
import java.util.*;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.*;

import org.hibernate.Session;

import com.tyamap.simple_servlet.domain.Event;
import com.tyamap.simple_servlet.util.HibernateUtil;

@WebServlet("/test-hibernate")
public class TestHibernate extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        EventManager mgr = new EventManager();

        try{
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            List events = session.createQuery("from Event").list();
            session.getTransaction().commit();
            for (int i = 0; i < events.size(); i++) {
                Event theEvent = (Event) events.get(i);
                out.println("Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate());
            }
        } catch (Exception e) {
            // 接続・SQL文エラー
            e.printStackTrace(out);
        }
    }
}