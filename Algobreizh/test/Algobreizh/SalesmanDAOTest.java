/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algobreizh;
import algobreizh.Models.Customer;
import algobreizh.Models.Salesman;
import algobreizh.sql.dao.DAO;
import algobreizh.sql.dao.factory.AbstractDAOFactory;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author quentinmartinez
 */
public class SalesmanDAOTest {
    
    public static AbstractDAOFactory adf  = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
         adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
       
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Test
    public void test_GetSalesman() {        
        DAO<Salesman> salesmanDAO = adf.getSalesmanDAO();
        List<Salesman> salesmans = salesmanDAO.getAll();
        
        if (salesmans.isEmpty())
        {
           assert false : "Assertions are turned on.";
        }
        Salesman salesman = salesmanDAO.get(salesmans.get(0).getId());
        
        Assert.assertEquals(salesman.getFirstname(), salesmans.get(0).getFirstname());
        Assert.assertEquals(salesman.getLastname(), salesmans.get(0).getLastname());
        Assert.assertEquals(salesman.getId(), salesmans.get(0).getId());
       
    }
    
    @Test
    public void test_GetCustomer() {        
        DAO<Customer> customerDAO = adf.getCustomerDAO();
        List<Customer> customers = customerDAO.getAll();  
        if (!customers.isEmpty())
        {
           assert false : "Assertions are turned on.";
        }
        Customer customer = customerDAO.get(customers.get(0).getId());
        Assert.assertEquals(customer.getFirstname(), customers.get(0).getFirstname());
        Assert.assertEquals(customer.getLastname(), customers.get(0).getLastname());
        Assert.assertEquals(customer.getId(), customers.get(0).getId());
        Assert.assertEquals(customer.getEmail(), customers.get(0).getEmail());
        Assert.assertEquals(customer.getLastDate(), customers.get(0).getLastDate());
        Assert.assertEquals(customer.getCity(), customers.get(0).getCity());
        
        
    }
    
    @Test
    public void test_addMeetings() {   
        
    }
}
