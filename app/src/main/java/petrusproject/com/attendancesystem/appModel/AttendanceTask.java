package petrusproject.com.attendancesystem.appModel;

public class AttendanceTask {

    //declare variables
    private String module, theDate, attended;
    private String student_number;

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public void setTheDate(String theDate) {
        this.theDate = theDate;
    }

    public void setAttended(String attended) {
        this.attended = attended;
    }

    public String getStudent_number() {
        return student_number;
    }

    public String getModule() {
        return module;
    }

    public String getTheDate() {
        return theDate;
    }

    public String getAttended() {
        return attended;
    }
}
