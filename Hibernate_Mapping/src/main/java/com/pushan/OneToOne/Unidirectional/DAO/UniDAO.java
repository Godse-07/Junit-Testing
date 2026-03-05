package com.pushan.OneToOne.Unidirectional.DAO;

import com.pushan.Config.HibernateUtil;
import com.pushan.OneToOne.Unidirectional.Entity.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UniDAO {
    private final HibernateUtil hi = new HibernateUtil();

    public UniDAO() {

    }

    public void save(Users user) {
        Session s = hi.getSession().openSession();
        Transaction tx = s.beginTransaction();
        s.save(user);
        tx.commit();
        s.close();
        System.out.println("One to One Unidirectional saved successfully!");
    }
}
