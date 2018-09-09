package petrusproject.com.attendancesystem;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper
{
    //Defining the database
    public static final String DATABASE_NAME = "StudentRecord.db";
    public static final String TABLE_1 = "Student";
    public static final String TABLE_2 = "Module";
    public static final String TABLE_3 = "Enrollment";
    public static final String TABLE_4 = "Assessment";
    public static final String TABLE_5 = "Attendance";

    //Constructor
    public DatabaseHelper(Context context)
    {
        //Creating the database and tables
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //Creating the Student table
        db.execSQL("CREATE TABLE " + TABLE_1 + "(stuID INTEGER PRIMARY KEY AUTOINCREMENT, student_Number INTEGER UNIQUE NOT NULL," +
                " studentName TEXT NOT NULL)");

        //Creating the Module table
        db.execSQL("CREATE TABLE " + TABLE_2 + "(modID INTEGER PRIMARY KEY AUTOINCREMENT, module_Code VARCHAR(10) UNIQUE NOT NULL)");

        //Creating the Enrollment table
        db.execSQL("CREATE TABLE " + TABLE_3 + "(enrID INTEGER PRIMARY KEY AUTOINCREMENT, studentNumber INTEGER REFERENCES " +
                "" +TABLE_1+ "(student_Number) NOT NULL, moduleCode VARCHAR(10) REFERENCES " +TABLE_2+ "(module_Code) NOT NULL)");

        //Creating the Assessment table
        db.execSQL("CREATE TABLE " + TABLE_4 + "(assID INTEGER PRIMARY KEY AUTOINCREMENT, studentNumber INTEGER REFERENCES "
                +TABLE_1+ "(student_Number) NOT NULL, moduleCode VARCHAR(10) REFERENCES " +TABLE_2+ "(module_Code) NOT NULL, " +
                "test_1 FLOAT Default 0, test_2 FLOAT Default 0,test_3 FLOAT Default 0, assig_1 FLOAT Default 0, assig_2 FLOAT Default 0, " +
                "assig_3 FLOAT Default 0, qz_1 FLOAT Default 0, qz_2 FLOAT Default 0, qz_3 FLOAT Default 0,ca_marks FLOAT Default 0, " +
                "exam_marks FLOAT Default 0, final_marks FLOAT Default 0)");

        //Creating the Attendance table
        db.execSQL("CREATE TABLE " + TABLE_5 + "(attID INTEGER PRIMARY KEY AUTOINCREMENT, studentNumber INTEGER NOT NULL, moduleCode VARCHAR(10) REFERENCES " +
                "" +TABLE_2+ "(module_Code) NOT NULL, date DATE NOT NULL, present TEXT Default 'No' )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("Drop table if exists " + TABLE_1 );
        db.execSQL("Drop table if exists " + TABLE_2 );
        db.execSQL("Drop table if exists " + TABLE_3 );
        db.execSQL("Drop table if exists " + TABLE_4 );
        db.execSQL("Drop table if exists " + TABLE_5 );
        onCreate(db);
    }
}
