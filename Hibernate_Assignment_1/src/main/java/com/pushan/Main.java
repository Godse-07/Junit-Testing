package com.pushan;

import com.pushan.DAO.EmployeeDAO;
import com.pushan.DAO.PerformanceReviewDAO;
import com.pushan.DAO.SalaryRecordDAO;
import com.pushan.DTO.EmployeeDTO;
import com.pushan.Entity.PerformanceReviewEntity;
import com.pushan.Entity.SalaryRecordEntity;

import java.time.LocalDate;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        EmployeeDAO e = new EmployeeDAO();
        SalaryRecordDAO s = new SalaryRecordDAO();
        PerformanceReviewDAO p = new PerformanceReviewDAO();

        // EmployeeInserted

        EmployeeDTO emp = new EmployeeDTO();

        emp.setEmployeeCode("EMP001");
        emp.setName("Pushan");
        emp.setEmail("pushan@gmail.com");
        emp.setDepartment("Engineering");
        emp.setDesignation("Software Developer");
        emp.setJoiningDate(LocalDate.now());
        emp.setActive(true);

        e.insert(emp);

        System.out.println("Employee inserted");

        // ===== FETCH EMPLOYEE BY ID =====
        EmployeeDTO employeeById = e.fetchByID(1);
        System.out.println("Employee by ID: " + employeeById.getName());


        // ===== FETCH BY EMPLOYEE CODE =====
        EmployeeDTO employeeByCode = e.fetchByEmployeeCode("EMP001");
        System.out.println("Employee by Code: " + employeeByCode.getName());


        // ===== UPDATE EMPLOYEE =====
        EmployeeDTO updatedEmployee = new EmployeeDTO();
        updatedEmployee.setName("Pushan Mukhopadhyay");
        updatedEmployee.setEmail("pushan.dev@gmail.com");
        updatedEmployee.setDepartment("Backend Engineering");
        updatedEmployee.setDesignation("Senior Developer");
        updatedEmployee.setJoiningDate(LocalDate.now());

        e.update("EMP001", updatedEmployee);

        System.out.println("Employee updated");


        // ===== FETCH ALL ACTIVE EMPLOYEES =====
        List<EmployeeDTO> activeEmployees = e.fetchAll();

        System.out.println("Active Employees:");

        for (EmployeeDTO e1 : activeEmployees) {
            System.out.println(e1.getName() + " - " + e1.getEmployeeCode());
        }


        // ===== SOFT DELETE =====
        e.delete("EMP001");
        System.out.println("Employee soft deleted");


        // ===== INSERT SALARY RECORD =====
        SalaryRecordEntity salary = new SalaryRecordEntity();

        salary.setEmployeeCode("EMP001");
        salary.setBaseSalary(50000);
        salary.setBonus(5000);
        salary.setTax(7000);
        salary.setSalaryMonth("2026-03");

        s.insertSalary(salary);

        System.out.println("Salary inserted");


        // ===== FETCH SALARY BY EMPLOYEE =====
        List<SalaryRecordEntity> salaries = s.getByEmployee("EMP001");

        for (SalaryRecordEntity s1 : salaries) {
            System.out.println("Net Salary: " + s1.getNetSalary());
        }


        // ===== INSERT PERFORMANCE REVIEW =====
        PerformanceReviewEntity review = new PerformanceReviewEntity();

        review.setEmployeeCode("EMP001");
        review.setRating(5);
        review.setReviewDate(LocalDate.now());
        review.setComments("Excellent performance");

        p.insertReview(review);

        System.out.println("Performance review added");


        // ===== FETCH REVIEWS =====
        PerformanceReviewEntity rev = p.getReviewById("EMP001");

        rev.toString();

    }
}
