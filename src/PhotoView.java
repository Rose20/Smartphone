import java.awt.BorderLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;


public class PhotoView extends JFrame {

    private static final long serialVersionUID = 1L;
    
    File sourceimage = new File("./images");
	String [] listImg = sourceimage.list();
	ImageIcon img ; 
	private JButton[] tab = new JButton[listImg.length];
    private JPanel panelPhotosCard;
    private JPanel panelSelectedPhoto;
    private JPanel panelScroll;
    private JLabel lblClickOnThe;
    private JButton btnHome;
    private JPanel panelWithPhotosButtons;
    private JScrollPane scrollPanePhotos;
    private JButton btnPhotoIsHere;
    private JButton btnAddToContact;
    protected ImageIcon image;

    public PhotoView() {
        super();
        setUndecorated(true);
        panelPhotosCard = new JPanel();
        getContentPane().add(panelPhotosCard, BorderLayout.CENTER);
        panelPhotosCard.setLayout(new CardLayout(0, 0));

        panelScroll = new JPanel();
        panelScroll.setBackground(Color.BLACK);
        panelPhotosCard.add(panelScroll, "name_44554684112709");
        panelScroll.setLayout(null);

        lblClickOnThe = new JLabel("Click pour ouvrir la photo");
        lblClickOnThe.setFont(new Font("Dialog", Font.BOLD, 13));
        lblClickOnThe.setForeground(Color.WHITE);
        lblClickOnThe.setBounds(12, 12, 212, 14);
        panelScroll.add(lblClickOnThe);
        

        scrollPanePhotos = new JScrollPane(
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanePhotos.setBounds(12, 37, 450, 599);
        panelScroll.add(scrollPanePhotos);
        

        panelWithPhotosButtons = new JPanel();
        scrollPanePhotos.setViewportView(panelWithPhotosButtons);
        
        panelWithPhotosButtons.setLayout(new GridLayout(5, 3, 20, 20));
        
        
        for (int i = 0; i < listImg.length; i++) {
        	img = new ImageIcon(sourceimage  + "/" + listImg[i]);
          tab[i] = new JButton(String.valueOf(i));
            
            JButton btnImage = new JButton(img);
            tab[i] = new JButton(new ImageIcon(
                    ((new ImageIcon(sourceimage  + "/" + listImg[i]).getImage().getScaledInstance(-1,
                            150, Image.SCALE_FAST))))); // redimension en fonction de la taille du bouton

            tab[i].setPreferredSize(new Dimension(200, 150));
            panelWithPhotosButtons.add(tab[i]);

            tab[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent a) {

                    for (int i = 0; i <  listImg.length; i++) { //  ActionListener ajout de bouton avec l'image

                        if (a.getSource() == tab[i]) {
                            System.out.println("image: " + i);

                            panelPhotosCard.removeAll();
                            panelPhotosCard.add(panelSelectedPhoto); //ouverture de nouveau panel de CardLayout  
                            panelPhotosCard.repaint();
                            panelPhotosCard.revalidate();

                            System.out.println("The button was clicked!");
                            System.out.println("/images/p" + i + ".jpg");  // click sur le button pour l'ouvri dans un autre bouton
                            btnPhotoIsHere.setIcon(new ImageIcon(
                                    ((new ImageIcon(sourceimage  + "/" + listImg[i]).getImage()
                                    .getScaledInstance(-1, 330,
                                            Image.SCALE_FAST)))));

                            image = new ImageIcon(sourceimage  + "/" + listImg[i]);

                            Path path = FileSystems.getDefault().getPath(
                            		sourceimage  + "/" + listImg[i]);

                            System.out.println("path: " + path);

                        }

                    }
                }
            });
            panelSelectedPhoto = new JPanel();
            
            panelSelectedPhoto.setBackground(Color.GRAY);
            panelPhotosCard.add(panelSelectedPhoto, "name_43166851735807");
            
            panelSelectedPhoto.setLayout(null);

            btnPhotoIsHere = new JButton();
            btnPhotoIsHere.setBounds(59, 70, 360, 330);
            panelSelectedPhoto.add(btnPhotoIsHere);

            btnAddToContact = new JButton("Home");
            btnAddToContact.setFont(new Font("Dialog", Font.BOLD, 13));
            btnAddToContact.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                	HomeView f = new HomeView() ;
                	f.setVisible(true);
                	f.setBounds(100, 100, 480, 700);
                	dispose();
                    /*ContactPhoto.getButton();
		            ContactPhoto.givePhoto(image);*/
                }
            });
            
            btnAddToContact.setBounds(168, 448, 137, 40);
            panelSelectedPhoto.add(btnAddToContact);

           
        }
    }
    
    public static void main(String[] args) {
    	PhotoView f=  new PhotoView();
    	f.setVisible(true);
    	f.setBounds(100, 100, 480, 700);
    	
    }
}
