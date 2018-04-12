/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.controler;


import algobreizh.Views.LoginView;
import algobreizh.Views.MeetingsView;
import com.sun.glass.ui.Application;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author quentinmartinez
 */
public class LoginControler {
    
        private LoginView  m_view;

        public LoginControler(LoginView loginView) {
            m_view = loginView;
            m_view.addBtnConnectListener(new BtnConnectionListener());
            m_view.addBtnQuitListener(new BtnQuitListener());
            
        }
        
        public void setVisible(Boolean visible)  {     m_view.setVisible(visible);      }
        
        class BtnConnectionListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
                    m_view.setVisible(false);
                    MeetingsView meetingsView = new MeetingsView();
                    MeetingsControler meetingsControler = new MeetingsControler(meetingsView);
                    meetingsControler.setVisible(true);
	        }
	 }
        
	 class BtnQuitListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	Runtime.getRuntime().exit(1);
	        }
	 }
}
