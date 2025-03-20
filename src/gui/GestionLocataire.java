package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import dao.LocataireDao;
import model.Locataire;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionLocataire {

	public JFrame frame;
	private JTextField textField_nom;
	private JTextField textField_IDLoc;
	private JPasswordField passwordField;
	private JTextField textField_NUMTEL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionLocataire window = new GestionLocataire();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionLocataire() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 895, 555);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion Locataire");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(319, 41, 187, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(142, 143, 106, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(142, 206, 45, 19);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("NUM TEL");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(142, 265, 96, 21);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("MOT DE PASSE");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(142, 332, 126, 19);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		textField_nom = new JTextField();
		textField_nom.setBounds(470, 143, 140, 19);
		frame.getContentPane().add(textField_nom);
		textField_nom.setColumns(10);
		
		textField_IDLoc = new JTextField();
		textField_IDLoc.setBounds(470, 207, 140, 19);
		frame.getContentPane().add(textField_IDLoc);
		textField_IDLoc.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(470, 333, 140, 19);
		frame.getContentPane().add(passwordField);
		
		textField_NUMTEL = new JTextField();
		textField_NUMTEL.setBounds(470, 267, 140, 19);
		frame.getContentPane().add(textField_NUMTEL);
		textField_NUMTEL.setColumns(10);
		
		JButton btnNewButton = new JButton("AJOUTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocataireDao util = new LocataireDao ();
				int idLoc;
				String nom;
				int numTel;
				String mdp;
				
				nom = textField_nom.getText();
				idLoc = (int) Double.parseDouble(textField_IDLoc.getText());
				numTel = Integer.parseInt( textField_NUMTEL.getText());
				mdp= passwordField.getText()	;	
				Locataire newUtil = new Locataire(nom,idLoc,numTel,mdp);
				util.add(newUtil);
				JOptionPane.showMessageDialog(null, "locataire ajouté(e) avec succès");
			}
		});
		btnNewButton.setBounds(492, 416, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocataireDao util = new LocataireDao ();
				int idLoc;
				String nom;
				int numTel;
				String mdp;
				
				nom = textField_nom.getText();
				idLoc = (int) Double.parseDouble(textField_IDLoc.getText());
				numTel = Integer.parseInt( textField_NUMTEL.getText());
				mdp=passwordField.getText();	
				Locataire newUtil = new Locataire(nom,idLoc,numTel,mdp);
				util.update(newUtil);
				JOptionPane.showMessageDialog(null, "locataire mis à jour avec succès");
				
			}
		});
		btnNewButton_1.setBounds(319, 416, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocataireDao util = new LocataireDao ();
				int idLoc;
				int numTel;
				String mdp;
				String nom;
				nom = textField_nom.getText();
				idLoc = (int) Double.parseDouble(textField_IDLoc.getText());
				numTel = Integer.parseInt( textField_NUMTEL.getText());
				mdp=passwordField.getText()	;	
				Locataire newUtil = new Locataire(nom,idLoc,numTel,mdp);
				util.delete(idLoc);
				JOptionPane.showMessageDialog(null, "locataire supprimé(e) avec succès");
			}
		});
		btnNewButton_2.setBounds(163, 416, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("RETOUR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tachesEmployee window = new tachesEmployee();
					window.frame.setVisible(true);
				} catch (Exception e200) {
					e200.printStackTrace();
				}
			}
		});
		btnNewButton_3.setBounds(661, 416, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
	}
}
