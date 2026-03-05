package com.pushan.OneToOne.Bidirectional.DAO;

import com.pushan.Config.HibernateUtil;
import com.pushan.OneToOne.Bidirectional.Entity.PassportBI;
import com.pushan.OneToOne.Bidirectional.Entity.UsersBI;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BiDAO {
    private final HibernateUtil hi = new HibernateUtil();

    public void insert(UsersBI user, PassportBI pass) {
        Session s = hi.getSession().openSession();
        Transaction tx = s.beginTransaction();
        user.setPassport(pass);
        pass.setUser(user);

        s.persist(pass);
        tx.commit();
        s.close();
        System.out.println("Inserted successfully");
    }

    public List<UsersBI> getAllList() {
        Session s = hi.getSession().openSession();
        List<UsersBI> list = s.createQuery("from UsersBI", UsersBI.class).getResultList();
        s.close();
        return list;
    }
}
