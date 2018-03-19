/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.Managers;

import algobreizh.Database.DatabaseConnection;
import algobreizh.Models.Salesman;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author paul
 */
public class SalesmansManager {
    
    public static Salesman get(int idSalesman){
        String querry = "SELECT * FROM tSalesman WHERE id = " + idSalesman;
        Salesman salesman = new Salesman();
        ResultSet res = DatabaseConnection.execute(querry);
        if (res != null) {
            try {
		while (res.next()) {
                    String lastname = res.getString("lastname");
                    String firstname = res.getString("firstname");
                    salesman = new Salesman(idSalesman,firstname,lastname);
		}
            } catch (SQLException e) {
            }
        }
        return salesman;
    }
    
    public void set(Salesman s){
        String querry = "INSERT INTO tSalesman VALUES ("
                + "\'" + s.getFirstname() 
                + "\',\'" + s.getLastname()
                + "\')";
    }
    
}
