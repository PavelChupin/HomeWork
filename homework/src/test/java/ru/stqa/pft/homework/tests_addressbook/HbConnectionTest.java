package ru.stqa.pft.homework.tests_addressbook;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.PersonData;

import java.util.List;

import java.security.PublicKey;

/**
 * Created by Summoner on 03.04.2017.
 */

//Тест через hibernate
public class HbConnectionTest {
    private SessionFactory sessionFactory;

    //Предобработка чтения файла конфигурации hibernate.cfg.xml подключения к базе и т.д.
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

    //Тест подключения к базе для GroupData
    //В конфигурационном файле указать маппинг <mapping class="ru.stqa.pft.homework.model.GroupData"/>
    @Test(enabled = true)
    public void testHbConnecGroup(){
        //Чтение данных из базы
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Запрос к базе
        List<GroupData> result = session.createQuery( "from GroupData" ).list();
        for (GroupData group : result) {
            System.out.println(group);
        }
        session.getTransaction().commit();
        //Закроем соединение
        session.close();
    }

    //Тест подключения к базе для PersonData
    //В конфигурационном файле указать маппинг <mapping class="ru.stqa.pft.homework.model.PersonData"/>
    @Test(enabled = true)
    public void testHbConnecPerson(){
        //Чтение данных из базы
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Запрос к базе. Извлекаем из базы только не удаленные контакты deprecated = '0000-00-00'
        List<PersonData> result = session.createQuery( "from PersonData where deprecated = '0000-00-00'" ).list();

        session.getTransaction().commit();
        //Закроем соединение
        session.close();
        for (PersonData person : result) {
            System.out.println(person);
            System.out.println(person.getGroups());
        }
    }
}
