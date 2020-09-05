package com.tyamap.simple_servlet;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.tyamap.simple_servlet.domain.Employee;
import com.tyamap.simple_servlet.domain.Event;

public class EventManager {
	private static EntityManagerFactory entityManagerFactory;

    public static void main(String[] args) {
        entityManagerFactory = Persistence.createEntityManagerFactory( "com.tyamap.simple_servlet.jpa" );
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        // mvn exec:java -Dexec.mainClass="com.tyamap.simple_servlet.EventManager" -Dexec.args="store"
        if (args[0].equals("store")) {
            Employee emp = new Employee("Ken", "HQ", 10000);
            Event eve1 = new Event( "first event", new Date() );
            Event eve2 = new Event( "follow up", new Date() );

            emp.addEvent( eve1 );
            emp.addEvent( eve2 );
            entityManager.persist( emp );
            entityManager.flush();

            emp.removeEvent( eve1 );
        }
        // mvn exec:java -Dexec.mainClass="com.tyamap.simple_servlet.EventManager" -Dexec.args="list"
        else if (args[0].equals("list")) {
            List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();
            for ( Event event : result ) {
                System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
            }
        }
        // mvn exec:java -Dexec.mainClass="com.tyamap.simple_servlet.EventManager" -Dexec.args="emp"
        // TODO: n+1問題
        else if (args[0].equals("emp")) {
            List<Employee> result = entityManager.createQuery( "from Employee", Employee.class ).getResultList();
            for ( Employee emp : result ) {
                System.out.println("Name: " + emp.getName() + " Events: " + emp.getEvents().size());
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}