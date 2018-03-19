/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.Managers;

import algobreizh.Database.DatabaseConnection;
import algobreizh.Models.City;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author paul
 */
public class CitiesManager {
    
    public static City get(int idCity){
        String querry = "SELECT * FROM tCities WHERE id = " + idCity;
        City city = new City();
        ResultSet res = DatabaseConnection.execute(querry);
        if (res != null) {
            try {
                while (res.next()) {
                    String name = res.getString("name");
                    int id_tSalesman = res.getInt("id_tSalesman");
                    city = new City(idCity, name, SalesmansManager.get(id_tSalesman));
                }
            } catch (SQLException e) {

            }
        }
        return city;
    }
        
}
