package yodes.spring.boot.example.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import yodes.spring.boot.example.api.UserApi;
import yodes.spring.boot.example.api.UserDto;

/**
 * Client to execute user operations
 */
public class UserClient implements UserApi {

	/**
	 * Spring rest template used to send requests
	 * <p>
	 * If you have multiple clients, it would be best to inject this in so we don't create a new one every time
	 */
	private RestTemplate restTemplate = new RestTemplate();

	/**
	 * Target url for our tests. Using localhost but we could update this to point anywhere, or inject in a value
	 */
	private static final String usersUrl = "http://localhost:8080/users";

	@Override
	public List<UserDto> list() {
		return Arrays.asList(restTemplate.getForObject(usersUrl, UserDto[].class));
	}

	@Override
	public UserDto findById(String id) {
		return restTemplate.getForObject(String.format(usersUrl + "/%s", id), UserDto.class);
	}

	@Override
	public UserDto create(UserDto userDto) {
		return restTemplate.postForObject(usersUrl, userDto, UserDto.class);
	}

	@Override
	public UserDto update(UserDto userDto) {
		return restTemplate.postForObject(String.format(usersUrl + "/%s", userDto.getId()), userDto, UserDto.class);
	}

	@Override
	public void delete(String id) {
		restTemplate.delete(String.format(usersUrl + "/%s", id));
	}

}
