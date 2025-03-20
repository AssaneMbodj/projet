package gui;  // ou autre package si vous décidez de le placer ailleurs

import javax.swing.table.AbstractTableModel;
import java.util.List;
import model.Bien;  // Assurez-vous que ce package est correctement importé

public class BienTableModel extends AbstractTableModel {
    private final List<Bien> biens;
    private final String[] columnNames = {"Type", "Adresse", "IdBien","Annee"};

    public BienTableModel(List<Bien> biens) {
        this.biens = biens;
    }

    @Override
    public int getRowCount() {
        return biens.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Bien bien = biens.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return bien.getType();
            case 1:
                return bien.getAdresse();
            case 2:
                return bien.getIdBien();
            case 3:
                return bien.getAnneeConst();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
