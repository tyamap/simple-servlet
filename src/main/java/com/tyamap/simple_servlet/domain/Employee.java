package com.tyamap.simple_servlet.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "test_employees")
public class Employee {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Expose
    private int id;

    @Expose
    private String name;

    private String department;

    private long salary;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Event> events = new ArrayList<>();

	public Employee() {}

    public Employee(String name, String department, long salary) {
    	super();
    	this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(int id, String name, String department, long salary) {
        super();
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

	public void addEvent(Event event) {
		events.add( event );
		event.setEmployee( this );
	}

	public void removeEvent(Event event) {
		events.remove( event );
		event.setEmployee( null );
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
}