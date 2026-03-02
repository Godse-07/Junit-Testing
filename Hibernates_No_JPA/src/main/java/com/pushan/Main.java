package com.pushan;

import com.pushan.Entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static SessionFactory factory;

    // https://chatgpt.com/share/69a55673-f5f8-800f-8f97-bd6576252f97


    static void main() {
        factory = new Configuration() // Configuration object is used to configure Hibernate and build the SessionFactory
                .configure()
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
//        createUser("Pushan", "Pushan@gmail.com");
//        List<String> users = getAllUsers();
//        users.forEach(System.out::println);
//        updateUser(1, "Pushan Mukhopadhyay");
//        users = getAllUsers();
//        users.forEach(System.out::println);
//        deleteUser(1);
//        getAllUsers();


        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("User " + i);
            user.setEmail("user" + i + "@example.com");
            users.add(user);
        }

        saveUsers(users);

        factory.close();

    }

    // create
    public static void createUser(String name, String email) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        session.persist(user);
        tx.commit();;
        session.close();
    }

    // read
    public static List<String> getAllUsers() {
        Session session = factory.openSession();
        List<User> users = session.createQuery("from User ", User.class).list();
        List<String> ans = users.stream().map(User::toString).toList();
        session.close();
        return ans;
    }

    // update
    public static void updateUser(int id, String newName) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, id);
        if (user != null) {
            user.setName(newName);
            session.merge(user);
        }
        tx.commit();
        session.close();
    }

    // delete
    public static void deleteUser(int id) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        User user = session.get(User.class, id);
        session.remove(user);
        tx.commit();
        session.close();
    }

    // save list of student
    public static void saveUsers(List<User> users) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        for (User user : users) {
            session.persist(user);
        }
        tx.commit();
        session.close();
        System.out.println("Users saved successfully");
    }

}
