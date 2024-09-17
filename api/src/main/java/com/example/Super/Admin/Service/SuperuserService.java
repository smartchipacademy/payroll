package com.example.Super.Admin.Service;

import com.example.Super.Admin.Repository.SuperuserRepository;
import com.example.Super.Admin.dao.Superuser;
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
