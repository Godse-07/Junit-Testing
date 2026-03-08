package com.JPA.employee_address_app.repository;

import com.JPA.employee_address_app.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findByAddressCity(String city);
    List<Employee> findByDateOfBirthAfter(LocalDate data);

    @Query("SELECT e FROM Employee e WHERE e.salary > :salary")
    List<Employee> findEmployeesWithHighSalary(@Param("salary") double salary);


    @Query("SELECT e FROM Employee e WHERE e.address.city = :city")
    List<Employee> findEmployeesByCity(@Param("city") String city);


    @Query("SELECT e FROM Employee e WHERE e.dateOfBirth > :date")
    List<Employee> findEmployeesBornAfter(@Param("date") LocalDate date);


    @Query("SELECT e.address.city, COUNT(e) FROM Employee e GROUP BY e.address.city")
    List<Object[]> countEmployeesByCity();
}
