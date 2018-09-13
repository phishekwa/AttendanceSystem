package petrusproject.com.attendancesystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.Format;
import java.util.Calendar;

public class Attendance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        //Get current date
        Calendar dyt = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.SHORT).format(dyt.getTime());

        TextView showDateAttend = findViewById(R.id.attendViewDateId);
        showDateAttend.setText(currentDate);
    }
}
