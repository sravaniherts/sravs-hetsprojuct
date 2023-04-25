import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FitnessLessonByNameModelTableZ extends AbstractTableModel {
    private final String[] columnNames = {"Name", "Shift", "Day", "Week", "Price", "Capacity", "Rating"};
    private final List<FitnessLesson> Zresult;

    public FitnessLessonByNameModelTableZ(List<FitnessLesson> Zresult) {
        this.Zresult = Zresult;
    }

    @Override
    public int getRowCount() {
        return Zresult.size();
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
        int index = Zresult.size();
        Zresult.add(lesson);
        fireTableRowsInserted(index, index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FitnessLesson a = Zresult.get(rowIndex);
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
