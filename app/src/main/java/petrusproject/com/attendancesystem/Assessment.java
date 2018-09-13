package petrusproject.com.attendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Calendar;

public class Assessment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner categorySpinner, moduleSpinner;
    ArrayAdapter<CharSequence> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);

        //Get current date
        Calendar dyt = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(dyt.getTime());

        TextView showDateAssess = findViewById(R.id.assessViewDateId);
        showDateAssess.setText(currentDate);

        //Defining a spinner to select categories from.
        categorySpinner = findViewById(R.id.categorySpinnerId);
        adapter = ArrayAdapter.createFromResource(this,R.array.category, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        //Define the click listener method on item selected
        categorySpinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String itemSelected = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),itemSelected,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
