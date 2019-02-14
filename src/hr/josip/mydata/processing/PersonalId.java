package hr.josip.mydata.processing;

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

    public PersonalId() {
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



    public String getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(String identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
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
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
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
        this.residence = residence;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
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
        this.personalIdentificationNumber = personalIdentificationNumber;
    }

    @Override
    public  String toString() {
        return "Osobna{" +
                "identityCardNumber=" + identityCardNumber +
                ", dateOfExpiry=" + dateOfExpiry.getDate() +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", citizenship='" + citizenship + '\'' +
                ", dateOfBirth=" + dateOfBirth.getDate() +
                ", residence='" + residence + '\'' +
                ", issuedBy='" + issuedBy + '\'' +
                ", dateOfIssue=" + dateOfIssue.getDate() +
                ", personalIdentificationNumber=" + personalIdentificationNumber +
                '}';
    }

}
