package ru.stqa.pft.homework.tests_addressbook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;

import java.util.List;

import java.security.PublicKey;

/**
 * Created by Summoner on 03.04.2017.
 */
public class HbConnectionTest {
    private SessionFactory sessionFactory;

    //Предобработка чтения файла конфигурации подключения к базе и т.д.
    @BeforeClass
    protected void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            e.printStackTrace();
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

    @Test
    public void testHbConnection(){
        //Чтение данных из базы
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Запрос к базе
        List<GroupData> result = session.createQuery( "from GroupData" ).list();
        for (GroupData group : result) {
            System.out.println(group);
        }
        session.getTransaction().commit();
        session.close();
    }
}
