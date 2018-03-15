/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.Managers;

import algobreizh.Database.DatabaseConnection;
import algobreizh.Models.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class CustomersManager {
    
        public Customer get(int id){
        String querry = "SELECT * FROM client WHERE id = " + id;
        Customer customer = new Customer();
        ResultSet res = DatabaseConnection.execute(querry);
        if (res != null) {
            try {
		while (res.next()) {
                    String lastname = res.getString("lastname");
                    String firstname = res.getString("firstname");
                    //int phone = res.getInt("phone");
                    String email = res.getString("email");
                    //String company = res.getString("society");
                    //String address = res.getString("address");
                    //String cp = res.getString("CP");
                    String city = res.getString("city");
                    customer = new Customer(id, firstname, lastname, email, city);
		}
            } catch (SQLException e) {
            }
        }
        return customer;
    }
        
    public ArrayList<Customer> getAll(){
        ArrayList<Customer> customers = new ArrayList<>();
        String querry = "SELECT * FROM tCustomers";
        ResultSet res = DatabaseConnection.execute(querry);
        if (res != null) {
            try {
		while (res.next()) {
                    int id = res.getInt("id");
                    String lastname = res.getString("lastname");
                    String firstname = res.getString("firstname");
                    //int phone = res.getInt("phone");
                    String email = res.getString("email");
                    //String company = res.getString("society");
                    //String address = res.getString("address");
                    //String cp = res.getString("CP");
                    String city = res.getString("city");
                    customers.add(new Customer(id, firstname, lastname, email, city));
		}
            } catch (SQLException e) {
                System.out.println("Problème Récupération Client : " + e);
            }
        }
        
        return customers;
    }
    
    /*  REVOIR LA TABLE CUSTOMER !
    
     public void createCustomer(Customer c){
        String querry = "INSERT INTO client VALUES (\'" + c.getName() 
                + "\',\'" + c.getFirstname() + "\',\'" + c.getCompany()
                + "\',\'" + c.getAddress() + "\',\'" + c.getCp()
                + "\',\'" + c.getCity() + "\')";
        DatabaseConnection.execute(querry);
    }
    
    public void modifyCustomer(Customer c){
        String querry = "UPDATE client SET (name = \'" + c.getName() 
                + "\', firstname = \'" + c.getFirstname()
                + "\', company = \'" + c.getCompany()
                + "\', address = \'" + c.getAddress()
                + "\', cp = \'" + c.getCp()
                + "\', city = \'" + c.getCity() + "\')";
        DatabaseConnection.execute(querry);
    }
    */
    
}
