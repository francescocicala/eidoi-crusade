package francescocicala;

import junit.framework.TestCase;

public class AdditionTest extends TestCase {
    protected int value1 = 1, value2 = 3;
    protected Addition additionObj;

    protected void setUp(){
        this.additionObj = new Addition(value1, value2);
    }

    public void testAddition() {
        assertEquals(value1 + value2, this.additionObj.getResult());        
    }
    
}