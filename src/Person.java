import exceptions.NotValidNationalId;

public class Person {
    private String fullName;
    private String nationalCode;
    private String birthdate;
    private String address;

    public Person(String fullName, String nationalCode, String birthdate, String address) {
        try {
            checkNationalId(nationalCode);
        }
        catch (NotValidNationalId e){
            e.printStackTrace();
        }
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
        try {
            checkNationalId(nationalCode);
            this.nationalCode = nationalCode;

        }
        catch (NotValidNationalId e){
            e.printStackTrace();
        }

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

    public void checkNationalId(String nationalId){
        if(nationalId.length()!=10){
            throw new NotValidNationalId("national ID must have 10 length");
        }
        for (int i=0;i<nationalId.toCharArray().length;i++){
            if(!Character.isDigit(nationalId.toCharArray()[i])){
                throw new NotValidNationalId("national Id must have only digit.");
            }
        }
    }
}
