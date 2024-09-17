package com.example.Super.Admin.Controller;

import com.example.Super.Admin.Service.SuperuserService;
import com.example.Super.Admin.dao.Superuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superuser")
@CrossOrigin(maxAge = 3600)

public class SuperuserController {

    @Autowired
    SuperuserService superuserService;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public List<Superuser> getAllSuperuser() {
        return superuserService.getAllSuperUsers();
    }

    @GetMapping("/{id}")
    public Superuser getSuperuserById(@PathVariable Long id){
        return superuserService.getSuperuserById(id);
    }

    @PostMapping
    public Superuser createSuperuser(@RequestBody Superuser superuser){
        return superuserService.saveOrUpdateSuperuser(superuser);
    }

    @PutMapping("/{id}")
    public Superuser updateSuperuser(@PathVariable Long id, @RequestBody Superuser superuser) {

        Superuser existingSuperuser = superuserService.getSuperuserById(id);
        if (existingSuperuser != null) {
            existingSuperuser.setName(superuser.getName());
            existingSuperuser.setEmail(superuser.getEmail());
            existingSuperuser.setPassword(superuser.getPassword());

        } else {
            return null;
        }
        return existingSuperuser;
    }

    @DeleteMapping("/{id}")
    public void deleteSuperuser(@PathVariable Long id){
        superuserService.deleteSuperuser(id);
    }
}