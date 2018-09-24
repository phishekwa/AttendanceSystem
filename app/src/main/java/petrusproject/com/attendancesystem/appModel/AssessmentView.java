package petrusproject.com.attendancesystem.appModel;

import android.app.Dialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;
import petrusproject.com.attendancesystem.R;
import petrusproject.com.attendancesystem.databaseModel.DbAdapter;

public class AssessmentView extends AppCompatActivity {

    //Declaration of variables
    EditText studentNumber, moduleC, test1, test2, test3, qz1, qz2, qz3, assignment1, assignment2, assignment3, examMarks;
    Button saveButton;
    TableView<String[]> tb;
    TableHelper helper;
    FloatingActionButton fabButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment_view);

        //TableView
        helper = new TableHelper(this);
        tb = findViewById(R.id.attendanceTableView2);
        tb.setColumnCount(14);
        tb.canScrollHorizontally(1);
        tb.canScrollVertically(-1);
        tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this,helper.getAssessmentTableHeader()));
        tb.setDataAdapter(new SimpleTableDataAdapter(this, helper.getAssessmentTableContent()));


        //Dialog button
        fabButton = findViewById(R.id.fab2);
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                displayDialog();
            }
        });
    }

    private void displayDialog() {

        //Create the dialog and set it properties.
        Dialog dialog = new Dialog(this);
        dialog.setTitle("Add Records");
        dialog.setContentView(R.layout.assess_dialog_layout);

        //Initialise views
        studentNumber = dialog.findViewById(R.id.studentNumber2Id);
        moduleC = dialog.findViewById(R.id.moduleCId);
        test1 = dialog.findViewById(R.id.test1Id);
        test2 = dialog.findViewById(R.id.test2Id);
        test3 = dialog.findViewById(R.id.test3Id);
        qz1 = dialog.findViewById(R.id.qz1Id);
        qz2 = dialog.findViewById(R.id.qz2Id);
        qz3 = dialog.findViewById(R.id.qz2Id);
        assignment1 = dialog.findViewById(R.id.assignment1Id);
        assignment2 = dialog.findViewById(R.id.assignment2Id);
        assignment3 = dialog.findViewById(R.id.assignment3Id);
        examMarks = dialog.findViewById(R.id.examMarksId);

        saveButton = dialog.findViewById(R.id.saveRecordsBtn4);

        //On lick listener for adding to the database
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Getting values
                AddingAssessment add = new AddingAssessment();
                add.setS_number(studentNumber.getText().toString());
                add.setModule(moduleC.getText().toString());
                add.setTest1(test1.getText().toString());
                add.setTest2(test2.getText().toString());
                add.setTest3(test3.getText().toString());
                add.setQz1(qz1.getText().toString());
                add.setQz2(qz2.getText().toString());
                add.setQz3(qz3.getText().toString());
                add.setAssignment1(assignment1.getText().toString());
                add.setAssignment2(assignment2.getText().toString());
                add.setAssignment3(assignment3.getText().toString());
                add.setExam_marks(examMarks.getText().toString());


                if(new DbAdapter(AssessmentView.this).addAssessment(add)){

                    //Clear all text inputs
                    studentNumber.setText("");
                    moduleC.setText("");
                    test1.setText("");
                    test2.setText("");
                    test3.setText("");
                    qz1.setText("");
                    qz2.setText("");
                    qz3.setText("");
                    assignment1.setText("");
                    assignment2.setText("");
                    assignment3.setText("");
                    examMarks.setText("");
                    tb.setDataAdapter(new SimpleTableDataAdapter(AssessmentView.this, helper.getAssessmentTableContent()));

                }else{
                    Toast.makeText(AssessmentView.this,"Records not saved!",Toast.LENGTH_LONG).show();
                }
            }
        });
        dialog.show();
    }
}
