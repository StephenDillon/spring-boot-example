package yodes.spring.boot.example.server.services;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a example of how we can unit test at a lower level. Note the main
 * integration between the database, service, controller and object mapper is
 * already being tested, so while it is good practice to test this, if we added
 * a test for that here we would be duplicating our tests.
 * <p>
 * It is really good practice to test logic as directly as possible, so it is
 * faster and easier to retractor and find bugs. This is when we want to use
 * mocks to mock out dependencies (ie. database, object mappers) and focus on
 * testing the logic
 */
public class UserServiceTest {

	private UserServiceImpl userService;

	/**
	 * Setup the class for unit testing. We could also inject mocks in here if
	 * we need
	 */
	@Before
	public void setup() {
		userService = new UserServiceImpl();
	}

	/**
	 * The best part about testing this close to the logic is we can use
	 * multiple inputs and test the output in the easiest form. Create users
	 * with these username and making http requests and testing the responses is
	 * far more complicated and takes developers longer to find bugs
	 */
	@Test
	public void testObjectMapping() {
		TestCase.assertEquals("My test user",
				userService.capitalizeString("my test user"));
		TestCase.assertNull("My test user", userService.capitalizeString(null));
		TestCase.assertEquals("", userService.capitalizeString(""));
	}

}
