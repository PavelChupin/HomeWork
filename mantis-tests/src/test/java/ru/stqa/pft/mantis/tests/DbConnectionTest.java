package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.mantis.model.User;


import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 * Created by Summoner on 03.04.2017.
 */
//Тест через jdbc драйвер
public class DbConnectionTest {
    @Test
    public void testConnectionDB() {
        //Установим коннект с базой данных
        Connection conn = null;
        try {
            //Указываем адрес базы данных
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC&user=root&password=");

            //Выполняем обращение к базе
            Statement st = conn.createStatement();
            //Получим список строк из базы
            ResultSet rs = st.executeQuery("select id,username,email from mantis_user_table");
            //Сохраним строки в коллекцию
            List<User> users = new ArrayList<User>();
            while (rs.next()) {
                users.add(new User().withId(rs.getInt("id"))
                        .withUsername(rs.getString("username")).withEmail(rs.getString("email")));
            }
            //Закрыть подключение к базе
            rs.close();
            st.close();
            conn.close();
            System.out.println(users);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}
