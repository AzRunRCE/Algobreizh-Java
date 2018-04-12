/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

/**
 *
 * @author paul
 */


public class MeetingsView extends JFrame{
   private JTable table;
        
        private JMenuBar bar = new JMenuBar();
	private JMenu menuClients = new JMenu("Clients");
	private JMenuItem menuClientsVoir = new JMenuItem("Voir");
        private JMenu menuMeetings = new JMenu("Rendez-vous");
	private JMenuItem menuMeetingsVoir = new JMenuItem("Voir");
        
        public MeetingsView()
        {
                this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Algobreizh - Gestion des rendez-vous");
		this.setSize(800, 400);
                menuClients.add(menuClientsVoir);
		menuClientsVoir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				KeyEvent.CTRL_MASK + KeyEvent.SHIFT_DOWN_MASK));
	//	menuClientsVoir.addActionListener(new ViewMenuListener(this));
		menuClients.setMnemonic('v');
                
                menuMeetings.add(menuMeetingsVoir);
                menuMeetingsVoir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
				KeyEvent.CTRL_MASK + KeyEvent.SHIFT_DOWN_MASK));
	//	menuMeetingsVoir.addActionListener(new ViewMenuListener(this));
		menuMeetings.setMnemonic('m');
		// Données de notre tableau
		this.setLocationRelativeTo(null);
                
                bar.add(menuClients);
                bar.add(menuMeetings);
                
                this.setJMenuBar(bar);
                
        }
        
        public void addCloseEditionListener(ActionListener mal) {
            //	closeEdition.addActionListener(mal);
        }
    
	public void addCancelEditionListener(ActionListener cal) {
            //cancelEdition.addActionListener(cal);
        }

      
}
