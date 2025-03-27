import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeworkStringLength {

    @Test
    public void testStringLength(){

        String hello = "String for testing";
        int length = hello.length();

        assertTrue(length > 15, "Lenghth is more than 15");
    }
}
