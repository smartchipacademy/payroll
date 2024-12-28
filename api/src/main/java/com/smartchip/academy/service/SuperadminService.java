package com.smartchip.academy.service;


import com.smartchip.academy.dao.Superadmin;
import com.smartchip.academy.repository.SuperadminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SuperadminService {

    @Autowired
    SuperadminRepository superadminRepository;


    public  List<Superadmin> getAllSuperadmin() {
        return superadminRepository.findAll();
    }

    public  Superadmin getSuperuseradminById(long id) {
        return superadminRepository.findById(id).orElse(null);
    }

    public  Superadmin saveOrUpdateSuperadmin(Superadmin superadmin) {
        return superadminRepository.save(superadmin);
    }

    public void deleteSuperadmin(Long id) {
        superadminRepository.deleteById(id);

    }
}
