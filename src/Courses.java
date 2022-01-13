public class Courses {
    private String courseName;
    private String courseId;
    private String profId;
    private int courseUnit;
    private String term;

    public Courses(String courseName, String courseId, String profId, int courseUnit, String term) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.profId = profId;
        this.courseUnit = courseUnit;
        this.term = term;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public int getCourseUnit() {
        return courseUnit;
    }

    public void setCourseUnit(int courseUnit) {
        this.courseUnit = courseUnit;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }
}
