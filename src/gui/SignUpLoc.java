package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpLoc {

	public JFrame frame;
	private JPasswordField passwordFieldN;
	private JTextField textFieldId;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpLoc window = new SignUpLoc();
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
	public SignUpLoc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 589, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN UP");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(227, 41, 127, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(89, 162, 45, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("MOT DE PASSE");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(89, 244, 111, 34);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String  idSaisi = textFieldId.getText();
				char [] mdpSaisi = passwordFieldN.getPassword();
				
				if (idSaisi.equals("") || mdpSaisi.equals("")) {
		            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
		        } else if (!idSaisi.contains("Loc")) {
		            JOptionPane.showMessageDialog(null, "id  invalide.", "Erreur", JOptionPane.ERROR_MESSAGE);
		        } else {
		            // Affichage des saisies de l'utilisateur dans la console
		            System.out.println("id : " + idSaisi);
		            System.out.println("Mot de passe : " + mdpSaisi);
		            JOptionPane.showMessageDialog(null, "Saisies validées avec succès !", "Succès", JOptionPane.INFORMATION_MESSAGE);
		        }  
					try {
						LouerUnBien window = new LouerUnBien();
						window.frame.setVisible(true);
					} catch (Exception j) {
						j.printStackTrace();
						frame.dispose();
							
				}
			}
		});
		btnNewButton.setBounds(227, 358, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		passwordFieldN = new JPasswordField();
		passwordFieldN.setBounds(279, 253, 127, 19);
		frame.getContentPane().add(passwordFieldN);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(279, 162, 105, 19);
		frame.getContentPane().add(textFieldId);
		textFieldId.setColumns(10);
	}
}
