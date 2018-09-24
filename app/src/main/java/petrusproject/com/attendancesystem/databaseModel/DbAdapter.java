package petrusproject.com.attendancesystem.databaseModel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import petrusproject.com.attendancesystem.appModel.AddingAssessment;
import petrusproject.com.attendancesystem.appModel.AddingModule;
import petrusproject.com.attendancesystem.appModel.AddingStudent;
import petrusproject.com.attendancesystem.appModel.AddingAttendance;

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
            helper.close();
        }
        return false;
    }

    //adding module to the Modules table
    public boolean addModule(AddingModule item)
    {
        try {
            db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(DbConstants.moMODULE_CODE,item.getModule());

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
    public boolean prepAttendance(AddingAttendance item){
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

    public ArrayList<AddingAttendance> retrieveAttendance(){

        ArrayList<AddingAttendance> aTaskList = new ArrayList<>();
        String [] theColumns = {DbConstants.attID,DbConstants.attSTUDEN_NUMBER,DbConstants.attMODULE_CODE,DbConstants.attDATE,DbConstants.attSTATUS};

        try {
            db = helper.getWritableDatabase();

            Cursor csr = db.query(DbConstants.Attendance_TB,theColumns,null,null,null,null,null);

            AddingAttendance attend; //Object to help with the setters methods of Attendance task

            if (csr != null){

                while(csr.moveToNext()){
                   String s_number = csr.getString(1);
                   String module = csr.getString(2);
                   String date = csr.getString(3);
                   String attended = csr.getString(4);

                   //Create the attendance task object and set the results from the database to the setters.
                    attend = new AddingAttendance();
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

    public ArrayList<AddingAssessment> retrieveAssessment(){

        ArrayList<AddingAssessment> assessmentList = new ArrayList<>();
        String [] columns = {DbConstants.asID,DbConstants.asSTUDEN_NUMBER,DbConstants.asMODULE_CODE,DbConstants.asTEST_1,
                                DbConstants.asTEST_2,DbConstants.asTEST_3, DbConstants.asQZ_1, DbConstants.asQZ_2,DbConstants.asQZ_3,
                                DbConstants.asASSIGNMENT_1, DbConstants.asASSIGNMENT_2, DbConstants.asASSIGNMENT_3,
                                DbConstants.asCA_MARKS, DbConstants.asEXAM_MARKS, DbConstants.asFINAL_MARKS};

        try {
            db = helper.getWritableDatabase();

            Cursor csr = db.query(DbConstants.Assessment_TB,columns,null,null,null,null,null);

            AddingAssessment assess; //Object to help with the setters methods of Assessment task

            if (csr != null){

                while(csr.moveToNext()){
                    String s_number = csr.getString(1);
                    String module = csr.getString(2);
                    String test_1 = csr.getString(3);
                    String test_2 = csr.getString(4);
                    String test_3 = csr.getString(5);
                    String qz_1 = csr.getString(6);
                    String qz_2 = csr.getString(7);
                    String qz_3 = csr.getString(8);
                    String assignment_1 = csr.getString(9);
                    String assignment_2 = csr.getString(10);
                    String assignment_3 = csr.getString(11);
                    String ca_mark = csr.getString(12);
                    String exam_mark = csr.getString(13);
                    String fina_mark = csr.getString(14);

                    //Set Assessment properties
                    assess = new AddingAssessment();
                    assess.setS_number(s_number);
                    assess.setModule(module);
                    assess.setTest1(test_1);
                    assess.setTest2(test_2);
                    assess.setTest3(test_3);
                    assess.setQz1(qz_1);
                    assess.setQz2(qz_2);
                    assess.setQz3(qz_3);
                    assess.setAssignment1(assignment_1);
                    assess.setAssignment2(assignment_2);
                    assess.setAssignment3(assignment_3);
                    assess.setCa_marks(ca_mark);
                    assess.setExam_marks(exam_mark);
                    assess.setFinal_marks(fina_mark);

                    //add to the collection
                    assessmentList.add(assess);
                }
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return assessmentList;
    }

    //adding record to the assessment table
    public boolean addAssessment(AddingAssessment item)
    {
        try {
            db = helper.getWritableDatabase();

            ContentValues values = new ContentValues();

            values.put(DbConstants.asSTUDEN_NUMBER,item.getS_number());
            values.put(DbConstants.asMODULE_CODE,item.getModule());
            values.put(DbConstants.asTEST_1,item.getTest1());
            values.put(DbConstants.asTEST_2,item.getTest2());
            values.put(DbConstants.asTEST_3,item.getTest3());
            values.put(DbConstants.asQZ_1,item.getQz1());
            values.put(DbConstants.asQZ_2,item.getQz2());
            values.put(DbConstants.asQZ_3,item.getQz3());
            values.put(DbConstants.asASSIGNMENT_1,item.getAssignment1());
            values.put(DbConstants.asASSIGNMENT_2,item.getAssignment2());
            values.put(DbConstants.asASSIGNMENT_3,item.getAssignment3());
            values.put(DbConstants.asCA_MARKS,item.getCa_marks());
            values.put(DbConstants.asEXAM_MARKS,item.getExam_marks());
            values.put(DbConstants.asFINAL_MARKS,item.getFinal_marks());

            long results = db.insert(DbConstants.Assessment_TB, DbConstants.asID, values);

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
}
