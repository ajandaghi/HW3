public class Professors extends Person{
    private String profId;
    private String profUser;
    private String profPass;
    private String profType;  //p:PartTime     f:FullTime

    public Professors(String fullName, String nationalCode, String birthdate, String address, String profId, String profUser, String profPass, String profType) {
        super(fullName, nationalCode, birthdate, address);
        this.profId = profId;
        this.profUser = profUser;
        this.profPass = profPass;
        this.profType=profType;

    }

    public String getProfId() {
        return profId;
    }

    public void setProfId(String profId) {
        this.profId = profId;
    }

    public String getProfUser() {
        return profUser;
    }

    public void setProfUser(String profUser) {
        this.profUser = profUser;
    }

    public String getProfPass() {
        return profPass;
    }

    public void setProfPass(String profPass) {
        this.profPass = profPass;
    }

    public String getProfType() {
        return profType;
    }

    public void setProfType(String profType) {
        this.profType = profType;
    }
}
