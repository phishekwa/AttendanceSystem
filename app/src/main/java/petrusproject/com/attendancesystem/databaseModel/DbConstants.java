package petrusproject.com.attendancesystem.databaseModel;

public class DbConstants {

    //Defining the database and tables
    public static final String DATABASE_NAME = "StudentRecord.db";

    public static final String TABLE_1 = "Student";
    public static final String stuID = "ID";
    public static final String stuSTUDENT_NUMBER = "studentNumber";
    public static final String stuSTUDENT_NAME = "studentName";


    public static final String TABLE_2 = "Module";
    public static final String moID = "ID";
    public static final String moMODULE_CODE = "moduleCode";


    public static final String TABLE_3 = "Enrollment";
    public static final String enrID = "ID";
    public static final String enrSTUDEN_NUMBER = "studentNumber";
    public static final String enrMODULE_CODE = "moduleCode";


    public static final String TABLE_4 = "Assessment";
    public static final String asID = "ID";
    public static final String asSTUDEN_NUMBER = "studentNumber";
    public static final String asMODULE_CODE = "moduleCode";
    public static final String asTEST_1 = "test1";
    public static final String asTEST_2 = "test2";
    public static final String asTEST_3 = "test3";
    public static final String asQZ_1 = "qz1";
    public static final String asQZ_2 = "qz2";
    public static final String asQZ_3 = "qz3";
    public static final String asASSIGNMENT_1 = "assign1";
    public static final String asASSIGNMENT_2 = "assign2";
    public static final String asASSIGNMENT_3 = "assign3";
    public static final String asCA_MARKS = "caMarks";
    public static final String asEXAM_MARKS = "examMarks";
    public static final String asFINAL_MARKS = "finalMarks";

    public static final String TABLE_5 = "Attendance";
    public static final String attID = "ID";
    public static final String attSTUDEN_NUMBER = "studentNumber";
    public static final String attMODULE_CODE = "moduleCode";
    public static final String attDATE = "date";
    public static final String attSTATUS = "attended";

    //Defining the Student table
    static final String Student_TB = "CREATE TABLE " + TABLE_1 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, studentNumber INTEGER UNIQUE NOT NULL," +
            " studentName TEXT NOT NULL);";

    //Defining the Module table
    static final String Module_TB = "CREATE TABLE " + TABLE_2 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, moduleCode VARCHAR(10) UNIQUE NOT NULL);";

    //Defining the Enrollment table
    static final String Enrollment_TB = "CREATE TABLE " + TABLE_3 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, studentNumber INTEGER REFERENCES " +
            "" +TABLE_1+ "(studentNumber) NOT NULL, moduleCode VARCHAR(10) REFERENCES " +TABLE_2+ "(moduleCode) NOT NULL);";

    //Defining the Assessment table
    static final String Assessment_TB = "CREATE TABLE " + TABLE_4 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, studentNumber INTEGER REFERENCES "
            +TABLE_1+ "(studentNumber) NOT NULL, moduleCode VARCHAR(10) REFERENCES " +TABLE_2+ "(moduleCode) NOT NULL, " +
            "test1 FLOAT Default 0, test2 FLOAT Default 0,test3 FLOAT Default 0, assign1 FLOAT Default 0, assign2 FLOAT Default 0, " +
            "assign3 FLOAT Default 0, qz1 FLOAT Default 0, qz2 FLOAT Default 0, qz3 FLOAT Default 0,caMarks FLOAT Default 0, " +
            "examMarks FLOAT Default 0, finalMarks FLOAT Default 0);";

    //Defining the Attendance table
    static final String Attendance_TB = "CREATE TABLE " + TABLE_5 + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, studentNumber INTEGER NOT NULL, moduleCode VARCHAR(10) REFERENCES " +
            "" +TABLE_2+ "(moduleCode) NOT NULL, date DATE NOT NULL, attended TEXT Default 'No' );";

    //Drop tables if they already exist
    static final String Drop_student_TB = "Drop table if exists " + TABLE_1 ;
    static final String Drop_module_TB = "Drop table if exists " + TABLE_2 ;
    static final String Drop_Enrollment_TB = "Drop table if exists " + TABLE_3 ;
    static final String Drop_Assessment_TB = "Drop table if exists " + TABLE_4 ;
    static final String Drop_Attendance_TB = "Drop table if exists " + TABLE_5 ;

}