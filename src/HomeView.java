import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



public class HomeView  extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane =new JPanel();;
	private JPanel panelTop  =new JPanel();
	private JPanel panelSud =new JPanel();;
	private JPanel panelCentre =new JPanel();;
	private JButton btnContact = new JButton("Contact");
	private JButton btnGalerie = new JButton("Galerie");
	private JButton btnQuitte = new JButton("Quitter");;
	private JLabel btnTime = new JLabel("Smartphone");;

	String fondEcran ;
	

	public HomeView() {
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	setLocationRelativeTo(null);
	setUndecorated(true);
	 
	panelTop.setBackground(Color.BLACK);
	panelSud.setBackground(Color.GREEN);
	btnTime.setBackground(Color.black);
	btnGalerie.setPreferredSize(new Dimension(100,100));
	btnContact.setPreferredSize(new Dimension(100,100));
	btnQuitte.setBorderPainted(false);
	btnGalerie.setBorderPainted(false);
	btnContact.setBorderPainted(false);
	btnContact.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent arg0) {
			ContactView clikcontact = new ContactView();
			dispose();
			
		}
	});
	btnGalerie.addActionListener(new ActionListener() {
		
		public void actionPerformed(ActionEvent arg0) {
			PhotoView photo = new PhotoView();
			photo.setVisible(true);
			photo.setBounds(100, 100, 480, 700);
			dispose();
		}
	});
	btnQuitte.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e){
			 
			   if(e.getSource()==btnQuitte){
			      setVisible(false);
			     dispose();
			   }
			}
	});

	
	panelTop.add(btnTime);
	panelCentre.add(btnContact);
	panelCentre.add(btnGalerie);
	panelSud.add(btnQuitte);

	
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	contentPane.setLayout(new BorderLayout(0, 0));
	
	contentPane.add(panelTop, BorderLayout.NORTH);
	contentPane.add(panelCentre, BorderLayout.CENTER);
	contentPane.add(panelSud, BorderLayout.SOUTH);
	
	add(contentPane);
	
	setResizable(false);
	setTitle("IPHONE");
	pack();
	}

	

	public static void main(String[] args) {
		HomeView frame=new HomeView();
			
		frame.setBounds(100, 100, 480, 700);;
		//	frame.setSize(480, 800);
		frame.setVisible(true);
		
	}


}
