package com.pushan.Config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory session = new Configuration()
            .configure()
            .buildSessionFactory();

    public SessionFactory getSession() {
        return session;
    }
}
