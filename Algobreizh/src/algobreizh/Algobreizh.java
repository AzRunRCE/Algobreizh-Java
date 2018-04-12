/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh;


import algobreizh.Models.Salesman;
import algobreizh.Models.Customer;
import algobreizh.Models.City;
import algobreizh.Models.Meeting;
import algobreizh.Views.LoginView;
import algobreizh.Views.MeetingsView;
import algobreizh.controler.LoginControler;
import algobreizh.sql.dao.DAO;
import algobreizh.sql.dao.factory.AbstractDAOFactory;
import java.util.List;

/**
 *
 * @author paul
 */
public class Algobreizh {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {     
        LoginView loginView = new LoginView();
        LoginControler loginControler = new LoginControler(loginView);
        loginControler.setVisible(true);   
    }
    
}