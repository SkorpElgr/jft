//package ru.stqa.pft.web.appmanager;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import ru.stqa.pft.web.model.ContactData;
//import ru.stqa.pft.web.model.Contacts;
//import ru.stqa.pft.web.model.GroupData;
//import ru.stqa.pft.web.model.Groups;
//
//import java.util.List;
//
//
//public class DbHelper {
//
//    private final SessionFactory sessionFactory;
//
//    public DbHelper() {
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
//    }
//
//    public Groups groups() {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        List<GroupData> resultGroups = session.createQuery("from GroupData where deprecated = '0000-00-00'").list();
//        // List<GroupData> resultGroups = session.createQuery("from GroupData").list();
//        session.getTransaction().commit();
//        session.close();
//        return new Groups(resultGroups);
//    }
//
//    public Contacts contacts() {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        //List<ContactData> resultContacts = session.createQuery("from ContactData").list();
//        List<ContactData> resultContacts = session.createQuery("from ContactData  where deprecated = '0000-00-00'").list();
//        session.getTransaction().commit();
//        session.close();
//        return new Contacts(resultContacts);
//    }
//}
