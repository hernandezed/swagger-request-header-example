package demo.transport;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GreetingTest {

    @Test
    public void testJsonSerialization() {
        final ObjectMapper mapper = new ObjectMapper();

        assertTrue(mapper.canSerialize(Greeting.class));
    }

}
