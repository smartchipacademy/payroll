package com.smartchip.academy.repository;


 import com.smartchip.academy.dao.Salary;
 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;


 @Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {

 }


