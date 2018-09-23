package petrusproject.com.attendancesystem.databaseModel;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper
{
    //Constructor
    public DbHelper(Context context)
    {
        //Creating the database and tables
        super(context, DbConstants.DATABASE_NAME, null, 2);
        //SQLiteDatabase db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            //Creating the database tables
            db.execSQL(DbConstants.Assessment_TB);
            db.execSQL(DbConstants.Attendance_TB);
            db.execSQL(DbConstants.Module_TB);
            db.execSQL(DbConstants.Student_TB);
            db.execSQL(DbConstants.Enrollment_TB);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        try {
            db.execSQL(DbConstants.Drop_Assessment_TB);
            db.execSQL(DbConstants.Drop_Attendance_TB);
            db.execSQL(DbConstants.Drop_Enrollment_TB);
            db.execSQL(DbConstants.Drop_module_TB);
            db.execSQL(DbConstants.Drop_student_TB);
            onCreate(db);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }

    }

}
