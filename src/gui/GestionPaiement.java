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
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import dao.PaiementDao;
import model.Paiement;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.event.ActionEvent;

public class GestionPaiement {

    JFrame frame;
    private JTextField textFieldIdPaiement;
    private JTextField textFieldIdLoc;
    private JTextField textFieldIdBien;
    private JTextField textFieldMontant;
    private JTextField textFieldDatePaiement;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GestionPaiement window = new GestionPaiement();
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
    public GestionPaiement() {
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

        JLabel lblIdPaiement = new JLabel("ID Paiement");
        lblIdPaiement.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblIdPaiement.setBounds(152, 78, 120, 26);
        panel_1.add(lblIdPaiement);

        JLabel lblIdLocataire = new JLabel("ID Locataire");
        lblIdLocataire.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblIdLocataire.setBounds(152, 142, 120, 26);
        panel_1.add(lblIdLocataire);

        JLabel lblIdBien = new JLabel("ID Bien");
        lblIdBien.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblIdBien.setBounds(152, 208, 120, 26);
        panel_1.add(lblIdBien);

        JLabel lblMontant = new JLabel("Montant");
        lblMontant.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMontant.setBounds(152, 267, 120, 26);
        panel_1.add(lblMontant);

        JLabel lblDatePaiement = new JLabel("Date Paiement");
        lblDatePaiement.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblDatePaiement.setBounds(152, 326, 120, 26);
        panel_1.add(lblDatePaiement);

        textFieldIdPaiement = new JTextField();
        textFieldIdPaiement.setColumns(10);
        textFieldIdPaiement.setBounds(452, 84, 244, 19);
        panel_1.add(textFieldIdPaiement);

        textFieldIdLoc = new JTextField();
        textFieldIdLoc.setColumns(10);
        textFieldIdLoc.setBounds(452, 148, 244, 19);
        panel_1.add(textFieldIdLoc);

        textFieldIdBien = new JTextField();
        textFieldIdBien.setColumns(10);
        textFieldIdBien.setBounds(452, 214, 244, 19);
        panel_1.add(textFieldIdBien);

        textFieldMontant = new JTextField();
        textFieldMontant.setColumns(10);
        textFieldMontant.setBounds(452, 273, 244, 19);
        panel_1.add(textFieldMontant);

        textFieldDatePaiement = new JTextField();
        textFieldDatePaiement.setColumns(10);
        textFieldDatePaiement.setBounds(452, 332, 244, 19);
        panel_1.add(textFieldDatePaiement);

        JButton btnValider = new JButton("VALIDER");
        btnValider.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handlePaiementAction(e, "add");
            }
        });
        btnValider.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnValider.setBounds(546, 418, 93, 21);
        panel_1.add(btnValider);

        JSeparator separator = new JSeparator();
        separator.setBounds(152, 372, 554, 11);
        panel_1.add(separator);

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handlePaiementAction(e, "update");
            }
        });
        btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnUpdate.setBounds(211, 419, 93, 21);
        panel_1.add(btnUpdate);

        JButton btnDelete = new JButton("DELETE");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handlePaiementAction(e, "delete");
            }
        });
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnDelete.setBounds(375, 419, 93, 21);
        panel_1.add(btnDelete);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(142, 372, 554, 11);
        panel_1.add(separator_1);

        JButton btnRetour = new JButton("RETOUR");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    tachesEmployee window = new tachesEmployee();
                    window.frame.setVisible(true);
                    frame.dispose();
                } catch (Exception e200) {
                    e200.printStackTrace();
                }
            }
        });
        btnRetour.setBounds(681, 406, 85, 21);
        panel_1.add(btnRetour);

        JLabel lblTitle = new JLabel("Gestion des Paiements");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(53, 10, 964, 32);
        frame.getContentPane().add(lblTitle);
    }

    /**
     * Handle the action for adding, updating, or deleting a paiement.
     */
    private void handlePaiementAction(ActionEvent e, String action) {
        PaiementDao paiementDao = new PaiementDao();
        try {
            int idPaiement = Integer.parseInt(textFieldIdPaiement.getText().trim());
            int idLoc = Integer.parseInt(textFieldIdLoc.getText().trim());
            int idBien = Integer.parseInt(textFieldIdBien.getText().trim());
            double montant = Double.parseDouble(textFieldMontant.getText().trim());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date = LocalDate.parse(textFieldDatePaiement.getText().trim(), formatter);
            Date datePaiement = Date.valueOf(date);

            Paiement paiement = new Paiement(idPaiement, idLoc, idBien, montant, datePaiement, false);
            switch (action) {
                case "add":
                    paiementDao.add(paiement);
                    JOptionPane.showMessageDialog(null, "Paiement ajouté avec succès");
                    break;
                case "update":
                    paiementDao.update(paiement);
                    JOptionPane.showMessageDialog(null, "Paiement mis à jour avec succès");
                    break;
                case "delete":
                    paiementDao.delete(idPaiement);
                    JOptionPane.showMessageDialog(null, "Paiement supprimé avec succès");
                    break;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Erreur de format numérique: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Erreur de format de date: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erreur: " + ex.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Window getFrame() {
        return frame;
    }
}
