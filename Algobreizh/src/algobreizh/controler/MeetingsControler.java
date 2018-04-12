/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.controler;

import algobreizh.Models.Meeting;
import algobreizh.Views.MeetingsTable;
import algobreizh.Views.MeetingsView;
import algobreizh.sql.dao.DAO;
import algobreizh.sql.dao.factory.AbstractDAOFactory;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 * @author quentinmartinez
 */
public class MeetingsControler {
    
	private MeetingsView  m_view;
        
	public MeetingsControler (MeetingsView meetingsView)
	{
            m_view = meetingsView; 
            
            AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
            DAO<Meeting> meetingsDAO = adf.getMeetingsDAO();
            List<Meeting> meetings = meetingsDAO.getAll();
            
            m_view.getContentPane()
				.add(new JScrollPane(new MeetingsTable(meetings)),
						BorderLayout.CENTER);  
	}
        
        public void setVisible(Boolean visible)  {     m_view.setVisible(visible);      }
        
        
	class BtnClientsListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        
	        
	        }
	 }
        
	 class BtnMeetingsListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	m_view.setVisible(false);
	        }
	 }
		
}
