package com.bahadirmemis.springboot.converter;


import com.bahadirmemis.springboot.dto.CategoryDto;
import com.bahadirmemis.springboot.dto.UserDto;
import com.bahadirmemis.springboot.entity.Category;
import com.bahadirmemis.springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);


    @Mapping(target = "id", source = "id")
    List<UserDto> convertAllUsersListToUserDtoList(List<User> userList);

    @Mapping(target = "id", source = "id")
    UserDto converUserToUserDto(User user);


    User convertUserDtoToUser(UserDto userDto);
}
