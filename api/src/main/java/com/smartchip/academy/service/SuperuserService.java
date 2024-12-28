package com.smartchip.academy.service;


import com.smartchip.academy.dao.Superuser;
import com.smartchip.academy.repository.SuperuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SuperuserService {
    @Autowired
    SuperuserRepository superuserRepository;

    public List<Superuser> getAllSuperUsers() {
        return superuserRepository.findAll();
    }

    public  Superuser getSuperuserById(long id) {
        return superuserRepository.findById(id).orElse(null);
    }

    public Superuser saveOrUpdateSuperuser(Superuser superuser) {
        return superuserRepository.save(superuser);
    }

    public void deleteSuperuser(Long id) {
        superuserRepository.deleteById(id);
    }
}
