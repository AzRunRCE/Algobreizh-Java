/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.dao;

import algobreizh.Models.Customer;
import algobreizh.Models.Meeting;
import algobreizh.Models.Salesman;
import algobreizh.sql.dao.DAO;
import algobreizh.sql.dao.factory.AbstractDAOFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author quentinmartinez
 */
public class MeetingsDAO  extends DAO<Meeting>{
    public MeetingsDAO(Connection conn)
    {
        super(conn);
    }

    @Override
    public boolean create(Meeting obj) {
     String querry = "INSERT INTO tMeetings(id_tSalesman, id_tCustomer, date, infos) VALUES (\'" + obj.getSalesman().getId()
                + "\',\'" + obj.getCustomer().getId()
                + "\',\'" + obj.getDate()
                + "\',\'" + obj.getInfos()
                + "\')";
        this.execute(querry); 
        return true;
    }

    @Override
    public boolean delete(Meeting obj) {
        String query = "DELETE FROM tMeetings WHERE id = " + obj.getId();
        this.execute(query);
        return true;
    }

    @Override
    public boolean update(Meeting obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Meeting> getAll() {
        AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
        
        
        DAO<Salesman> salesmanDAO = adf.getSalesmanDAO();
        DAO<Customer> customersDAO = adf.getCustomerDAO();
        
        List<Meeting> meetings = new ArrayList<>();
        
        String query = "SELECT * FROM tMeetings";
        ResultSet res = this.execute(query);
        if (res != null) {
            try {
		while (res.next()) {
                    
                    int id = res.getInt("id");
                    Date date = res.getDate("MeetingDate");
                    Customer customer = customersDAO.get(res.getInt("id_tCustomers"));
                    Salesman salesman = salesmanDAO.get(res.getInt("id_tSalesman"));
                    String desc = res.getString("description");
                    String contact = res.getString("contact");
                    String telephone = res.getString("telephone");
                    Meeting m = new Meeting(id, salesman,customer, date, desc,contact,telephone);
                    meetings.add(m);
		}
            } catch (SQLException e) {
                System.out.println("Algobreizh SQL Exception: " + e);
            }
        }
        return meetings;   
    }

    @Override
    public Meeting get(int id) {
      AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
        DAO<Salesman> salesmanDAO = adf.getSalesmanDAO();
        DAO<Customer> customersDAO = adf.getCustomerDAO();
        
        List<Meeting> meetings = new ArrayList<>();
        
        String query = "SELECT * FROM tMeetings WHERE id" + id;
        ResultSet res = this.execute(query);
        if (res != null) {
            try {
		while (res.next()) {

                    Date date = res.getDate("meetingDate");
                    Customer customer = customersDAO.get(res.getInt("id_tCustomer"));
                    Salesman salesman = salesmanDAO.get(res.getInt("id_tSalesman"));
                    String desc = res.getString("desc");
                    String contact = res.getString("contact");
                    String telephone = res.getString("telephone");
                    return new Meeting(id, salesman,customer, date, desc,contact,telephone);
                    
		}
            } catch (SQLException e) {
                System.out.println("Algobreizh SQL Exception: " + e);
            }
        }
        return null;       
    }

   
    
}
