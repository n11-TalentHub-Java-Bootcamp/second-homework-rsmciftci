package com.bahadirmemis.springboot.converter;

import com.bahadirmemis.springboot.dto.UserDto;
import com.bahadirmemis.springboot.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-12-21T21:35:40+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.13 (Ubuntu)"
)
public class UserConverterImpl implements UserConverter {

    @Override
    public List<UserDto> convertAllUsersListToUserDtoList(List<User> userList) {
        if ( userList == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( userList.size() );
        for ( User user : userList ) {
            list.add( converUserToUserDto( user ) );
        }

        return list;
    }

    @Override
    public UserDto converUserToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setName( user.getName() );
        userDto.setSurname( user.getSurname() );
        userDto.setPhoneNumber( user.getPhoneNumber() );
        userDto.setEmail( user.getEmail() );
        userDto.setUserName( user.getUserName() );

        return userDto;
    }

    @Override
    public User convertUserDtoToUser(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDto.getId() );
        user.setName( userDto.getName() );
        user.setSurname( userDto.getSurname() );
        user.setEmail( userDto.getEmail() );
        user.setPhoneNumber( userDto.getPhoneNumber() );
        user.setUserName( userDto.getUserName() );

        return user;
    }
}
