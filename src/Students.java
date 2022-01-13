public class Students extends Person {
    private String studentId;
    private String studentUser;
    private String studentPass;
    private CoursesList coursesList;


    public Students(String fullName, String nationalCode, String birthdate, String address, String studentId, String studentUser, String studentPass) {
        super(fullName, nationalCode, birthdate, address);
        this.studentId = studentId;
        this.studentUser = studentUser;
        this.studentPass = studentPass;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentUser() {
        return studentUser;
    }

    public void setStudentUser(String studentUser) {
        this.studentUser = studentUser;
    }

    public String getStudentPass() {
        return studentPass;
    }

    public void setStudentPass(String studentPass) {
        this.studentPass = studentPass;
    }



    public CoursesList getCoursesList() {
        return coursesList;
    }

    public void setCoursesList(CoursesList coursesList) {
        this.coursesList = coursesList;
    }

}
