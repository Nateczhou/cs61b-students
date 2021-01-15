import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDequeGold {
    @Test
    public void testArrayDeque() {
        StudentArrayDeque<Integer> studentDeque = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> solutionDeque = new ArrayDequeSolution<>();
        int iter = 5;
        double numberBetweenZeroAndOne = StdRandom.uniform();
        int counter = 0;
        StringBuilder message = new StringBuilder("\n");
        for (int i = 0; i < iter; i+=1) {
            int randomInput = StdRandom.uniform(500);
            int times = StdRandom.uniform(0, 5);
            for (int adds = 0; adds < times; adds += 1) {
                randomInput = StdRandom.uniform(500);
                numberBetweenZeroAndOne = StdRandom.uniform();
                if (numberBetweenZeroAndOne < 0.5) {
                    studentDeque.addFirst(randomInput);
                    solutionDeque.addFirst(randomInput);
                    message.append("addFirst(");
                    message.append(randomInput);
                    message.append(")");
                    message.append("\n");
                    counter += 1;
                } else {
                    studentDeque.addLast(randomInput);
                    solutionDeque.addLast(randomInput);
                    message.append("addLast(");
                    message.append(randomInput);
                    message.append(")");
                    message.append("\n");
                    counter += 1;
                }
            }

            times = StdRandom.uniform(0, 5);
            for (int removes = 0; removes < times && counter > 0; removes += 1) {
                Integer x = null;
                Integer y = null;
                numberBetweenZeroAndOne = StdRandom.uniform();
                if (numberBetweenZeroAndOne < 0.5) {
                    x = studentDeque.removeFirst();
                    y = solutionDeque.removeFirst();
                    message.append("removeFirst(), correct was ");
                    message.append(y);
                    message.append(", student was ");
                    message.append(x);
                    message.append("\n");
                    counter -= 1;
                    assertEquals(message.toString(), y, x);
                } else {
                    x = studentDeque.removeLast();
                    y = solutionDeque.removeLast();
                    message.append("removeLast(), correct was ");
                    message.append(y);
                    message.append(", student was ");
                    message.append(x);
                    message.append("\n");
                    counter -= 1;
                    assertEquals(message.toString(), y, x);
                }
            }







        }
    }
}
