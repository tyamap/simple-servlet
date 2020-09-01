package com.tyamap.simple_servlet;

import org.hibernate.Session;

import java.util.*;

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

}