/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.dao;

import algobreizh.sql.dao.DAO;
import algobreizh.Models.City;
import algobreizh.Models.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author quentinmartinez
 */
public class CustomerDAO extends DAO<Customer>{
   
    public CustomerDAO(Connection conn)
    {
        super(conn);
    }

    @Override
    public boolean create(Customer c) {
        try {
            String query = "INSERT INTO tCustomers VALUES ("
                + "\'" + c.getFirstname() 
                + "\',\'" + c.getLastname()
                + "\',\'" + c.getEmail()
                + "\',\'" + c.getCity().getId()
                + "\')";
            this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
                .executeQuery(query);
            } catch (SQLException e) {
            return false;
        }   
        return true;
    }

    @Override
    public boolean delete(Customer obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Customer obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer get(int id) {    
        Customer customer = null;
        try {
            ResultSet res = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY)
                .executeQuery("SELECT * FROM tCustomers WHERE id = " + id);
                if (res != null) {
                    while (res.next()) {
                        String lastname = res.getString("lastname");
                        String firstname = res.getString("firstname");
                        String email = res.getString("email");
                        int id_tCities = res.getInt("id_tCities");
                        customer = new Customer(id, firstname, lastname, email, new City(id_tCities));
                    }
                }
            } catch (SQLException e) {
            
        }
        return customer;
    }

    @Override
    public List<Customer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
