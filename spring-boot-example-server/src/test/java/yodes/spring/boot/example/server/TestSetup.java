package yodes.spring.boot.example.server;

import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This is a abstract class that will setup the services required to integration test
 * <p>
 * Spring will cache this across test for us, so the initial test might take some time to startup, but after that it is
 * on par/close to normal unit test speed
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Main.class)
@WebIntegrationTest
public abstract class TestSetup {

}
