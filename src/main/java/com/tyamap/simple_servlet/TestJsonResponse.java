package com.tyamap.simple_servlet;

import com.tyamap.simple_servlet.domain.Employee;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet(name = "TestJsonResponse", urlPatterns = "/test-json-response")
public class TestJsonResponse extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {

        Employee employee = new Employee(1, "Karan", "IT", 5000);
        String employeeJsonString = this.gson.toJson(employee);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }
}