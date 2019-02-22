package hr.josip.mydata.processing;

import java.util.Arrays;

public class PersonalId {
    private String identityCardNumber;
    private Date dateOfExpiry;
    private String surname;
    private String name;
    private char sex;
    private String citizenship;
    private Date dateOfBirth;
    private String residence;
    private String issuedBy;
    private Date dateOfIssue;
    private String personalIdentificationNumber;
    public static boolean errors=false;

    public char[] availableValues=new char[]{'F','f','M','m'};
    public PersonalId() {
    }

    public boolean checkSex(char sex){
        for (int count=0;count<availableValues.length;count++){
            if(sex==availableValues[count]){
                errors=false;
                break;
            }else{
                errors=true;
            }
        }
        return errors;
    }

    public PersonalId(String identityCardNumber, Date dateOfExpiry, String surname, String name, char sex, String citizenship, Date dateOfBirth, String residence, String issuedBy, Date dateOfIssue, String personalIdentificationNumber) {
        this.identityCardNumber = identityCardNumber;
        this.dateOfExpiry = dateOfExpiry;
        this.surname = surname;
        this.name = name;
        this.sex = sex;
        this.citizenship = citizenship;
        this.dateOfBirth = dateOfBirth;
        this.residence = residence;
        this.issuedBy = issuedBy;
        this.dateOfIssue = dateOfIssue;
        this.personalIdentificationNumber = personalIdentificationNumber;
    }
    //This function checks if the string is numeric integer
    public boolean parseString(String string){
        boolean isString=true;

            try {
                Long number=Long.parseLong(string);
            } catch (NumberFormatException e) {

                System.out.println("Error!!!! Enter only numeric value!!!");
                isString=false;

            }


        return isString;

    };

    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        ///check is input number is a number not letter
        //if it is letter  there are errors you cannot continue input
        //if they are all numbers continue to number of elements in string
        if(parseString(identityCardNumber)==true) {
            ;
            //if number of elements are less than 9
            //error it needs to be equal and more numbers written to file
            //if everything is alright set the value
            if (identityCardNumber.length() < 9) {
                System.out.println("Error!!! Identity card number must be greater then 9 ");
                this.identityCardNumber = "";
                errors = true;
            } else {
                this.identityCardNumber = identityCardNumber;
            }
        }else{
            System.out.println("Enter new number.");
            errors=true;
        }

    }

    public Date getDateOfExpiry() {
        return dateOfExpiry;
    }

    public void setDateOfExpiry(Date dateOfExpiry) {
        this.dateOfExpiry = dateOfExpiry;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname.length()>50) System.out.println("Exceeded max limit of 50");
        else this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length()>50) System.out.println("Exceeded max limit of 50");
        else this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        errors=checkSex(sex);
        if(errors==true){
            System.out.println("Error!!!Wrong sex entry!!!");
        }else{
            this.sex = sex;
        }

    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        if(citizenship.length()>20) System.out.println("Exceeded limit of 20");
        else this.citizenship = citizenship;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getResidence() {

        return residence;
    }

    public void setResidence(String residence) {
        if(residence.length()>100) System.out.println("Exceeded limit of 100");
        else this.residence = residence;

    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        if(issuedBy.length()>150) System.out.println("Exceeded limit of 150");
        else this.issuedBy = issuedBy;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public String getPersonalIdentificationNumber() {
        return personalIdentificationNumber;
    }

    public void setPersonalIdentificationNumber(String personalIdentificationNumber) {
        if(personalIdentificationNumber.length()<11) errors=true;
        else {
            if(checkStringValue(personalIdentificationNumber)==false){
                this.personalIdentificationNumber = personalIdentificationNumber;
            }else{
                System.out.println("Personal id number is not numeric!!!");
            }

        }

    }
    //function to check values if it is greather than integer values
    //convert strings to field of chars
    //then convert field of chars to integer values
    //add exception if letter is shown
    public boolean checkStringValue(String string){


            try {
                Long number=Long.parseLong(string);
            } catch (NumberFormatException e) {
                errors=true;
                System.out.println("This value is not numeric!!!");
            }

        return errors;
    }

    @Override
    public String toString() {
        return "PersonalId{" +
                "identityCardNumber='" + identityCardNumber + '\'' +
                ", dateOfExpiry=" + dateOfExpiry.getDate() +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", citizenship='" + citizenship + '\'' +
                ", dateOfBirth=" + dateOfBirth.getDate() +
                ", residence='" + residence + '\'' +
                ", issuedBy='" + issuedBy + '\'' +
                ", dateOfIssue=" + dateOfIssue.getDate() +
                ", personalIdentificationNumber='" + personalIdentificationNumber + '\'' +
                '}';
    }
}
