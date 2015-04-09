package yodes.spring.boot.example.server.services;

import java.util.List;

import yodes.spring.boot.example.api.UserDto;

public interface UserService {

	List<UserDto> list();

	UserDto findById(String id);

	UserDto create(UserDto userDto);

	UserDto update(UserDto userDto);

	void delete(String id);

}