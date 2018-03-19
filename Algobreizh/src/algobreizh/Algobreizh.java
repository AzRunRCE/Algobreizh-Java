/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh;

import algobreizh.Managers.SalesmansManager;
import algobreizh.Managers.CustomersManager;
import algobreizh.Managers.CitiesManager;
import algobreizh.Managers.MeetingsManager;
import algobreizh.Models.Salesman;
import algobreizh.Models.Customer;
import algobreizh.Models.City;
import algobreizh.Models.Meeting;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class Algobreizh {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        Salesman commerciale1 = SalesmansManager.get(1);
        Customer client1 = CustomersManager.get(2);
        City villeClient1 = CitiesManager.get(client1.getCity().getId());
        
        ArrayList<Meeting> meetingsCommerciale1 = MeetingsManager.getAll(commerciale1);
        
        
        // Scenario
        
        System.out.println("Bonjour je suis " +
                commerciale1.getFirstname() + " " + 
                commerciale1.getLastname() + " le commerciale.");
                
        System.out.println("\n Enchanté, moi je suis " + 
                client1.getFirstname() + " " +
                client1.getLastname() + " le client. " +
               "\n Je suis me situe à " + villeClient1.getName());
        
        System.out.println("Voici les rendez vous de " + commerciale1.getFirstname() + " " + commerciale1.getLastname());

        meetingsCommerciale1.forEach((Meeting m) -> { 
            System.out.println(
                "**********************************" +
                "\n Client: " + m.getCustomer().getFirstname() + " " + m.getCustomer().getLastname() +
                "\n Date et heure: " + m.getDate() + " " + m.getHour() +
                "\n Informations supplémentaires: " + m.getInfos() +
                "\n**********************************"
            );
        });
        
        Meeting newMeeting = new Meeting(SalesmansManager.get(1), CustomersManager.get(1), new Date(1,1,1), new Time(1,1,1), "Des putes et de la coc pour le faire signer !");
        MeetingsManager.add(newMeeting);
        meetingsCommerciale1 = MeetingsManager.getAll(commerciale1);
        
        System.out.println("Après avoir ajouté un rdv, voiçi la nouvelle liste des rdv");
        meetingsCommerciale1.forEach((Meeting m) -> { 
            System.out.println(
                "**********************************" +
                "\n Client: " + m.getCustomer().getFirstname() + " " + m.getCustomer().getLastname() +
                "\n Date et heure: " + m.getDate() + " " + m.getHour() +
                "\n Informations supplémentaires: " + m.getInfos() +
                "\n**********************************"
            );
        });
    }
    
}