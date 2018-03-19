/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.Managers;

import algobreizh.Database.DatabaseConnection;
import algobreizh.Models.City;
import algobreizh.Models.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class CustomersManager {    
    
    // Retourne l'objet Customer lié à l'id donné (en bdd)
    public static Customer get(int id){
        String querry = "SELECT * FROM tCustomers WHERE id = " + id;
        Customer customer = new Customer();
        City city;
        ResultSet res = DatabaseConnection.execute(querry);
        if (res != null) {
            try {
		while (res.next()) {
                    String lastname = res.getString("lastname");
                    String firstname = res.getString("firstname");
                    String email = res.getString("email");
                    int id_tCities = res.getInt("id_tCities");
                    city = new City(id_tCities);
                    customer = new Customer(id, firstname, lastname, email, city);
		}
            } catch (SQLException e) {
            }
        }
        return customer;
    }
    
    // Retourne la liste de tous les client en bdd
    public ArrayList<Customer> getAll(){
        ArrayList<Customer> customers = new ArrayList<>();
        String querry = "SELECT * FROM tCustomers";
        City city;
        ResultSet res = DatabaseConnection.execute(querry);
        if (res != null) {
            try {
		while (res.next()) {
                    int id = res.getInt("id");
                    String lastname = res.getString("lastname");
                    String firstname = res.getString("firstname");
                    String email = res.getString("email");
                    int id_tCities = res.getInt("id_tCities");
                    city = new City(id_tCities);
                    customers.add(new Customer(id, firstname, lastname, email, city));
		}
            } catch (SQLException e) {
                System.out.println("Problème Récupération Client : " + e);
            }
        }
        
        return customers;
    }
    
    // Ajout d'un utilisateur en bdd
    public void set(Customer c){
        String querry = "INSERT INTO tCustomers VALUES ("
                + "\'" + c.getFirstname() 
                + "\',\'" + c.getLastname()
                + "\',\'" + c.getEmail()
                + "\',\'" + c.getCity().getId()
                + "\')";
        DatabaseConnection.execute(querry);
    }
    
    // Mise à jour d'un utilisateur en bdd
    public void update(Customer c){
        String querry = "UPDATE tCustomers SET (firstname = \'" + c.getFirstname() 
                + "\', lastname = \'" + c.getLastname()
                + "\', city = \'" + c.getCity().getId() + "\')";
        DatabaseConnection.execute(querry);
    }
    
}
