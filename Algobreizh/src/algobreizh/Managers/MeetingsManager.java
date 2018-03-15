/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.Managers;

import algobreizh.Models.Meeting;
import algobreizh.Database.DatabaseConnection;
import algobreizh.Models.Customer;
import algobreizh.Models.Salesman;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class MeetingsManager{
    
    public SalesmansManager salesmansManager;
    public CustomersManager customersManager;
    
    // Ajoute un rendez-vous
    public void add(Meeting m){
        String querry = "INSERT INTO tMeetings VALUES (\'" + m.getSalesman().getId()
                + "\',\'" + m.getCustomer().getId()
                + "\',\'" + m.getDate()
                + "\',\'" + m.getHour()
                + "\',\'" + m.getInfos() 
                + "\')";
        DatabaseConnection.execute(querry);
    }
    
    // Supprime le rendez-vous précisé
    public void delete(Meeting m){
        String querry = "DELETE * FROM tMeetings WHERE id = " + m.getId();
        DatabaseConnection.execute(querry);
    }
    
    // Retourne les rendez-vous d'un commercial précis
    public ArrayList<Meeting> getAll(Salesman s){
        ArrayList<Meeting> meetings = new ArrayList<>();
        String querry = "SELECT * FROM tMeetings WHERE id_seller = " + s.getId();
        ResultSet res = DatabaseConnection.execute(querry);
        if (res != null) {
            try {
		while (res.next()) {
                    int id = res.getInt("id");
                    Date date = res.getDate("date");
                    Time hour = res.getTime("hour");
                    int idCustomer = res.getInt("id_tCustomer");
                    int idSalesman = res.getInt("id_tSalesman");
                    Customer customer = customersManager.get(idCustomer);
                    Salesman salesman = salesmansManager.get(idSalesman);
                    String info = res.getString("info");
                    meetings.add(new Meeting(id, salesman, customer, date, hour, info));
		}
            } catch (SQLException e) {
            }
        }
        return meetings;
    }
    
}
