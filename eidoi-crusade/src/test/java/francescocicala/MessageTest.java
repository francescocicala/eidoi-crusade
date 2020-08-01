package francescocicala;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MessageTest {
    protected Message messageObj;
    protected String message = "Ciao!";

    @Before
    protected void setUp() { // override the setUp method to set up the fixture state
    this.messageObj = new Message(message);
    }

    @Test
    public void testMessage() {
        assertEquals(this.message, this.messageObj.getMessage());
    }
}