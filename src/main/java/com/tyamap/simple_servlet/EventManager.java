package com.tyamap.simple_servlet;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import com.tyamap.simple_servlet.domain.Employee;
import com.tyamap.simple_servlet.domain.Event;
import com.tyamap.simple_servlet.util.HibernateUtil;

public class EventManager {

    public static void main(String[] args) {
        EventManager mgr = new EventManager();

        // mvn exec:java -Dexec.mainClass="com.tyamap.simple_servlet.EventManager" -Dexec.args="store"
        if (args[0].equals("store")) {
            mgr.createAndStoreEvent("My Event", new Date());
        }
        // mvn exec:java -Dexec.mainClass="com.tyamap.simple_servlet.EventManager" -Dexec.args="list"
        else if (args[0].equals("list")) {
            List events = mgr.listEvents();
            for (int i = 0; i < events.size(); i++) {
                Event theEvent = (Event) events.get(i);
                System.out.println("Event: " + theEvent.getTitle() + " Time: " + theEvent.getDate());
            }
        }
        // mvn exec:java -Dexec.mainClass="com.tyamap.simple_servlet.EventManager" -Dexec.args="emp"
        else if (args[0].equals("emp")) {
            List employees = mgr.listEmployee();
            for (int i = 0; i < employees.size(); i++) {
                Employee emp = (Employee) employees.get(i);
                System.out.println("Name: " + emp.getName() + " Events: " + emp.getEvents().size());
            }
        }

        HibernateUtil.getSessionFactory().close();
    }

    private void createAndStoreEvent(String title, Date theDate) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        session.save(theEvent);

        session.getTransaction().commit();
    }

    private List listEvents() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Event").list();
        session.getTransaction().commit();
        return result;
    }

    private List listEmployee() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List result = session.createQuery("from Employee").list();
        session.getTransaction().commit();
        return result;
    }

}