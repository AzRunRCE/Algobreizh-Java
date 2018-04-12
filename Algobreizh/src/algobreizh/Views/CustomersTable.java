/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algobreizh.Views;


import algobreizh.Models.Customer;
import algobreizh.Models.Meeting;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author quentinmartinez
 */
public class CustomersTable extends JTable{
    
    public  CustomersTable(List<Customer> clients)
    { 
          
         
          
    } 
    
    public class TableModelCustomer extends AbstractTableModel implements DefaultTableModel{
         
	   
	    public TableModelCustomer(List<Customer> _customers){
	       
	    }
            
	    @Override
	    public Customer getItem(int index){
	       return null;
	    }
            
	    public String getColumnName(int columnIndex){
	        return null;
	    }
	    
            public int getRowCount() {
	      return 0;
	    }  
	    
            public int getColumnCount() {
             return 0;
	    }
            
	    public Object getValueAt(int rowIndex, int columnIndex) {
	    	
	           return null;
            }
	   
            public Class<?> getColumnClass(int columnIndex){   
	               return String.class;
	    }
            
           @Override
            public void addRow(Object row){
		
	        fireTableDataChanged();
            }
            
            @Override
            public void removeRow(int row){
		
	        fireTableDataChanged();
	    }
           
            public boolean isCellEditable(int row, int col){
		      return true;
            }
}
}
