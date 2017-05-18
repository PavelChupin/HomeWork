package ru.stqa.pft.mantis.model;

/**
 * Created by Summoner on 18.05.2017.
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Summoner on 18.05.2017.
 */
@Entity //Привязка к базе данных
@Table(name = "mantis_user_table") //Привязываем класс к конкретной таблице в базе
public class User {
    @Column(name = "id")  //Привязка к столбцу таблици
    private int id;

    @Column(name = "username")  //Привязка к столбцу таблици
    private String username;

    @Column(name = "email")  //Привязка к столбцу таблици
    private String email;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public User withId(int id) {
        this.id = id;
        return this;
    }

    public User withUsername(String username) {
        this.username = username;
        return this;
    }

    public User withEmail(String email) {
        this.email = email;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

}

