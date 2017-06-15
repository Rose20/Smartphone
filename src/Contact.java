

import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

import java.util.*;

class Contact implements Serializable {
	private String nom;
	private String prenom;
	private String PhoneNo1;
	private String PhoneNo2;
	private String email;
	private String dateAnniv;

	public void setDetails(String nom, String prenom,
			String phoneNo1, String phoneNo2, String email, String dateAnniv) {

		this.nom = nom;
		this.prenom = prenom;
		PhoneNo1 = phoneNo1;
		PhoneNo2 = phoneNo2;
		this.email = email;
		this.dateAnniv = dateAnniv;
	}

	public String getnom() {
		return nom;
	}

	public String getprenom() {
		return prenom;
	}

	public String getemail() {
		return email;
	}

	public String getPhoneNo1() {
		return PhoneNo1;
	}

	public String getPhoneNo2() {
		return PhoneNo2;
	}

	public String getdateAnniv() {
		return dateAnniv;
	}

}
