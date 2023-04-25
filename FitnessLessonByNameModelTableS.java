import java.util.List;
import javax.swing.table.AbstractTableModel;

public class FitnessLessonByNameModelTableS extends AbstractTableModel {
    private final String[] columnNames = {"Name", "Shift", "Day", "Week", "Price", "Capacity", "Rating"};
    private final List<FitnessLesson> Sresult;

    public FitnessLessonByNameModelTableS(List<FitnessLesson> Sresult) {
        this.Sresult = Sresult;
    }

    @Override
    public int getRowCount() {
        return Sresult.size();
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
        int index = Sresult.size();
        Sresult.add(lesson);
        fireTableRowsInserted(index, index);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        FitnessLesson a = Sresult.get(rowIndex);
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
