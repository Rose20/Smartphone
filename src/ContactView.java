
import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

	class ContactView implements ActionListener 
	  {
				
	      JPanel top_Panel,bottom_Panel;
	  	  JScrollPane scroll_Pane;
	  	  JFrame frame;


	     
			


	  	ContactView()
	  	    {
	  		
	          	    frame = new JFrame("Telephone HTC");
	          	    frame.setBackground(Color.pink);
						frame.setBounds(100, 100, 480, 700);
						frame.setUndecorated(true);
						frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						ContactView();
	                frame.setVisible(true);
	                frame.setResizable(false);
	           		

	          }



	       public void ContactView()

	          {
	    	


	     	          JPanel top_Panel = new JPanel();
	                  JPanel bottom_Panel = new JPanel();
	                  
	                  top_Panel.setBackground(Color.BLACK);
	                  bottom_Panel.setBackground(Color.GREEN);
	                  JButton btnHome = new JButton("Home");
	                  btnHome.setBorderPainted(false);
	                 
	                  
	                  JButton btnAjouter = new JButton("Ajouter");
	                  JButton btnSupprimer = new JButton("Supprimer");
	                  JButton btnModifier = new JButton("Modifier");
	                  btnAjouter.setBorderPainted(false);
	                  btnModifier.setBorderPainted(false);
	                  btnSupprimer.setBorderPainted(false);
//	                  JButton cherchContact = new JButton("Rechercher");
//	                  JButton trierContact = new JButton("Trier");
//	                  JButton voirListContact = new JButton("Liste");
	                  

	                  btnHome.addActionListener(this);
	                  btnAjouter.addActionListener(this);
	                  btnSupprimer.addActionListener(this);
	                  btnModifier.addActionListener(this);
//	                  cherchContact.addActionListener(this);
//	                  trierContact.addActionListener(this);
//	                  voirListContact.addActionListener(this);
//	                  
	                  
	                  
	                
	                  top_Panel.add(btnAjouter);
	                  top_Panel.add(btnSupprimer);
	                  top_Panel.add(btnModifier);
//	                  top_Panel.add(cherchContact);
//	                  top_Panel.add(trierContact);
//	                  top_Panel.add(voirListContact);
	                  bottom_Panel.add(btnHome);
	                  
	                  frame.getContentPane().add(top_Panel,BorderLayout.NORTH);
	                  frame.getContentPane().add(bottom_Panel,BorderLayout.SOUTH);
	                
						



	          }


	     

	       ContactHome oh = new ContactHome();
	       HomeView hov = new HomeView();

	  	 public void actionPerformed(ActionEvent ae)
	  	    {
	  	        if(ae.getActionCommand() == "Ajouter")
	  	            {
	  	                 oh.AjoutContact();
                                 frame.dispose();

	  	            }

	  	        else  if(ae.getActionCommand() == "Rechercher")
	  	            {
	  	                 oh.ChercherContacts(); frame.dispose();

	  	            }

	  	        else  if(ae.getActionCommand() == "Modifier")
	  	            {
	  	                 oh.ModifierContacts();
	  	               frame.dispose();

	  	            }

	  	        else  if(ae.getActionCommand() == "Supprimer")
	  	            {
	  	                  oh.SupprimerContact();
	  	                  frame.dispose();
	  	              
	  	                  
	  	            }

	  	        else  if(ae.getActionCommand() == "Liste")
	  	            {

	  	                  oh.TousContacts();
	  	                  frame.dispose();
	  	                
	  	            }
	  	      else  if(ae.getActionCommand() == "Home")
	            {
	  	    	  	hov.setBounds(100, 100, 480, 700);;
	  	    	  	hov.setVisible(true);
	                  frame.dispose();

	            }
	  	        
	  	       
	  	    }
	  	  public static void main(String args[])
          {
    	   ContactView add = new ContactView();
          }


					
	  }

