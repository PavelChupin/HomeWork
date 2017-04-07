package ru.stqa.pft.homework.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;


@XStreamAlias("person") // Наименованеи обьектов в файле для вывода в Xml
@Entity //Привязка к базе данных
@Table(name = "addressbook") //Привязываем класс к конкретной таблице в базе
public class PersonData {

    @XStreamOmitField //Не сохранять поле в выходной форма XML
    @Id
    @Column(name = "id")  //Привязка к столбцу таблици
    private int id = Integer.MAX_VALUE;

    @Expose //Обозначить поля для вывода в формат json
    @Column(name = "firstname")  //Привязка к столбцу таблици
    private String firstname;
    //private String middlename;

    @Expose //Обозначить поля для вывода в формат json
    @Column(name = "lastname")  //Привязка к столбцу таблици
    private String lastname;

    @Column(name = "nickname")  //Привязка к столбцу таблици
    private String nickname;
    //private String title;
    //private String company;

    @Expose //Обозначить поля для вывода в формат json
    @Column(name = "address")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут в базе поле типа text
    private String address;

    @Column(name = "home")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут в базе поле типа text
    private String homephone;

    @Expose //Обозначить поля для вывода в формат json
    @Column(name = "mobile")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут в базе поле типа text
    private String mobilephone;

    @Column(name = "work")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут в базе поле типа text
    private String workphone;

    @Expose //Обозначить поля для вывода в формат json
    @Column(name = "email")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут в базе поле типа text
    private String email;

    @Column(name = "email2")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут в базе поле типа text
    private String email2;

    @Column(name = "email3")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут в базе поле типа text
    private String email3;

    //private String homepage;
    //private String byear;
    //private String ayear;
    //private String address2;

    @Column(name = "phone2")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа
    private String phone2;

    @Expose //Обозначить поля для вывода в формат json
    @Transient //Исключить поле из начитки из базы
    private String group;

    @Transient //Исключить поле из начитки из базы
    private String allEmail;

    @Transient //Исключить поле из начитки из базы
    private String allPhones;

    @Transient //Исключить поле из начитки из базы
    private String allPersonData;

    @Expose //Обозначить поля для вывода в формат json
    //@Column(name = "photo")  //Привязка к столбцу таблици
    //@Type(type = "text")
    //преобразование типа в стринг делаем в гетере и сеттере
    @Transient
    private String photo;


    public File getPhoto() {
        return new File(photo);
    }

    public PersonData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    public PersonData withAllPersonData(String allPersonData) {
        this.allPersonData = allPersonData;
        return this;
    }

    public PersonData withAllEmail(String allEmail) {
        this.allEmail = allEmail;
        return this;
    }

    public PersonData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public PersonData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public PersonData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public PersonData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
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

    public PersonData withHomephone(String homephone) {
        this.homephone = homephone;
        return this;
    }

    public PersonData withWorkphone(String workphone) {
        this.workphone = workphone;
        return this;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getPhone2() {
        return phone2;
    }

    public PersonData withPhone2(String phone2) {
        this.phone2 = phone2;
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

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail3() {
        return email3;
    }

    public String getEmail2() {
        return email2;
    }

    public String getAllEmail() {
        return allEmail;
    }

    public String getAllPersonData() {
        return allPersonData;
    }

    @Override
    public String toString() {
        return "PersonData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", nickname='" + nickname + '\'' +
                ", address='" + address + '\'' +
                ", homephone='" + homephone + '\'' +
                ", mobilephone='" + mobilephone + '\'' +
                ", workphone='" + workphone + '\'' +
                ", email='" + email + '\'' +
                ", email2='" + email2 + '\'' +
                ", email3='" + email3 + '\'' +
                ", phone2='" + phone2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonData that = (PersonData) o;

        if (id != that.id) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (homephone != null ? !homephone.equals(that.homephone) : that.homephone != null) return false;
        if (mobilephone != null ? !mobilephone.equals(that.mobilephone) : that.mobilephone != null) return false;
        if (workphone != null ? !workphone.equals(that.workphone) : that.workphone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;
        if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;
        return phone2 != null ? phone2.equals(that.phone2) : that.phone2 == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (homephone != null ? homephone.hashCode() : 0);
        result = 31 * result + (mobilephone != null ? mobilephone.hashCode() : 0);
        result = 31 * result + (workphone != null ? workphone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (email2 != null ? email2.hashCode() : 0);
        result = 31 * result + (email3 != null ? email3.hashCode() : 0);
        result = 31 * result + (phone2 != null ? phone2.hashCode() : 0);
        return result;
    }

}
