import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.*;

public class MyClassTest {
    private MyClass myClass;

    @Before
    public void setUp() throws Exception {
        myClass = new MyClass();
    }

//    @Rule
//    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void checkNaturalNum() throws Exception {
        assertEquals(myClass.checkNaturalNum(10), "All is well!");
        assertEquals(myClass.checkNaturalNum(989433453), "All is well!");
//        Exception1 e1 = new Exception1();
//        thrown.expect();
//        assertEquals(myClass.checkNaturalNum(-20), e1);
//        assertNotEquals(myClass.checkNaturalNum(-35.6),"All is well!");
//        assertNotEquals(myClass.checkNaturalNum(0),"All is well!");
//        assertNotEquals(myClass.checkNaturalNum(75.3434),"All is well!");

        boolean thrown = false;

        try {
            myClass.checkNaturalNum(-10);
        } catch (Exception1 exception1) {
            thrown = true;
        }

        assertTrue(thrown);

    }


}