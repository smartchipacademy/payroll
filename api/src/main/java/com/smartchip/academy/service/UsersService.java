package com.smartchip.academy.service;



import com.smartchip.academy.dao.Users;
import com.smartchip.academy.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Users getUsersById(long id) {
        return usersRepository.findById(id).orElse(null);
    }

    public Users saveOrUpdataUsers(Users users) {
        return usersRepository.save(users);
    }

    public void deleteUsers(Long id) {
        usersRepository.deleteById(id);
    }

    public Users findUserId(String userId,String password ,String loginType) {
        System.out.println("userid in service " + userId);
        Users users = usersRepository.findByuserid(userId);
        System.out.println("user from db" + users);
        if (users != null) {
            if(users.getPassword().equals(password) && users.getUserid().equals(userId) && users.getLoginType().equals(loginType)) {
                return users;
            }
        }
        return null;
    }
}
