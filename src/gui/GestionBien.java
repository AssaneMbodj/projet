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

import dao.BienDao;

import model.Bien;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionBien {

	JFrame frame;
	private JTextField textFieldIdBien;
	private JTextField textField_adresse;
	private JTextField textFieldtype;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionBien window = new GestionBien();
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
	public GestionBien() {
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
		
		JLabel lblNewLabel_1_1 = new JLabel("IDBien");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1.setBounds(152, 78, 93, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("TYPE");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBackground(Color.BLACK);
		lblNewLabel_1_1_1.setBounds(152, 142, 93, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Adresse");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_3.setBounds(152, 267, 164, 26);
		panel_1.add(lblNewLabel_1_1_3);
		
		textFieldIdBien = new JTextField();
		textFieldIdBien.setColumns(10);
		textFieldIdBien.setBounds(452, 84, 244, 19);
		panel_1.add(textFieldIdBien);
		
		textField_adresse = new JTextField();
		textField_adresse.setColumns(10);
		textField_adresse.setBounds(452, 148, 244, 19);
		panel_1.add(textField_adresse);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BienDao util = new BienDao ();
				int idBien;
				String adresse;
				String  type;
				int anneeConst;
				
				adresse = textField_adresse.getText();
				type = textFieldtype.getText();
				idBien = Integer.parseInt(textFieldIdBien.getText());
				anneeConst=Integer.parseInt(textField.getText());

				//String adresse, String type, int annéeConst, int idBien
				Bien newUtil = new Bien(adresse,type,anneeConst,idBien);
				util.add(newUtil);
				JOptionPane.showMessageDialog(null, "bien ajouté(e) avec succès");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(546, 418, 93, 21);
		panel_1.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(152, 372, 554, 11);
		panel_1.add(separator);
		
		textFieldtype = new JTextField();
		textFieldtype.setBounds(452, 273, 251, 19);
		panel_1.add(textFieldtype);
		textFieldtype.setColumns(10);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BienDao util = new BienDao ();
				int idBien;
				String adresse;
				String  type;
				int anneeConst;
				
				adresse = textField_adresse.getText();
				type = textFieldtype.getText();
				idBien = Integer.parseInt(textFieldIdBien.getText());
				anneeConst=Integer.parseInt(textField.getText());

				//String adresse, String type, int annéeConst, int idBien
				Bien newUtil = new Bien(adresse,type,anneeConst,idBien);
				util.update(newUtil);
					JOptionPane.showMessageDialog(null, "bien mis à jour avec succès");
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.setBounds(211, 419, 93, 21);
		panel_1.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BienDao util = new BienDao ();
				int idBien;
				String adresse;
				String  type;
				int anneeConst;
				
				adresse = textField_adresse.getText();
				type = textFieldtype.getText();
				idBien = Integer.parseInt(textFieldIdBien.getText());
				anneeConst=Integer.parseInt(textField.getText());

				Bien newUtil = new Bien(adresse,type,anneeConst,idBien);
				
					util.delete(idBien);
					JOptionPane.showMessageDialog(null, " Bien supprimé(e) avec succès");
					
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnDelete.setBounds(375, 419, 93, 21);
		panel_1.add(btnDelete);
		
	
		
	
		JLabel lblNewLabel_1 = new JLabel("AnneeConst");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(152, 208, 107, 26);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(459, 214, 234, 19);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(142, 372, 554, 11);
		panel_1.add(separator_1);
		
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
		btnNewButton_3_1.setBounds(681, 406, 85, 21);
		//frame.getContentPane().add(btnNewButton_3_1);
		panel_1.add(btnNewButton_3_1);
		
		JLabel lblNewLabel = new JLabel("Gestion des Biens");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(53, 10, 964, 32);
		frame.getContentPane().add(lblNewLabel);
		
	}
	

	public Window getFrame() {
		return frame;
	}
}
