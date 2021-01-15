package es.datastructur.synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void testCapacity() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(10);
        ArrayRingBuffer<Integer> arb1 = new ArrayRingBuffer<>(0);
        assertEquals("capacity", 10, arb.capacity());
        assertEquals("capacity", 0, arb1.capacity());
    }

    @Test
    public void testFillCount() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);

        assertEquals("fillCount is incorrect", 0, arb.fillCount());
    }

    @Test
    public void testEnqueueDequeue() {
        ArrayRingBuffer<Integer> arb = new ArrayRingBuffer<>(3);

        assertEquals("the fill count should be 0", 0, arb.fillCount());

        arb.enqueue(4);
        arb.enqueue(8);
        arb.enqueue(15);
        assertEquals("the fill count should be 3", 3, arb.fillCount());
        assertEquals("test peek", 4, (int)arb.peek());

        arb.enqueue(32);
        assertEquals("the fill count should be 4", 3, arb.fillCount());
        assertEquals("test peek", 4, (int)arb.peek());

        int num = arb.dequeue();
        assertEquals("this element should be 4", 4, num);
        assertEquals("the fill count should be 2", 2, arb.fillCount());
        assertEquals("test peek", 8, (int)arb.peek());

        num = arb.dequeue();
        assertEquals("this element should be 8", 8, num);
        assertEquals("the fill count should be 1", 1, arb.fillCount());
        assertEquals("test peek", 15, (int)arb.peek());

        num = arb.dequeue();
        assertEquals("this element should be 15", 15, num);
        assertEquals("the fill count should be 0", 0, arb.fillCount());


    }
}
