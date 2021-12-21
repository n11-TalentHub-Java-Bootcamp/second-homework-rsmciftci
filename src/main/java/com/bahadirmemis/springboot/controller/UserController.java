package com.bahadirmemis.springboot.controller;


import com.bahadirmemis.springboot.converter.UserConverter;
import com.bahadirmemis.springboot.dto.UserDto;
import com.bahadirmemis.springboot.entity.User;
import com.bahadirmemis.springboot.exception.UserIdOrUsernameOrEmailAlreadySavedException;
import com.bahadirmemis.springboot.exception.UserNameAndPhoneNumberNotMatchException;
import com.bahadirmemis.springboot.service.entityservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users/")
public class UserController {


    @Autowired
    private UserService userService;

    // (2.1)
    @GetMapping("")
    public List<UserDto> findAll(){
        List<User> userList = userService.findAll();
        List<UserDto> userDtoList = UserConverter.INSTANCE.convertAllUsersListToUserDtoList(userList);
        return userDtoList;

    }

    // (2.4)
    // Before saving User to DB, saveUser method checks if username, email, or id is already saved to db.
    // If posted id is already saved in db, it would update the user with the postted id if it wasn't controlled
    // Identical email address or username should be taken by more than one user.
    // Phone number is not checked, it's something relative.
    @PostMapping("")
    public UserDto saveUser(@RequestBody UserDto userDto){

        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);

        Long userId = user.getId();
        String username = user.getUserName();
        String email = user.getEmail();

        boolean existsByIdOrUserNameOrEmail = userService.existsByIdOrUserNameOrEmail(userId,username,email);

        if(existsByIdOrUserNameOrEmail){
            throw new UserIdOrUsernameOrEmailAlreadySavedException("UserId or Username or Email is already saved in database!");
        }else{
            user = userService.save(user);
        }
        return userDto;
    }

    // (2.6)
    @PutMapping("")
    public UserDto updateUserById(@RequestBody UserDto userDto){
        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);
        userService.save(user);
        return userDto;
    }

    // (2.5)
    // Before deleting User, it checks if username and phoneNumeber matches
    // if it doesn't, method throws an exception.
    @DeleteMapping(value = "userName/{userName}/phoneNumber/{phoneNumber}")
    public void deleteUser(@PathVariable("userName") String userName,@PathVariable("phoneNumber") String phoneNumber){

        User user = new User();
        user.setUserName(userName);
        user.setPhoneNumber(phoneNumber);

        boolean isMatch = userService.isMatch(user.getUserName(),user.getPhoneNumber());

        if(isMatch){
            userService.deleteUserByUserNameAndPhoneNumber(user.getUserName(),user.getPhoneNumber());
        }else{
            throw new UserNameAndPhoneNumberNotMatchException(user.getUserName() + " username didn't match with " + user.getPhoneNumber() + " phone number.");
        }
    }

    // (2.2)
    @GetMapping("username/{username}")
    public UserDto findUserByUserName(@PathVariable String username){
        User user = userService.findUserByUserName(username);
        UserDto userDto = UserConverter.INSTANCE.converUserToUserDto(user);
        return userDto;
    }

    // (2.3)
    @GetMapping("phoneNumber/{phoneNumber}")
    public UserDto findUserByPhoneNumber(@PathVariable String phoneNumber){
        User user = userService.findUserByUserPhoneNumber(phoneNumber);
        UserDto userDto = UserConverter.INSTANCE.converUserToUserDto(user);
        return userDto;
    }


}
