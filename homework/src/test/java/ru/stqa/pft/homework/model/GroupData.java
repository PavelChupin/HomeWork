package ru.stqa.pft.homework.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@XStreamAlias("group") // Наименованеи обьектов в файле для вывода в Xml
@Entity //Привязка к базе данных
@Table(name = "group_list") //Привязываем класс к конкретной таблице в базе
public class GroupData {

    @XStreamOmitField //Не сохранять поле в выходной форма
    @Id
    @Column(name = "group_id")  //Привязка к столбцу таблици
    private int id = Integer.MAX_VALUE;

    @Expose //Обозначить поля для вывода в формат json
    @Column(name = "group_name")  //Привязка к столбцу таблици
    //@Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут не нужно так как в базе данное поле определено явным типом varchar(255)
    private String name;

    @Expose //Обозначить поля для вывода в формат json
    @Column(name = "group_header")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут в базе поле типа text
    private String header;

    @Expose //Обозначить поля для вывода в формат json
    @Column(name = "group_footer")  //Привязка к столбцу таблици
    @Type(type = "text")//Добавляем описание типа для полей с неявными типами например тут в базе поле типа text
    private String footer;

    @ManyToMany(mappedBy = "groups")
    private Set<PersonData> persons = new HashSet<PersonData>();

    public String getName() {
        return name;
    }

    public Persons getPersons() {
        return new Persons(persons);
    }

    public void setPersons(Set<PersonData> persons) {
        this.persons = persons;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

    public int getId() {
        return id;
    }

    public GroupData withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupData groupData = (GroupData) o;

        if (id != groupData.id) return false;
        if (name != null ? !name.equals(groupData.name) : groupData.name != null) return false;
        if (header != null ? !header.equals(groupData.header) : groupData.header != null) return false;
        return footer != null ? footer.equals(groupData.footer) : groupData.footer == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (header != null ? header.hashCode() : 0);
        result = 31 * result + (footer != null ? footer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", header='" + header + '\'' +
                ", footer='" + footer + '\'' +
                '}';
    }

}
