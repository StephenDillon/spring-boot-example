package yodes.spring.boot.example.server.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import yodes.spring.boot.example.api.UserDto;
import yodes.spring.boot.example.server.entities.UserEntity;
import yodes.spring.boot.example.server.repositories.UserRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public List<UserDto> list() {
		List<UserEntity> users = userRepository.findAll();
		List<UserDto> usersDto = new ArrayList<UserDto>();
		for (UserEntity userEntity : users) {
			usersDto.add(objectMapper.convertValue(userEntity, UserDto.class));
		}
		return usersDto;
	}

	@Override
	public UserDto findById(String id) {
		UserEntity userEntity = userRepository.findOne(id);
		return objectMapper.convertValue(userEntity, UserDto.class);
	}

	@Override
	public UserDto create(UserDto userDto) {
		UserEntity userEntity = objectMapper.convertValue(userDto,
				UserEntity.class);
		userEntity = userRepository.save(userEntity);
		return objectMapper.convertValue(userEntity, UserDto.class);
	}

	@Override
	public UserDto update(UserDto userDto) {
		UserEntity userEntity = objectMapper.convertValue(userDto,
				UserEntity.class);
		userEntity = userRepository.save(userEntity);
		return objectMapper.convertValue(userEntity, UserDto.class);
	}

	@Override
	public void delete(String id) {
		userRepository.delete(id);
	}
}
