package petrusproject.com.attendancesystem.appModel;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import petrusproject.com.attendancesystem.R;
import petrusproject.com.attendancesystem.databaseModel.DbAdapter;

public class AttendanceView extends AppCompatActivity {

    //Variables declaration
    EditText studentNum, moduleCode, theDate, attendanceStatus;
    Button saveButton;
    TableView<String[]> tb;
    AttendanceTableHelper helper;
    DbAdapter adapter;
    FloatingActionButton fabButton;
    SimpleDateFormat dateFormat;
    AttendanceTask attendanceTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance_view);

        //Getting the current date
        dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        //TableView
        helper = new AttendanceTableHelper(this);
        tb = findViewById(R.id.attendanceTableView);
        tb.setColumnCount(4);
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this,helper.getTableHeader()));
        tb.setDataAdapter(new SimpleTableDataAdapter(this, helper.getTable()));


        fabButton = findViewById(R.id.fab);
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayDialog();
            }
        });
    }

    public void displayDialog(){

        //Create the dialog and set it properties.
        Dialog inputDialog = new Dialog(this);
        inputDialog.setTitle("Add Records");
        inputDialog.setContentView(R.layout.input_dialog_layout);

        //Initialise the views
        studentNum = inputDialog.findViewById(R.id.studentNumberId);
        moduleCode = inputDialog.findViewById(R.id.moduleId);
        attendanceStatus = inputDialog.findViewById(R.id.statusId);
        theDate = inputDialog.findViewById(R.id.studentDateId);

        saveButton = inputDialog.findViewById(R.id.saveRecordsBtn);

        //set onLick to be able to save records to the database
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AttendanceTask task = new AttendanceTask();
                task.setStudent_number(studentNum.getText().toString());
                task.setModule(moduleCode.getText().toString());
                task.setTheDate(theDate.getText().toString());
                task.setAttended(attendanceStatus.getText().toString());

                if (new DbAdapter(AttendanceView.this).prepAttendance(task)){

                    studentNum.setText("");
                    moduleCode.setText("");
                    attendanceStatus.setText("");
                    theDate.setText("");
                    tb.setDataAdapter(new SimpleTableDataAdapter(AttendanceView.this, helper.getTable()));

                }else{
                    Toast.makeText(AttendanceView.this,"Records not saved!",Toast.LENGTH_LONG).show();
                }
            }
        });


        inputDialog.show();
    }
}
