
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;
import java.util.*;

class ContactHome implements ListSelectionListener, ActionListener, Runnable {
	private static final long serialVersionUID = 1L;
	JFrame maFrame;
	JTextField textNom;
	JTextField textPrenom;
	JTextField txtEMail;

	JTextField txtPhoneNo1;
	JTextField txtPhoneNo2;
	JTextField txtPhoneNo3;
	JTextField txtWebpage;
	JTextField texDateAnniv;

	JButton btnHome;
	JButton btnPhoto;

	Vector v = new Vector(6, 3);
	int i = 0, k = 0;

	FileInputStream fis;
	ObjectInputStream ois;

	JList list;
	DefaultListModel listModel;
	ListSelectionModel listSelectionModel;

	JRadioButton bynom, byprenom;

	Thread t;

	JTable tableRechercher;

	JTextField textRecherche;

	String titreColonne[] = { "Nom", "Prenom", "Phone No 1.", "Phone No 2.",
			"E Mail", "Anniversaire" };

	Object data[][] = new Object[5][6];
	  HomeView hov = new HomeView();

	ContactHome() {

		try {
			String savegarde = "./listeContact.txt";
			fis = new FileInputStream(savegarde);
			ois = new ObjectInputStream(fis);
			v = (Vector) ois.readObject();
			ois.close();
		} catch (Exception e) {

		}

	}

	public void run() {

		try {
			String savegarde = "./listeContact.txt";
			FileOutputStream fos = new FileOutputStream(savegarde);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(v);
			oos.flush();
			oos.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(maFrame,
					"Error Opening Data File: Impossible d'enregistrer.",
					"Error Opening Data File", JOptionPane.INFORMATION_MESSAGE);
		}

	}
	public void EcranContact(){
		
	}
	public void AjoutContact() {
		maFrame = new JFrame("Contact");
		maFrame.setBounds(100, 100, 480, 700);
	//	maFrame.setLocationRelativeTo(null);
		maFrame.setUndecorated(true);
		maFrame.setResizable(false);

		JLabel lblNom = new JLabel(" Nom: ");
		JLabel lblPrenom = new JLabel("Prenom: ");
		JLabel lblPhoneNo1 = new JLabel("Phone No 1: ");
		JLabel lblEMail = new JLabel("EMail: ");
		JLabel lblPhoneNo2 = new JLabel("Phone No 2: ");
		JLabel lblDateAnniv = new JLabel("Date anniversaire: ");

		textNom = new JTextField(30);
		textPrenom = new JTextField(30);
		txtPhoneNo1 = new JTextField(30);
		txtPhoneNo2 = new JTextField(30);
		txtEMail = new JTextField(30);
		texDateAnniv = new JTextField(30);
		JButton btnPhoto = new JButton("Photo");
		btnPhoto.setPreferredSize(new Dimension(200,150));
		btnPhoto.setBorderPainted(false); // retire l'effet btn
		btnPhoto.setForeground(Color.red);

		JButton btnAjouter = new JButton("Ajouter un contact");
		btnHome = new JButton("Retour");
		btnHome.setBorderPainted(false);
		btnAjouter.setBorderPainted(false);
		btnAjouter.addActionListener(this);
		btnHome.addActionListener(this);
		
		JPanel btnPaneNord = new JPanel();
		JPanel centerPane = new JPanel();
		JPanel bottomPane = new JPanel();
		JPanel 	panelPho=new JPanel();
		bottomPane.setBackground(Color.green);
		centerPane.setBackground(Color.gray);
		panelPho.setBackground(Color.gray);
	
		centerPane.add(lblNom);
		centerPane.add(textNom);
		centerPane.add(lblPrenom);
		centerPane.add(textPrenom);
		centerPane.add(lblPhoneNo1);
		centerPane.add(txtPhoneNo1);
		centerPane.add(lblPhoneNo2);
		centerPane.add(txtPhoneNo2);
		centerPane.add(lblEMail);
		centerPane.add(txtEMail);
		centerPane.add(lblDateAnniv);
		centerPane.add(texDateAnniv);
		bottomPane.add(btnAjouter);
		btnPaneNord.add(btnPhoto);
		bottomPane.add(btnHome);
		
		centerPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		centerPane.setLayout(new GridLayout(0, 1, 30, 20));
		//centerPane.setLayout(new GridLayout(0, 1));

		panelPho.add(centerPane);
		
		maFrame.getContentPane().add(btnPaneNord, BorderLayout.NORTH);
//		maFrame.getContentPane().add(centerPane, BorderLayout.CENTER);
		maFrame.getContentPane().add(panelPho, BorderLayout.CENTER);
		maFrame.getContentPane().add(bottomPane, BorderLayout.SOUTH);

		maFrame.setVisible(true);
		maFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		maFrame.setResizable(false);

	}

