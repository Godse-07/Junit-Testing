package com.pushan.DAO;

import com.pushan.Config.HibernateUtil;
import com.pushan.DTO.EmployeeDTO;
import com.pushan.Entity.EmployeeEntity;
import com.pushan.Mapper.EmployeeMapper;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {


    private final EmployeeMapper emMapper = EmployeeMapper.INSTANCE;
    private final HibernateUtil hi = new HibernateUtil();

    // Insert employee
    public void insert(EmployeeDTO employeeDTO) {
        try {
            Session s = hi.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            EmployeeEntity en = emMapper.toEntity(employeeDTO);
            s.persist(en);
            tx.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Fetch by id
    public EmployeeDTO fetchByID(int code) {
        EmployeeDTO eDTO = null;
        try {
            Session s = hi.getSessionFactory().openSession();
            EmployeeEntity en = s.get(EmployeeEntity.class, code);
            eDTO = emMapper.toDTO(en);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eDTO;
    }

    // Fetch by employeeCode
    public EmployeeDTO fetchByEmployeeCode(String empCode) {
        EmployeeDTO eDTO = null;
        try {
            Session s = hi.getSessionFactory().openSession();
            EmployeeEntity en = s.createQuery("FROM EmployeeEntity WHERE employeeCode = :empCode", EmployeeEntity.class)
                    .setParameter("empCode", empCode)
                    .uniqueResult();
            eDTO = emMapper.toDTO(en);
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eDTO;
    }

    // Fetch all active employees
    public List<EmployeeDTO> fetchAll() {
        List<EmployeeDTO> ans = null;
        try {
            Session s = hi.getSessionFactory().openSession();
            List<EmployeeEntity> emList = s.createQuery(
                            "FROM EmployeeEntity e WHERE e.active = true",
                            EmployeeEntity.class)
                    .list();
            ans = emList.stream()
                    .map(emMapper::toDTO)
                    .toList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ans;
    }

    //  Update employee by employeeCode
    public void update(String empCode, EmployeeDTO employeeDTO) {
        try {
            Session s = hi.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();
            EmployeeEntity en = s.createQuery("FROM EmployeeEntity e where e.employeeCode = :code",
                    EmployeeEntity.class)
                    .setParameter("code", empCode)
                    .uniqueResult();
            if(en != null) {
                en.setName(employeeDTO.getName());
                en.setEmail(employeeDTO.getEmail());
                en.setDesignation(employeeDTO.getDesignation());
                en.setDepartment(employeeDTO.getDepartment());
                en.setJoiningDate(employeeDTO.getJoiningDate());
                en.setActive(employeeDTO.isActive());
            }
            s.merge(en);
            tx.commit();
            s.close();
            en.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Soft Delete
    public void delete(String code) {
        try {
            Session s = hi.getSessionFactory().openSession();
            Transaction tx = s.beginTransaction();

            EmployeeEntity en = s.createQuery(
                            "FROM EmployeeEntity e WHERE e.employeeCode = :code",
                            EmployeeEntity.class)
                    .setParameter("code", code)
                    .uniqueResult();

            if (en != null) {
                en.setActive(false);
                s.merge(en);
            }

            tx.commit();
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
