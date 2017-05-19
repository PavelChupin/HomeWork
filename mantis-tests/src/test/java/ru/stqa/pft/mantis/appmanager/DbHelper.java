package ru.stqa.pft.mantis.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.mantis.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Summoner on 05.04.2017.
 */
public class DbHelper {

    private SessionFactory sessionFactory;
    private final ApplicationManager app;

    public DbHelper(ApplicationManager app, String typeConnecnion){
        this.app = app;
        if (typeConnecnion.equals("HIBERNATE")) {
            // A SessionFactory is set up once for an application!
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                    .configure() // configures settings from hibernate.cfg.xml
                    .build();
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        }
    }

    public List<User> usersHibernate() {
        //Чтение данных из базы
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Запрос к базе
        List<User> result = session.createQuery( "from mantis_user_table" ).list();
        session.getTransaction().commit();
        //Закроем соединение
        session.close();
        return result;
    }

    //Не завелся метод через HIBERNATE, используем обычный JDBC
    public List<User> usersJDBC() {
        //Установим коннект с базой данных
        Connection conn = null;
        try {
            //Указываем адрес базы данных
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bugtracker?serverTimezone=UTC&user=root&password=");

            //Выполняем обращение к базе
            Statement st = conn.createStatement();
            //Получим список строк из базы
            ResultSet rs = st.executeQuery("select id,username,email from mantis_user_table where username != 'administrator'");
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
            return users;
            //System.out.println(users);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return null;
        }
    }

}

