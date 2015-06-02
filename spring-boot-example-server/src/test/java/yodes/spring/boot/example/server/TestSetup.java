package yodes.spring.boot.example.server;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import yodes.spring.boot.example.server.Main;

/**
 * This is a abstract class that will setup the services and clients required to integration test
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebAppConfiguration
public abstract class TestSetup {

}
