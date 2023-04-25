import java.util.List;
import javax.swing.table.AbstractTableModel;

public class BookingsModelTable extends AbstractTableModel {

    private String[] columnNames = {"User ID", "User Name", "Lesson Name", "Shift", "Week", "Price"};
    private List<String[]> data;

    public BookingsModelTable(List<String[]> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rowData = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowData[0];
            case 1:
                return rowData[1];
            case 2 :
                return rowData[2];
            case 3:
                return rowData[3];
            case 4:
                return rowData[4];
            case 5:
                return rowData[5];
            default:
                return null;
        }
    }
}
