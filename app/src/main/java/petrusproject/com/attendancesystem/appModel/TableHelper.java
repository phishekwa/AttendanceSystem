package petrusproject.com.attendancesystem.appModel;

import android.content.Context;

import java.util.ArrayList;

import petrusproject.com.attendancesystem.databaseModel.DbAdapter;

public class TableHelper {

    Context tableContext;

    //Table definition
    private String[] attendanceTableHeader = {"Student", "Module", "Date", "Attended"};

    private String[] assessmentTableHeader = {"Student", "Module", "Test 1", "Test 2", "Test 3",
            "Qz 1", "Qz 2", "Qz 3", "Assignment 1", "Assignment 2", "Assignment 3", "CA", "Exam Marks", "Final Marks"};

    private String[][] attendanceTableContent;
    private String[][] assessmentTableContent;


    public TableHelper(Context tableContext) {
        this.tableContext = tableContext;

    }

    public String[] getAssessmentTableHeader() {
        return assessmentTableHeader;
    }

    public String[][] getAssessmentTableContent() {

        ArrayList<AddingAssessment> theList = new DbAdapter(tableContext).retrieveAssessment();
        AddingAssessment assessment;

        assessmentTableContent = new String[theList.size()][14];

        for (int i = 0; i < theList.size(); i++){

            assessment = theList.get(i);

            assessmentTableContent[i][0] = assessment.getS_number();
            assessmentTableContent[i][1] = assessment.getModule();
            assessmentTableContent[i][2] = assessment.getTest1();
            assessmentTableContent[i][3] = assessment.getTest2();
            assessmentTableContent[i][4] = assessment.getTest3();
            assessmentTableContent[i][5] = assessment.getQz1();
            assessmentTableContent[i][6] = assessment.getQz2();
            assessmentTableContent[i][7] = assessment.getQz3();
            assessmentTableContent[i][8] = assessment.getAssignment1();
            assessmentTableContent[i][9] = assessment.getAssignment2();
            assessmentTableContent[i][10] = assessment.getAssignment3();
            assessmentTableContent[i][11] = assessment.getCa_marks();
            assessmentTableContent[i][12] = assessment.getExam_marks();
            assessmentTableContent[i][13] = assessment.getFinal_marks();
        }

        return assessmentTableContent;
    }

    public String[] getAttendanceTableHeader() {
        return attendanceTableHeader;
    }

    public String[][] getAttendanceTableContent() {

        ArrayList<AddingAttendance> aList = new DbAdapter(tableContext).retrieveAttendance();
        AddingAttendance aTask;

        attendanceTableContent = new String[aList.size()][4];

        for (int i = 0; i < aList.size(); i++){

            aTask = aList.get(i);

            attendanceTableContent[i][0] = aTask.getStudent_number();
            attendanceTableContent[i][1] = aTask.getModule();
            attendanceTableContent[i][2] = aTask.getTheDate();
            attendanceTableContent[i][3] = aTask.getAttended();
        }

        return attendanceTableContent;
    }
}
