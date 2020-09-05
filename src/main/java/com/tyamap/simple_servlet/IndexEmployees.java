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
import com.tyamap.simple_servlet.domain.Employee;

@WebServlet(name = "employees", urlPatterns = { "/employees.json" })
public class IndexEmployees extends HttpServlet {

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
            List<Employee> result = entityManager.createQuery( "from Employee", Employee.class ).getResultList();
            entityManager.getTransaction().commit();
            entityManager.close();
            String jsonEmployees = this.gson.toJson(result);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.print(jsonEmployees);
            out.flush();
        } catch (Exception e) {
            // 接続・SQL文エラー
            e.printStackTrace(out);
        }
    }
}