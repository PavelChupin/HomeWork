package ru.stqa.pft.homework.model;

public class PersonData {
    private int id = Integer.MAX_VALUE;
    private String firstname;
    //private String middlename;
    private String lastname;
    private String nickname;
    //private String title;
    //private String company;
    private String address;
    //private String home;
    private String mobilephone;
    private String email;
    //private String email2;
    //private String email3;
    //private String homepage;
    //private String byear;
    //private String ayear;
    //private String address2;
    //private String phone2;
    private String group;

    public PersonData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonData that = (PersonData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public PersonData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public PersonData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public PersonData withAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonData withMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
        return this;
    }

    public PersonData withEmail(String email) {
        this.email = email;
        return this;
    }

    public PersonData withId(int id) {
        this.id = id;
        return this;
    }

    public PersonData withGroup(String group) {
        this.group = group;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getAddress() {
        return address;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }

}
