package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import dao.BailleurDao;
import model.Bailleur;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionBailleur {

	private JFrame frame;
	private JTextField textFieldIdBail;
	private JTextField textField_nomBail;
	private JTextField textFieldnumTel;
	private JTextField textFieldmdp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionBailleur window = new GestionBailleur();
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
	public GestionBailleur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1105, 546);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(53, 52, 964, 457);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("IdBail:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(152, 78, 93, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("NomBail:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(152, 159, 93, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("NumTel:");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(152, 267, 164, 26);
		panel_1.add(lblNewLabel_1_1_3);
		
		textFieldIdBail = new JTextField();
		textFieldIdBail.setColumns(10);
		textFieldIdBail.setBounds(452, 84, 244, 19);
		panel_1.add(textFieldIdBail);
		
		textField_nomBail = new JTextField();
		textField_nomBail.setColumns(10);
		textField_nomBail.setBounds(452, 165, 244, 19);
		panel_1.add(textField_nomBail);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BailleurDao util = new BailleurDao ();
				int idBail;
				String nomBail;
				int numTel;					
				String mdp = null;
				
				nomBail = textField_nomBail.getText();
				numTel = Integer.parseInt(textFieldnumTel.getText());
				idBail = Integer.parseInt(textFieldIdBail.getText());
				Bailleur newUtil = new Bailleur(nomBail,idBail,numTel,mdp);
				util.add(newUtil);
				JOptionPane.showMessageDialog(null, "Bailleur ajouté(e) avec succès");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(546, 418, 93, 21);
		panel_1.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(152, 372, 554, 11);
		panel_1.add(separator);
		
		textFieldnumTel = new JTextField();
		textFieldnumTel.setBounds(452, 273, 251, 19);
		panel_1.add(textFieldnumTel);
		textFieldnumTel.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			        BailleurDao util = new BailleurDao ();
					int idBail;
					String nomBail;
					 int numTel;					
					 String mdp = null;
					 
					 nomBail = textField_nomBail.getText();
					 numTel = Integer.parseInt(textFieldnumTel.getText());
					 idBail = Integer.parseInt(textFieldIdBail.getText());
					 Bailleur newUtil = new Bailleur(nomBail,idBail,numTel,mdp);
						util.update(newUtil);
					JOptionPane.showMessageDialog(null, "bailleur mis à jour avec succès");
					
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(211, 419, 93, 21);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				BailleurDao util = new BailleurDao ();
				int idBail;
				String nomBail;
				 int numTel;					
				 String mdp = null;
					nomBail = textField_nomBail.getText();
					numTel = Integer.parseInt(textFieldnumTel.getText());
					idBail = Integer.parseInt(textFieldIdBail.getText());
					Bailleur newUtil = new Bailleur(nomBail,idBail,numTel,mdp);
					util.delete(idBail);
					JOptionPane.showMessageDialog(null, "bailleur supprimé(e) avec succès");
					
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(375, 419, 93, 21);
		panel_1.add(btnDelete);
		
		JButton btnNewButton_3_1 = new JButton("RETOUR");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			
				public void actionPerformed(ActionEvent e) {
					try {
						tachesEmployee window = new tachesEmployee();
						window.frame.setVisible(true);
					} catch (Exception e200) {
						e200.printStackTrace();
					}
				}
			});
			btnNewButton_3_1.setBounds(661, 416, 85, 21);
			frame.getContentPane().add(btnNewButton_3_1);

		btnNewButton_3_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_3_1.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton_3_1.setBounds(703, 419, 85, 21);
		panel_1.add(btnNewButton_3_1);
		
		JButton btnNewButton_3 = new JButton("RETOUR");
		btnNewButton_3.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.RIGHT);
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
		
		JLabel lblNewLabel = new JLabel("Gestion Bailleur");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 10, 964, 32);
		frame.getContentPane().add(lblNewLabel);
	}
	

	public Window getFrame() {
		return frame;
	}
}

