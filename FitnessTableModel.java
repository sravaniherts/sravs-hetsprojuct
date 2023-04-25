import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FitnessTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Name", "Shift", "Day", "Week", "Price", "Capacity", "Rating"};
    private final List<FitnessLesson> fitnessLessons;

    public FitnessTableModel(List<FitnessLesson> fitnessLessons) {
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
    public void addLesson(FitnessLesson lesson) {
    int index = fitnessLessons.size();
    fitnessLessons.add(lesson);
    fireTableRowsInserted(index, index);
}


    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FitnessLesson fitnessLesson = fitnessLessons.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return fitnessLesson.getName();
            case 1:
                return fitnessLesson.getShift();
            case 2:
                return fitnessLesson.getDay();
            case 3:
                return fitnessLesson.getWeek();
            case 4:
                return fitnessLesson.getPrice();
            case 5:
                return fitnessLesson.getCapacity();
            case 6:
                return fitnessLesson.getRating();
            default:
                return null;
        }
    }
}
