package com.smartchip.academy.repository;


import com.smartchip.academy.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}

