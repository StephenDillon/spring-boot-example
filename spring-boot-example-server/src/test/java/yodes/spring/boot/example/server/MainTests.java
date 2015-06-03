package yodes.spring.boot.example.server;

import junit.framework.TestCase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import yodes.spring.boot.example.server.controllers.UserController;

/**
 * This tests that your application can startup and all your contexts are setup
 * correctly
 */
public class MainTests extends TestSetup {

	@Autowired
	private UserController userController;

	/**
	 * Test that all context load and we can autowire our controller
	 */
	@Test
	public void contextLoads() {
		TestCase.assertNotNull(userController);
	}

}
