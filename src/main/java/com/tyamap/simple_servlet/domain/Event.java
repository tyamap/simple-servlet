package com.tyamap.simple_servlet.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "test_events")
public class Event {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "event_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "employee_id",
    			foreignKey = @ForeignKey(name = "EMPLOYEE_ID_FK")
    )
	private Employee employee;

    public Event() {
        // 引数なしコンストラクタはHibernate側で利用
    }

    public Event(String title, Date date) {
        // アプリケーション側で使用
        this.title = title;
        this.date = date;
    }

	public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}