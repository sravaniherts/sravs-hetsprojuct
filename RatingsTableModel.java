/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SHOOT
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RatingsTableModel extends AbstractTableModel {
    private final String[] columnNames = {"lesson", "week","rating"};
    private final List<FitnessLesson> fitnessLessons;

    public RatingsTableModel(List<FitnessLesson> fitnessLessons) {
        this.fitnessLessons = fitnessLessons;
    }

    @Override
    public int getRowCount() {
        return fitnessLessons.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FitnessLesson fitnesslesson = fitnessLessons.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return fitnesslesson.getName();
            case 1:
                return fitnesslesson.getWeek();
            case 2 :
                return fitnesslesson.getRating();
            default:
                return null;
        }
    }
}
