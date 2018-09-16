package petrusproject.com.attendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Assessment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Declare variables

    TextView txtViewModule, showDate, txtViewAssessment;
    Spinner categorySpinner, moduleSpinner;
    NumberPicker numberPickerAssessNumber, numberPickerAssessMarks;
    ArrayAdapter<CharSequence> assessmentAdapter, moduleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);


        //Initialise Views
        numberPickerAssessNumber = findViewById(R.id.assessmentNumId);
        numberPickerAssessMarks = findViewById(R.id.assessmentTotalMarks);
        moduleSpinner = findViewById(R.id.moduleSpinnerId);
        showDate = findViewById(R.id.assessViewDateId);
        categorySpinner = findViewById(R.id.categorySpinnerId);

        //Get current date
        Calendar dyt = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(dyt.getTime());
        showDate.setText(currentDate);

        //Setting a assessment spinner assessmentAdapter
        assessmentAdapter = ArrayAdapter.createFromResource(this,R.array.category, R.layout.support_simple_spinner_dropdown_item);
        assessmentAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        categorySpinner.setAdapter(assessmentAdapter);

        //Setting a module spinner assessmentAdapter
        moduleAdapter = ArrayAdapter.createFromResource(this,R.array.modules, R.layout.support_simple_spinner_dropdown_item);
        moduleAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        moduleSpinner.setAdapter(moduleAdapter);

        //Define the click listener method on item selected
        categorySpinner.setSelection(0, false);
        moduleSpinner.setSelection(0, false);

        moduleSpinner.setOnItemSelectedListener(this);
        categorySpinner.setOnItemSelectedListener(this);

        //set up a number pickers
        numberPickerAssessNumber.setMinValue(1);
        numberPickerAssessNumber.setMaxValue(10);
        numberPickerAssessNumber.getWrapSelectorWheel();

        numberPickerAssessMarks.setMinValue(5);
        numberPickerAssessMarks.setMaxValue(100);
        numberPickerAssessMarks.getWrapSelectorWheel();


    }


    //Set select listener to the Assessment Spinners
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String assessmentItemSelected = parent.getItemAtPosition(position).toString();



     /*   if(assessmentItemSelected.equals("Select Category Here"))
        {
            txtViewAssessment.setText("No Assessment");

        }
        else {
            Toast.makeText(parent.getContext(),assessmentItemSelected,Toast.LENGTH_LONG).show();
            //txtViewAssessment.setText(assessmentItemSelected);
        }*/

        String moduleItemSelected = parent.getItemAtPosition(position).toString();

       /* if(moduleItemSelected.equals("Select Module"))
        {
            txtViewModule.getText();
        }
        else {
            txtViewModule.setText(moduleItemSelected);
        }*/
       return;
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
