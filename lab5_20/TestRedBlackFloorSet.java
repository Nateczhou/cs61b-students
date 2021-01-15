import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * Created by hug.
 */
public class TestRedBlackFloorSet {
    @Test
    public void randomizedTest() {
       // TODO: YOUR CODE HERE
        AListFloorSet alistFS = new AListFloorSet();
        RedBlackFloorSet rbFS = new RedBlackFloorSet();
        for (int i = 0; i < 1000000; i++) {
            double n = StdRandom.uniform(-5000, 5000);
            alistFS.add(n);
            rbFS.add(n);
        }
        for (int i = 0; i < 100000; i++) {
            double n = StdRandom.uniform(-5000, 5000);
            assertEquals(alistFS.floor(n), rbFS.floor(n), 0.000001);
        }
    }
}