	/*
	 * Mehodes Modifier contact
	 */
	public void ModifierContacts() {
		String nom, prenom,PhoneNo1;
		maFrame = new JFrame("Contact");
		maFrame.setBounds(100, 100, 480, 700);

		maFrame.setUndecorated(true);
		JPanel centerPane = new JPanel();
		listModel = new DefaultListModel();

		Contact contact = new Contact();

		for (int l = 0; l < v.size(); l++) {
			contact = (Contact) v.elementAt(l);

			nom = contact.getnom();
			prenom = contact.getprenom();
			PhoneNo1 = contact.getPhoneNo1();
			listModel.addElement(nom + " " + prenom+ "\n     "+PhoneNo1 );
		
		}

		list = new JList(listModel);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel = list.getSelectionModel();
		listSelectionModel.addListSelectionListener(this);

		JScrollPane listScrollPane = new JScrollPane(list);

		JPanel topPane = new JPanel();
		JLabel label = new JLabel("liste Contact");
		topPane.add(label);

		JPanel bottomPane = new JPanel();
		listScrollPane.setBackground(Color.gray);
		topPane.setBackground(Color.BLACK);
		bottomPane.setBackground(Color.green);

		JButton btnModifier = new JButton("Modifier");
		btnModifier.setBorderPainted(false);
		bottomPane.add(btnModifier);
		btnModifier.addActionListener(this);

		JButton btnHome = new JButton("Retour");
		btnHome.setBorderPainted(false);
		bottomPane.add(btnHome);
		btnHome.addActionListener(this);

		maFrame.getContentPane().add(topPane, BorderLayout.NORTH);
		maFrame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
		maFrame.getContentPane().add(bottomPane, BorderLayout.SOUTH);

		maFrame.setVisible(true);
		maFrame.getContentPane().add(topPane, BorderLayout.NORTH);
		maFrame.setVisible(true);

	}

	public void ChercherContacts() {
		maFrame = new JFrame("Contact");
		maFrame.setBounds(100, 100, 480, 700);
		maFrame.setResizable(false);
		maFrame.setUndecorated(true);

		JPanel topPane = new JPanel();
		JPanel centerPane = new JPanel();

		textRecherche = new JTextField(20);
		JButton btnRechercher = new JButton("Trouver");
		btnRechercher.addActionListener(this);
		JButton bttnbtnHome = new JButton("Home");
		bttnbtnHome.addActionListener(this);
		centerPane.add(textRecherche);
		centerPane.add(btnRechercher);
		centerPane.add(bttnbtnHome);

		tableRechercher = new JTable(data, titreColonne);

		JScrollPane scroll_Pane = new JScrollPane(tableRechercher);

		tableRechercher.setPreferredScrollableViewportSize(new Dimension(480, 700));

		maFrame.getContentPane().add(scroll_Pane, BorderLayout.CENTER);

		maFrame.getContentPane().add(topPane, BorderLayout.SOUTH);
		maFrame.getContentPane().add(centerPane, BorderLayout.NORTH);
		maFrame.setVisible(true);
	}

	public void TrierContacts() {
		maFrame = new JFrame("Contact");
		maFrame.setBounds(100, 100, 480, 700);
		maFrame.setUndecorated(true);

		maFrame.setResizable(false);

		bynom = new JRadioButton("Nom");
		bynom.setActionCommand("Nom");
		bynom.setSelected(true);

		byprenom = new JRadioButton("Prenom");
		byprenom.setActionCommand("Prenom");

		ButtonGroup group = new ButtonGroup();
		group.add(bynom);
		group.add(byprenom);

		JPanel topPane = new JPanel();
		JLabel label = new JLabel("Trier les contacts par:");
		topPane.add(label);

		JPanel pane = new JPanel(new GridLayout(0, 1));
		pane.add(bynom);
		pane.add(byprenom);

		JPanel PanelCentre = new JPanel();
		JButton btnTrier = new JButton("Trier Contact");
		JButton btnHome = new JButton("Home");
		PanelCentre.add(btnTrier);
		PanelCentre.add(btnHome);
		btnTrier.addActionListener(this);
		btnHome.addActionListener(this);

		maFrame.getContentPane().add(topPane, BorderLayout.NORTH);
		maFrame.getContentPane().add(pane, BorderLayout.CENTER);
		maFrame.getContentPane().add(PanelCentre, BorderLayout.SOUTH);

		maFrame.setVisible(true);

	}

