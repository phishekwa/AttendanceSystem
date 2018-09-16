package petrusproject.com.attendancesystem;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class Attendance extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    //Declaring variables
    TextView showDate, txtShowModuleId;
    EditText edItemSelected;
    Spinner moduleSpinner;
    ArrayAdapter<CharSequence> moduleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);


        //Initialise variables
        showDate = findViewById(R.id.attendViewDateId);
        moduleSpinner = findViewById(R.id.moduleSpinnerAttendId);

        //Get current date
        Calendar dyt = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(dyt.getTime());
        showDate.setText(currentDate);


        //Defining the adapter for a spinner
        moduleAdapter = ArrayAdapter.createFromResource(this,R.array.modules,R.layout.support_simple_spinner_dropdown_item);
        moduleAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        moduleSpinner.setAdapter(moduleAdapter);

        moduleSpinner.setSelection(0, false); //don't add the first Item to the textView.

        //Establish the onclick listener of the spinner
        moduleSpinner.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String itemSelected = parent.getItemAtPosition(position).toString();
        /*if (itemSelected.equals("Select Module"))
        {
            txtShowModuleId.setText("No Module");
        }
        else {
            txtShowModuleId.setText(itemSelected);

        }*/
        return;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
