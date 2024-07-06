import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MyServiceTest {



    @Test
    void testGetMessage() {
        String expectedMessage = "Hello, World!";

        assertEquals(expectedMessage, "Hello, World!");
    }
}