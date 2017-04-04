package ru.stqa.pft.homework.tests_addressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;

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
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?serverTimezone=UTC&user=root&password=");

            //Выполняем обращение к базе
            Statement st = conn.createStatement();
            //Получим список строк из базы
            ResultSet rs = st.executeQuery("select group_id,group_name,group_header,group_footer from group_list");
            //Сохраним строки в коллекцию
            Groups groups = new Groups();
            while (rs.next()) {
                groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name"))
                        .withFooter(rs.getString("group_header")).withHeader(rs.getString("group_footer")));
            }
            //Закрыть подключение к базе
            rs.close();
            st.close();
            conn.close();
            System.out.println(groups);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

    }
}
