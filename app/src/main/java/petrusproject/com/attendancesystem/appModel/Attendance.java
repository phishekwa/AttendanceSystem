package petrusproject.com.attendancesystem.appModel;

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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import petrusproject.com.attendancesystem.R;

public class Attendance extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    //Declaring variables
    TextView showDate, txtShowModuleId;
    EditText edItemSelected;
    Spinner moduleSpinner;
    ArrayAdapter<CharSequence> moduleAdapter;
    SimpleDateFormat dateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);


        //Initialise variables
        showDate = findViewById(R.id.attendViewDateId);
        moduleSpinner = findViewById(R.id.moduleSpinnerAttendId);

        //Get current date
        /*Calendar dyt = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(dyt.getTime());
        showDate.setText(currentDate);*/
        dateFormat = new SimpleDateFormat("dd MMM YYYY");
        showDate.setText(dateFormat.format(new Date()));


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
