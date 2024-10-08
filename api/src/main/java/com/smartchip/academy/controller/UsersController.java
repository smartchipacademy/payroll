package com.smartchip.academy.controller;



import com.smartchip.academy.dao.Users;
import com.smartchip.academy.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(maxAge = 3600)

public class UsersController {


    @Autowired
    UsersService usersService;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUsersById(@PathVariable Long id) {
        return usersService.getUsersById(id);
    }

    @PostMapping
    public Users createUsers(@RequestBody Users users) {
        System.out.println("UsersController.createUsers");
        System.out.println("users = "+ users);

        return usersService.saveOrUpdataUsers(users);
    }

    @PutMapping("/{id}")
    public Users updateUsers(@PathVariable Long id,@RequestBody Users users) {

        Users existingUsers = usersService.getUsersById(id);
        if (existingUsers !=null) {
            existingUsers.setUserid(users.getUserid());
            existingUsers.setName(users.getName());
            existingUsers.setMobilenumber(users.getMobilenumber());
            existingUsers.setEmail(users.getEmail());
            existingUsers.setPassword(users.getPassword());
            existingUsers.setRecentvideo(users.getRecentvideo());
            existingUsers.setLoginType(users.getLoginType());
            usersService.saveOrUpdataUsers(existingUsers);

        } else {
            return null;
        }
        return existingUsers;
    }

    @DeleteMapping("/{id}")
    public void deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
    }

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users user) {
        System.out.println("username = "+ user.getUserid());
        System.out.println("password = "+ user.getPassword());
        Users userfromdb = usersService.findUserId(user.getUserid(),user.getPassword(),user.getLoginType());
        if (userfromdb != null) {
            return ResponseEntity.ok(userfromdb);
        }
        return ResponseEntity.status(401).build();
    }

//    @PostMapping("/login")
//    public String login(@ModelAttribute("User") Users users ) {
//
//        User= usersService. (users.getUserid(), users.getPassword());
//
//        System.out.print(Users);
//        if(Objects.nonNull(Users)) {
//            return "redirect:/";
//
//        } else {
//            return "redirect/login";
//        }
//    }

//login
    //userid,passwd
    //select userid where userid =inputuserid and password =inputpassword
}
