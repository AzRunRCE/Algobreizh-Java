/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.context;

import algobreizh.Models.Salesman;
import algobreizh.Views.LoginView;
import algobreizh.Views.MeetingsView;

/**
 *
 * @author quentinmartinez
 */
public class Context {
    private static Salesman currUser = null;
    
    public static Salesman getCurrentUser()
    {   
           return currUser;  
    }
    
    public static void setCurrentUser(Salesman salesman)
    {   
        if (currUser == null)
        {
           currUser =  salesman;
        }
    }
}
