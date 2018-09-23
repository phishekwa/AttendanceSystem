package petrusproject.com.attendancesystem.appModel;

import android.content.Context;

import java.util.ArrayList;

import petrusproject.com.attendancesystem.databaseModel.DbAdapter;

public class AttendanceTableHelper {

    Context tableContext;

    private String[] tableHeader = {"Student", "Module", "Date", "Attended"};
    private String[][] table;


    public AttendanceTableHelper(Context tableContext) {
        this.tableContext = tableContext;

    }

    public String[] getTableHeader() {
        return tableHeader;
    }

    public String[][] getTable() {

        ArrayList<AttendanceTask> aList = new DbAdapter(tableContext).retrieveAttendance();
        AttendanceTask aTask;

        table = new String[aList.size()][4];

        for (int i = 0; i < aList.size(); i++){
            aTask = aList.get(i);

            table[i][0] = aTask.getStudent_number();
            table[i][1] = aTask.getModule();
            table[i][2] = aTask.getTheDate();
            table[i][3] = aTask.getAttended();
        }

        return table;
    }
}
