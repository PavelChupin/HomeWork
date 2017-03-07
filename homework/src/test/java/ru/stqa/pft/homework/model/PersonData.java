package ru.stqa.pft.homework.model;

public class PersonData {
    private int id;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String mobilephone;
    private final String email;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String byear;
    private final String ayear;
    private final String address2;
    private final String phone2;
    private String group;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonData that = (PersonData) o;

        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public PersonData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String home, String mobilephone, String email, String email2, String email3, String homepage, String byear, String ayear, String address2, String phone2, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobilephone = mobilephone;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.byear = byear;
        this.ayear = ayear;
        this.address2 = address2;
        this.phone2 = phone2;
        this.group = group;
    }

    public PersonData(int id, String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String home, String mobilephone, String email, String email2, String email3, String homepage, String byear, String ayear, String address2, String phone2, String group) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = null;
        this.lastname = lastname;
        this.nickname = null;
        this.title = null;
        this.company = null;
        this.address = null;
        this.home = null;
        this.mobilephone = null;
        this.email = null;
        this.email2 = null;
        this.email3 = null;
        this.homepage = null;
        this.byear = null;
        this.ayear = null;
        this.address2 = null;
        this.phone2 = null;
        this.group = null;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getByear() {
        return byear;
    }

    public String getAyear() {
        return ayear;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
