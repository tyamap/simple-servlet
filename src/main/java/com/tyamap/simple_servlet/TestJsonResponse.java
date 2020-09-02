package com.tyamap.simple_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.tyamap.simple_servlet.domain.Employee;

@WebServlet(name = "TestJsonResponse", urlPatterns = "/test-json-response.json")
public class TestJsonResponse extends HttpServlet {

    private Gson gson = new Gson();

    @Override
    protected void doGet(
      HttpServletRequest request,
      HttpServletResponse response) throws IOException {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Karan", "IT", 5000));
        employees.add(new Employee(2, "Tommy", "IT", 3000));
        employees.add(new Employee(3, "Jackson", "HR", 4000));
        String employeeJsonString = this.gson.toJson(employees);

        PrintWriter out = response.getWriter();
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(employeeJsonString);
        out.flush();
    }
}