import org.junit.Test;
import static org.junit.Assert.*;
public class FlikTest {
    @Test
    public void testIsSameNumber()throws Exception {
        int i = 0;
        for (i = 0; i < 500; ++i) {
            if (!Flik.isSameNumber(i, i)) {
                throw new Exception(
                        String.format("i:%d not same as j:%d ??", i, i));
            }
        }
        System.out.println("i is " + i);

    }
}
