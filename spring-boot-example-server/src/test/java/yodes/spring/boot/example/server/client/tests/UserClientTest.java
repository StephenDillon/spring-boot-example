package yodes.spring.boot.example.server.client.tests;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import yodes.spring.boot.example.api.UserDto;
import yodes.spring.boot.example.client.UserClient;
import yodes.spring.boot.example.server.TestSetup;

/**
 * Test our client and service by starting up our service and using the client to send HTTP requests at our controller
 */
public class UserClientTest extends TestSetup {

	/**
	 * Our user client user to test the service
	 */
	private UserClient userClient = new UserClient();

	@Test
	public void testList() {
		int userCount = userClient.list().size();
		UserDto myNewUser = userClient.create(createUserDto("Test List user"));
		List<UserDto> users = userClient.list();
		TestCase.assertEquals(userCount + 1, users.size());
		boolean userFound = false;
		for (UserDto user : users) {
			if (myNewUser.getId().equals(user.getId())) {
				userFound = true;
			}
		}
		if (!userFound) {
			TestCase.fail("Created user resource is not found in the list response");
		}
	}

	@Test
	public void testFindById() {
		// TODO Auto-generated method stub
	}

	@Test
	public void testCreate() {
		// TODO Auto-generated method stub
	}

	@Test
	public void testUpdate() {
		// TODO Auto-generated method stub
	}

	@Test
	public void testDelete() {
		// TODO Auto-generated method stub

	}

	/**
	 * Create a user dto with the name set
	 * 
	 * @param name
	 *            to set
	 * @return UserDto
	 */
	private UserDto createUserDto(String name) {
		UserDto userDto = new UserDto();
		userDto.setName(name);
		return userDto;
	}

}
