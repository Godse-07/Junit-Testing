package com.pushan.DAO;

import com.pushan.Config.HibernateUtil;
import com.pushan.Entity.SalaryRecordEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SalaryRecordDAO {

    private final HibernateUtil h1 = new HibernateUtil();


    // insert salary
    public void insertSalary(SalaryRecordEntity salary) {
        try {
            Session s = h1.getSessionFactory().openSession();
            Transaction x = s.beginTransaction();
            salary.calculateNetSalary();
            s.persist(salary);
            x.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Update salary
    public void update(SalaryRecordEntity salary) {
        try {
            salary.calculateNetSalary();
            Session s = h1.getSessionFactory().openSession();
            Transaction x = s.beginTransaction();
            s.merge(salary);
            x.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Delete Salary
    public void delete(int id) {
        try {
            Session s = h1.getSessionFactory().openSession();
            Transaction x = s.beginTransaction();
            SalaryRecordEntity salary = s.get(SalaryRecordEntity.class, id);
            if (salary != null) {
                s.remove(salary);
                x.commit();
            }
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch by employeeCode
    public List<SalaryRecordEntity> getByEmployee(String code) {

        Session session = h1.getSessionFactory().openSession();

        List<SalaryRecordEntity> salaries = session.createQuery(
                        "FROM SalaryRecordEntity s WHERE s.employeeCode = :code",
                        SalaryRecordEntity.class)
                .setParameter("code", code)
                .list();

        session.close();

        return salaries;
    }

    // Fetch by employeeCode and month
    public SalaryRecordEntity getByEmployeeCodeAndMonth(String code, String month) {
        SalaryRecordEntity salary = null;
        try {
            Session s = h1.getSessionFactory().openSession();
            salary = s.createQuery("FROM SalaryRecordEntity s WHERE s.employeeCode = :code AND s.salaryMonth = :month", SalaryRecordEntity.class)
                    .setParameter("code", code)
                    .setParameter("month", month)
                    .uniqueResult();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salary;
    }
}
