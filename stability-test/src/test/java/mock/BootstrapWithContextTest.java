package mock;

import io.esastack.RestLightApplication;
import io.esastack.restlight.test.bootstrap.MockMvcBuilders;
import io.esastack.restlight.test.context.MockMvc;
import io.esastack.restlight.test.mock.MockHttpRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvcBuilderSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestLightApplication.class)
public class BootstrapWithContextTest {

    @Autowired
    private ApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.contextSetup(context);
    }

    @Test
    public void testListAll() throws InterruptedException {
        mockMvc.perform(MockHttpRequest.aMockRequest().withUri("/simple-http/nobody").build())
                .addExpect(r -> assertEquals(200, r.response().status()));
        Thread.sleep(1000);
    }
}