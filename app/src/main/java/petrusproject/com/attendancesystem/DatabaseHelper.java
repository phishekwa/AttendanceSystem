package petrusproject.com.attendancesystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME = "Student_Record.db";
    public static final String TABLE_1 = "StudentInfo";
    public static final String TABLE_2 = "Assessment";
    public static final String TABLE_3 = "Register";
    public static final String TABLE_4 = "Student_Record";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
