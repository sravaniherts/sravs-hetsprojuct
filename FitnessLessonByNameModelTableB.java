import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FitnessLessonByNameModelTableB extends AbstractTableModel {
    private final String[] columnNames = {"Name", "Shift", "Day", "Week", "Price", "Capacity", "Rating"};
    private final List<FitnessLesson> Bresult;

    public FitnessLessonByNameModelTableB(List<FitnessLesson> Bresult) {
        this.Bresult = Bresult;
    }

    @Override
    public int getRowCount() {
        return Bresult.size();
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
        int index = Bresult.size();
        Bresult.add(lesson);
        fireTableRowsInserted(index, index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FitnessLesson a = Bresult.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return a.getName();
            case 1:
                return a.getShift();
            case 2:
                return a.getDay();
            case 3:
                return a.getWeek();
            case 4:
                return a.getPrice();
            case 5:
                return a.getCapacity();
            case 6:
                return a.getRating();
            default:
                return null;
        }
    }
}
