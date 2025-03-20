package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class firstOfAll {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					firstOfAll window = new firstOfAll();
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
	public firstOfAll() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 593, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("QUI SUIS-JE ?");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(231, 51, 110, 28);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("VALIDER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SignUpLoc window = new SignUpLoc();
					window.frame.setVisible(true);
				} catch (Exception e3) {
					e3.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(365, 213, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VALIDER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SignUpGestion window = new SignUpGestion();
					window.frame.setVisible(true);
				} catch (Exception e10) {
					e10.printStackTrace();
				}
					
				
			}
		});
		btnNewButton_1.setBounds(365, 327, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("LOCATAIRE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(98, 208, 75, 28);
		frame.getContentPane().add(lblNewLabel);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("GESTIONNAIRE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(98, 322, 115, 28);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