	public void SupprimerContact() {
		String nom, prenom,PhoneNo1;
		maFrame = new JFrame("Contact");
		maFrame.setBounds(100, 100, 480, 700);
		maFrame.setUndecorated(true);

		JPanel centerPane = new JPanel();
		listModel = new DefaultListModel();

		Contact contact = new Contact();

		for (int l = 0; l < v.size(); l++) {
			contact = (Contact) v.elementAt(l);

			nom = contact.getnom();
			prenom = contact.getprenom();
			PhoneNo1 = contact.getPhoneNo1();
			listModel.addElement(nom + " " + prenom+ "\n     "+PhoneNo1 );
		
		}

		list = new JList(listModel);

		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSelectionModel = list.getSelectionModel();
		listSelectionModel.addListSelectionListener(this);

		JScrollPane listScrollPane = new JScrollPane(list);

		JPanel topPane = new JPanel();
		topPane.setBackground(Color.gray);
		JLabel label = new JLabel("liste Contact");
		topPane.add(label);

		JPanel bottomPane = new JPanel();
		bottomPane.setBackground(Color.GREEN);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBorderPainted(false);
		bottomPane.add(btnSupprimer);
		btnSupprimer.addActionListener(this);

		JButton btnHome = new JButton("Retour");
		btnHome.setBorderPainted(false);
		bottomPane.add(btnHome);
		btnHome.addActionListener(this);

		maFrame.getContentPane().add(topPane, BorderLayout.NORTH);
		maFrame.getContentPane().add(listScrollPane, BorderLayout.CENTER);
		maFrame.getContentPane().add(bottomPane, BorderLayout.SOUTH);

		maFrame.setVisible(true);

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public void TousContacts() {

		maFrame = new JFrame("Contact");
		maFrame.setBounds(100, 100, 480, 700);
		maFrame.setResizable(false);
		maFrame.setUndecorated(true);

		Contact con = new Contact();

		String titreColonne[] = { "Nom", "Prenom", "Phone No 1.",
				"Phone No 2.", "EMail", "Anniversaire" };

		Object data[][] = new Object[v.size()][6];

		for (int j = 0; j < v.size(); j++) {

			con = (Contact) v.elementAt(k);

			data[j][0] = con.getnom();
			data[j][1] = con.getprenom();
			data[j][2] = con.getPhoneNo1();
			data[j][3] = con.getPhoneNo2();
			data[j][4] = con.getemail();
			data[j][5] = con.getdateAnniv();

			k++;

		}
		k = 0;

		JTable abtable = new JTable(data, titreColonne);
		JScrollPane scroll_Pane = new JScrollPane(abtable);
		abtable.setPreferredScrollableViewportSize(new Dimension(480, 700));

		maFrame.getContentPane().add(scroll_Pane, BorderLayout.CENTER);

		maFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getActionCommand() == "Ajouter un contact") {

			if (textNom.getText().equals("") && textPrenom.getText().equals("")
					&& txtPhoneNo1.getText().equals("")
					&& txtPhoneNo2.getText().equals("")
					&& txtEMail.getText().equals("")
					&& texDateAnniv.getText().equals("")) {

				JOptionPane.showMessageDialog(maFrame, "Veuillez remplir !",
						"Entrées vides", JOptionPane.INFORMATION_MESSAGE);

			} else {
				Contact contact = new Contact();
				contact.setDetails(textNom.getText(), textPrenom.getText(),
						txtPhoneNo1.getText(), txtPhoneNo2.getText(),
						txtEMail.getText(), texDateAnniv.getText());
				v.addElement(contact);
				SauveVector();
				textNom.setText("");
				textPrenom.setText("");
				txtPhoneNo1.setText("");
				txtPhoneNo2.setText("");
				txtEMail.setText("");
				texDateAnniv.setText("");

			}

		}else if (ae.getActionCommand() == "Modifier") {

			int index;
			try {

				index = list.getSelectedIndex();

				if (index == -1) {

					JOptionPane.showMessageDialog(maFrame,
							"choisir un Contact.", "Modifier un Contact",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					int n = JOptionPane.showConfirmDialog(maFrame,
							"Voulez Vous Vraiment Modifier ?", "Modifier?",
							JOptionPane.YES_NO_OPTION);

					if (n == JOptionPane.YES_OPTION) {
						
						
						listModel.remove(index);
						v.removeElementAt(index);
						maFrame.dispose();
						AjoutContact();
						
						
						Contact contact = new Contact();
						index = list.getSelectedIndex();
					
						contact.setDetails(textNom.getText(), textPrenom.getText(),
								txtPhoneNo1.getText(), txtPhoneNo2.getText(),
								txtEMail.getText(), texDateAnniv.getText());
						v.addElement(contact);
						SauveVector();
												
						maFrame.setVisible(true);
				
						
					} else if (n == JOptionPane.NO_OPTION) {

					}

				}

			} catch (Exception e) {

			}

		} 
		
		else if (ae.getActionCommand() == "Supprimer") {

			int index;
			try {

				index = list.getSelectedIndex();

				if (index == -1) {

					JOptionPane.showMessageDialog(maFrame,
							"choisir un Contact.", "Supprimer un Contact",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					int n = JOptionPane.showConfirmDialog(maFrame,
							"Voulez Vous Vraiment Supprimer ?", "Supprimer?",
							JOptionPane.YES_NO_OPTION);

					if (n == JOptionPane.YES_OPTION) {
						listModel.remove(index);
						v.removeElementAt(index);
						SauveVector();
						maFrame.setVisible(true);

					} else if (n == JOptionPane.NO_OPTION) {

					}

				}

			} catch (Exception e) {

			}

		} else if (ae.getActionCommand() == "Home") {
			
			hov.setBounds(100, 100, 480, 700);
			hov.setVisible(true);
			maFrame.dispose();
    
			
		} else if (ae.getActionCommand() == "Retour") {
			ContactView Cov =new ContactView();
//			Cov.setBounds(100, 100, 480, 700);
//			Cov.setVisible(true);
			maFrame.dispose();
    
			
		} 	else if (ae.getActionCommand() == "Trouver") {
			String strCherch;
			strCherch = textRecherche.getText();
			boolean flag = false;
			Contact con = new Contact();
			int c = 0;

			for (int t = 0; t < 5; t++) {
				data[t][0] = "";
				data[t][1] = "";
				data[t][2] = "";
				data[t][3] = "";
				data[t][4] = "";
				data[t][5] = "";
			
				
			}

			for (int t = 0; t < v.size(); t++) {

				con = (Contact) v.elementAt(t);
				System.out.print("\n 1 inside search");
				if (strCherch.equalsIgnoreCase(con.getnom())
						|| strCherch.equalsIgnoreCase(con.getprenom())
						|| strCherch.equalsIgnoreCase(con.getnom() + " "
								+ con.getprenom())) {

					System.out.print("\n 2 inside search if");
					flag = true;
					System.out.print("\n 3 inside if");
					data[c][0] = con.getnom();
					data[c][1] = con.getprenom();
					data[c][2] = con.getPhoneNo1();
					data[c][3] = con.getPhoneNo2();
					data[c][4] = con.getemail();
					data[c][5] = con.getdateAnniv();
					tableRechercher = new JTable(data, titreColonne);
					maFrame.setBounds(100, 100, 480, 700);
				

					if (c < 5) {
						c++;
					}
					System.out.print("\n 4 inside search if end" + flag);
				}

			}

			if (flag) {
				JOptionPane.showMessageDialog(maFrame, "Contact trouvé",
						"Resultat de la recherche!",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(maFrame, "Contact non trouvé!",
						"Resultat de la recherche!",
						JOptionPane.INFORMATION_MESSAGE);
			}

			System.out.print("\n 5 search end" + flag);
			
		} else if (ae.getActionCommand() == "Trier Contact") {

			if (bynom.isSelected()) {
				Contact contact1 = new Contact();
				Contact contact2 = new Contact();
				Contact temp = new Contact();
				int l, m;

				for (l = 0; l < v.size() - 1; l++) {
					for (m = l + 1; m < v.size(); m++) {
						contact1 = (Contact) v.elementAt(l);
						contact2 = (Contact) v.elementAt(m);

						if (contact1.getnom().compareTo(contact2.getnom()) > 0) {
							temp = (Contact) v.elementAt(m);
							v.setElementAt(v.elementAt(l), m);
							v.setElementAt(temp, l);
						}

					}
				}

				SauveVector();
			} else {

				Contact contact1 = new Contact();
				Contact contact2 = new Contact();
				Contact temp = new Contact();
				int l, m;

				for (l = 0; l < v.size() - 1; l++) {
					for (m = l + 1; m < v.size(); m++) {
						contact1 = (Contact) v.elementAt(l);
						contact2 = (Contact) v.elementAt(m);

						if (contact1.getprenom()
								.compareTo(contact2.getprenom()) > 0) {
							temp = (Contact) v.elementAt(m);
							v.setElementAt(v.elementAt(l), m);
							v.setElementAt(temp, l);
						}

					}
				}

				SauveVector();
			}

			maFrame.setVisible(false);
		}

	}

	public void SauveVector() {
		t = new Thread(this, "Sauver");
		t.start();

	}

	public void valueChanged(ListSelectionEvent lse) {

	}

}
