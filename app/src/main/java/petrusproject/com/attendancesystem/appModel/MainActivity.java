package petrusproject.com.attendancesystem.appModel;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import petrusproject.com.attendancesystem.R;
import petrusproject.com.attendancesystem.databaseModel.DbAdapter;
import petrusproject.com.attendancesystem.databaseModel.DbHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private CardView assessCard, attendanceCard, viewAssessmentCard, viewAttendanceCard;
    EditText student_name, student_number, module;
    Button saveButton;
    //Object of DbHelper class
    DbHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
       myDb = new DbHelper(this);

        //Defining cards
        assessCard = findViewById(R.id.assessCardViewId);
        attendanceCard = findViewById(R.id.takeAttendanceCardViewId);
        viewAssessmentCard = findViewById(R.id.viewAssessCardViewId);
        viewAttendanceCard = findViewById(R.id.viewAttendanceCardViewId);

        //Set click listeners to cards
        assessCard.setOnClickListener(this);
        attendanceCard.setOnClickListener(this);
        viewAssessmentCard.setOnClickListener(this);
        viewAttendanceCard.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.addStudentMenuItem){
            //Open add student dialog
            displayAddStudentDialog();
        }
        if (id == R.id.addModuleMenuItem){
            //Open add module dialog
            displayAddModuleDialog();
        }
        if (id == R.id.exitMenuItem){
            finish();
        }
        return true;
    }

    @Override
    public void onClick(View v) {

        Intent i;

        switch (v.getId())
        {
            case R.id.assessCardViewId: i = new Intent(this, Assessment.class);
            startActivity(i); break;


            case R.id.takeAttendanceCardViewId: i = new Intent(this, Attendance.class);
            startActivity(i); break;


            case R.id.viewAssessCardViewId: i = new Intent(this, AssessmentView.class);
            startActivity(i); break;

            case R.id.viewAttendanceCardViewId: i = new Intent(this, AttendanceView.class);
            startActivity(i); break;

            default: break;
        }

    }

    public void displayAddStudentDialog(){

        //Create the dialog and set it properties.
        Dialog inputDialog = new Dialog(this);
        inputDialog.setTitle("Add Student");
        inputDialog.setContentView(R.layout.add_student_dialog_layout);

        //Initialise the views
        student_number = inputDialog.findViewById(R.id.edTxtAdd_S_NumberId);
        student_name = inputDialog.findViewById(R.id.edTxtAdd_S_NameId);

        saveButton = inputDialog.findViewById(R.id.saveRecordsBtnS);

        //set onLick to be able to save records to the database
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddingStudent student = new AddingStudent();
                student.setS_number(student_number.getText().toString());
                student.setS_name(student_name.getText().toString());

                if (new DbAdapter(MainActivity.this).addStudents(student)){

                    student_number.setText("");
                    student_name.setText("");
                    Toast.makeText(MainActivity.this,"Records saved!",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this,"Records not saved!",Toast.LENGTH_LONG).show();
                }
            }
        });


        inputDialog.show();
    }

    public void displayAddModuleDialog(){

        //Create the dialog and set it properties.
        Dialog inputDialog = new Dialog(this);
        inputDialog.setTitle("Add Module");
        inputDialog.setContentView(R.layout.add_module_dialog_layout);

        //Initialise the views
        module = inputDialog.findViewById(R.id.edTxtAddModuleId);

        saveButton = inputDialog.findViewById(R.id.saveRecordsBtnM);

        //set onLick to be able to save records to the database
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddingModule module1 = new AddingModule();
                module1.setModule(module.getText().toString());

                if (new DbAdapter(MainActivity.this).addModule(module1)){

                    module.setText("");
                    Toast.makeText(MainActivity.this,"Record saved!",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this,"Record not saved!",Toast.LENGTH_LONG).show();
                }
            }
        });


        inputDialog.show();
    }

}
