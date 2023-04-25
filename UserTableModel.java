import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Userid", "Name"};
    private final List<User> userList;

    public UserTableModel(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int getRowCount() {
        return userList.size();
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
        User user = userList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return user.getUserId();
            case 1:
                return user.getName();
            default:
                return null;
        }
    }
}
