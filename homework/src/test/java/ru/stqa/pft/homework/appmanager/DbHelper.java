package ru.stqa.pft.homework.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.homework.model.GroupData;
import ru.stqa.pft.homework.model.Groups;
import ru.stqa.pft.homework.model.PersonData;
import ru.stqa.pft.homework.model.Persons;

import java.util.List;

/**
 * Created by Summoner on 05.04.2017.
 */
public class DbHelper {

    private final SessionFactory sessionFactory;

    public DbHelper(){
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }

    public Groups groups(){
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
        return new Groups(result);
    }

    public Persons persons(){
        //Чтение данных из базы
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //Запрос к базе. Извлекаем из базы только не удаленные контакты deprecated = '0000-00-00'
        List<PersonData> result = session.createQuery( "from PersonData where deprecated = '0000-00-00'" ).list();
        for (PersonData person : result) {
            System.out.println(person);
        }
        session.getTransaction().commit();
        //Закроем соединение
        session.close();
        return new Persons(result);
    }
}

