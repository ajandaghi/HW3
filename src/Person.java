public class Person {
    private String fullName;
    private String nationalCode;
    private String birthdate;
    private String address;

    public Person(String fullName, String nationalCode, String birthdate, String address) {
        this.fullName = fullName;
        this.nationalCode = nationalCode;
        this.birthdate = birthdate;
        this.address = address;
    }

    public Person() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
