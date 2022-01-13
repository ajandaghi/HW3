public class Staffs extends  Person{
    private String staffId;
    private String staffUser;
    private String staffPass;
    private Long salary;

    public Staffs(String fullName, String nationalCode, String birthdate, String address, String staffId, String staffUser, String staffPass, Long sallary) {
        super(fullName, nationalCode, birthdate, address);
        this.staffId = staffId;
        this.staffUser = staffUser;
        this.staffPass = staffPass;
        this.salary= sallary;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffUser() {
        return staffUser;
    }

    public void setStaffUser(String staffUser) {
        this.staffUser = staffUser;
    }

    public String getStaffPass() {
        return staffPass;
    }

    public void setStaffPass(String staffPass) {
        this.staffPass = staffPass;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
