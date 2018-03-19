/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.Models;

import java.sql.Date;
import java.sql.Time;
import algobreizh.Managers.MeetingsManager;

/**
 *
 * @author paul
 */

public class Salesman {
    
    int id;
    String firstname;
    String lastname;
    
    public Salesman(int _id, String _firstname, String _lastname){
        this.id = _id;
        this.firstname = _firstname;
        this.lastname = _lastname;
    }
    
    public Salesman(int _id){
        this.id = _id;
    }
    
    public Salesman(){
        
    }
        
    public void addMeeting(Customer _customer, Date meetingDate, Time meetingHour, String infos){
        Meeting m = new Meeting(this, _customer, meetingDate, meetingHour, infos);
        MeetingsManager.add(m);
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    
}
