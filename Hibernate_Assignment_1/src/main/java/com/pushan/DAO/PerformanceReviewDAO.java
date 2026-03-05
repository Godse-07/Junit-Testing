package com.pushan.DAO;

import com.pushan.Config.HibernateUtil;
import com.pushan.Entity.PerformanceReviewEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PerformanceReviewDAO {
    private final HibernateUtil hi = new HibernateUtil();

    // Insert review
    public void insertReview(PerformanceReviewEntity per) {
        try {
            Session s = hi.getSessionFactory().openSession();
            Transaction x = s.beginTransaction();
            s.persist(per);
            x.commit();
            s.close();
            System.out.println("Performance review inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update review
    public void update(PerformanceReviewEntity per) {
        try {
            Session s = hi.getSessionFactory().openSession();
            Transaction x = s.beginTransaction();
            s.merge(per);
            x.commit();
            s.close();
            System.out.println("Performance review updated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete review
    public void delete(int id) {
        try {
            Session s = hi.getSessionFactory().openSession();
            Transaction x = s.beginTransaction();
            PerformanceReviewEntity per = s.get(PerformanceReviewEntity.class, id);
            if (per != null) {
                s.remove(per);
                x.commit();
                System.out.println("Performance review deleted successfully.");
            } else {
                System.out.println("Performance review with ID " + id + " not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch review by ID
    public PerformanceReviewEntity getReviewById(String code) {

        PerformanceReviewEntity per = null;

        try {
            Session s = hi.getSessionFactory().openSession();

            per = s.createQuery(
                            "FROM PerformanceReviewEntity p WHERE p.employeeCode = :code",
                            PerformanceReviewEntity.class)
                    .setParameter("code", code)
                    .uniqueResult();

            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return per;
    }
}
