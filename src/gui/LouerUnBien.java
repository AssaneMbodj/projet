package gui;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import dao.BienDao;  // Assurez-vous que ce package est correct
import model.Bien;   // Assurez-vous que ce package est correct
import java.util.ArrayList;

public class LouerUnBien {

    JFrame frame;
    private JTable table;
    private BienDao bienDao;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LouerUnBien window = new LouerUnBien();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void populateTable() {
        ArrayList<Bien> biens = bienDao.getList();
        BienTableModel model = new BienTableModel(biens);
        table.setModel(model);
    }

    public LouerUnBien() {
        bienDao = new BienDao();
        initialize();
        populateTable();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 593, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Louer un BIEN");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblNewLabel_2.setBounds(231, 11, 135, 28);
        frame.getContentPane().add(lblNewLabel_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 557, 400);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        JButton btnNewButton = new JButton("VALIDER");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsque le bouton est cliqué
               // actionPerformedButton();
            	JOptionPane.showMessageDialog(null, "Bien loué(e) avec succès");
            }
        });
        btnNewButton.setBounds(365, 461, 85, 21);
        frame.getContentPane().add(btnNewButton);
    
        
    }

}