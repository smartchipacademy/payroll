package com.example.Super.Admin.Controller;

import com.example.Super.Admin.Service.SuperadminService;
import com.example.Super.Admin.dao.Superadmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superadmin")
@CrossOrigin(maxAge = 3600)

public class superadminController {

    @Autowired
    SuperadminService superadminService;


    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public List<Superadmin> getAllSuperadmin(){
        return superadminService.getAllSuperadmin();
    }

    @GetMapping("/{id}")
    public Superadmin getSuperadminById(@PathVariable Long id){
        return superadminService.getSuperuseradminById(id);
    }

    @PostMapping
    public Superadmin createSuperadmin(@RequestBody Superadmin superadmin){
        System.out.println("superadminController.createSuperadmin");
        System.out.println("superadmin = " + superadmin);
        return superadminService.saveOrUpdateSuperadmin(superadmin);
    }

    @PutMapping("/{id}")
    public Superadmin updateSuperadmin(@PathVariable Long id, @RequestBody Superadmin superadmin) {

        Superadmin existingSuperadmin = superadminService.getSuperuseradminById(id);
        if (existingSuperadmin != null) {
            existingSuperadmin.setName(superadmin.getName());
            existingSuperadmin.setEmail(superadmin.getEmail());
            existingSuperadmin.setPassword(superadmin.getPassword());
            superadminService.saveOrUpdateSuperadmin(existingSuperadmin);


        } else {
            return null;
        }
        return existingSuperadmin;
    }

    @DeleteMapping("/{id}")
    public void deleteSuperadmin(@PathVariable Long id){
        superadminService.deleteSuperadmin(id);
    }
}

