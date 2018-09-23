package petrusproject.com.attendancesystem.databaseModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import petrusproject.com.attendancesystem.appModel.AddingModule;
import petrusproject.com.attendancesystem.appModel.AddingStudent;
import petrusproject.com.attendancesystem.appModel.AttendanceTask;

public class DbAdapter {

    //Defining objects
    Context ctx;
    SQLiteDatabase db;
    DbHelper helper;

    //Constructor
    public DbAdapter(Context ctx) {
        this.ctx = ctx;
        helper = new DbHelper(ctx);
    }

    //adding the student's details to the Student table
    public boolean addStudents(AddingStudent item)
    {

        try {
            db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(DbConstants.stuSTUDENT_NUMBER, item.getS_number());
            values.put(DbConstants.stuSTUDENT_NUMBER, item.getS_name());

            long results = db.insert(DbConstants.Student_TB,DbConstants.stuID,values);

            if (results > 0)
            {
                return true;
            }

        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally {
            //helper.close();
        }
        return false;
    }

    //adding module to the Modules table
    public boolean addModule(AddingModule item)
    {
        try {
            db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(DbConstants.moMODULE_CODE, item.getModule());

            long results = db.insert(DbConstants.Module_TB, DbConstants.moID, values);

            if (results > 0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            helper.close();
        }

        return false;
    }
    //populating the Attendance table
    public boolean prepAttendance(AttendanceTask item){
        try{
            db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(DbConstants.attSTUDEN_NUMBER, item.getStudent_number());
            values.put(DbConstants.attMODULE_CODE, item.getModule());
            values.put(DbConstants.attDATE, item.getTheDate());
            values.put(DbConstants.attSTATUS, item.getAttended());

            long results = db.insert(DbConstants.Attendance_TB, DbConstants.attID,values);

            if (results > 0){
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            helper.close();
        }

        return false;
    }

    public ArrayList<AttendanceTask> retrieveAttendance(){

        ArrayList<AttendanceTask> aTaskList = new ArrayList<>();
        String [] theColumns = {DbConstants.attID,DbConstants.attSTUDEN_NUMBER,DbConstants.attMODULE_CODE,DbConstants.attDATE,DbConstants.attSTATUS};

        try {
            db = helper.getWritableDatabase();

            Cursor csr = db.query(DbConstants.Attendance_TB,theColumns,null,null,null,null,null);

            AttendanceTask attend; //Object to help with the setters methods of Attendance task

            if (csr != null){

                while(csr.moveToNext()){
                   String s_number = csr.getString(1);
                   String module = csr.getString(2);
                   String date = csr.getString(3);
                   String attended = csr.getString(4);

                   //Create the attendance task object and set the results from the database to the setters.
                    attend = new AttendanceTask();
                    attend.setStudent_number(s_number);
                    attend.setModule(module);
                    attend.setTheDate(date);
                    attend.setAttended(attended);

                    //add to the attendance task collection
                    aTaskList.add(attend);
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return aTaskList;
    }
}
