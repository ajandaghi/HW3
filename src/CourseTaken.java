public class CourseTaken {
    private String  courseId;
    private String studentId;
    private String profId;
    private double score;

    public CourseTaken(String courseId, String studentId, String profId) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.profId = profId;
        score=-1;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        if(score<0 || score>20) {
            System.out.println("score must be between 0 and 20");
            return;
        }
        this.score = score;
    }
}
