package com.smartchip.academy.service;


import com.smartchip.academy.dao.Salary;
import com.smartchip.academy.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;


    public List<Salary> getAllSalaries()

    {
        return salaryRepository.findAll();
    }

    public Salary getSalaryById(long id)
    {
        return salaryRepository.findById(id).orElse(null);
    }

    public Salary saveOrUpdateSalary(Salary salary)
    {
        return salaryRepository.save(salary);
    }


    public void deleteSalary(Long id){
        salaryRepository.deleteById(id);
    }


}
