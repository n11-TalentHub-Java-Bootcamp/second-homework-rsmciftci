package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.dao.UserDao;
import com.bahadirmemis.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() { return (List<User>) userDao.findAll(); }
    public User findUserByUserName(String username){
        return userDao.findUserByUserName(username);
    }

    public User save(User user){
        return userDao.save(user);
    }

    public User findUserByUserPhoneNumber(String phoneNumber){
        return userDao.findUserByPhoneNumber(phoneNumber);
    }
    @Transactional
    public void deleteUserByUserNameAndPhoneNumber(String username, String phoneNumber){
          userDao.deleteUserByUserNameAndPhoneNumber(username,phoneNumber);
    }
    public boolean isMatch(String username, String phoneNumber){
        return userDao.existsByUserNameAndPhoneNumber(username,phoneNumber);

    }

    public  User findUserById(Long userId){
        return userDao.findUserById(userId);
    }
    public boolean existsByIdOrUserNameOrEmail(Long userId,String username, String email){
        return  userDao.existsByIdOrUserNameOrEmail( userId, username,  email);
    }

}