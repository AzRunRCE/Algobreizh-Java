/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.Models;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author paul
 */
public class Meeting {
    
    private int id;
    private Salesman Salesman;
    private Customer Customer;
    private Date date;
    private Time hour;
    private String infos;
    
    // Constructor with id
    public Meeting (int _id, Salesman _salesman, Customer _customer, Date _date, Time _hour, String _infos){
        this.id = _id;
        this.Salesman = _salesman;
        this.Customer = _customer;
        this.date = _date;
        this.hour = _hour;
        this.infos = _infos;
    }
    // Same without id
    public Meeting (Salesman _salesman, Customer _customer, Date _date, Time _hour, String _infos){
        this.Salesman = _salesman;
        this.Customer = _customer;
        this.date = _date;
        this.hour = _hour;
        this.infos = _infos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Salesman getSalesman() {
        return Salesman;
    }

    public void setSalesman(Salesman Salesman) {
        this.Salesman = Salesman;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public String getInfos() {
        return infos;
    }

    public void setInfos(String infos) {
        this.infos = infos;
    }
    
}
