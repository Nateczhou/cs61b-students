public class ArrayDeque<Item> {
    private Item[] array;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        array = (Item[]) new Object[5];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    private int getEquvilantIndex(int index) {
        if (index < 0) {
            return array.length + index;
        }
        return index;
    }

    /**
     * Add an Item to the front of the deque
     * @param item
     */
    public void addFirst(Item item) {
        int index = getEquvilantIndex(nextFirst);
        array[index] = item;
        nextFirst--;
        size++;
    }

    /**
     * Add an Item to the end of the deque
     * @param item
     */
    public void addLast(Item item) {
        int index = getEquvilantIndex(nextLast);
        array[index] = item;
        nextLast++;
        size++;
    }

    /**
     * Return true if deque is empty, false otherwise
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the number of items in the deque
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Prints the items in the deque from first to last, separated by a space
     */
    public void printDeque() {
        for (int i = nextFirst+1; i < nextLast; i++) {
            System.out.print(array[getEquvilantIndex(i)].toString());
        }
        System.out.println();
    }

    /**
     * Removes and returns the first item in the deque
     * @return
     */
    public Item removeFirst() {
        Item res = array[getEquvilantIndex(nextFirst+1)];
        array[getEquvilantIndex(nextFirst+1)] = null;
        nextFirst++;
        size--;
        return res;
    }

    /**
     * Removes and returns the last item in the deque
     * @return
     */
    public Item removeLast() {
        Item res = array[getEquvilantIndex(nextLast-1)];
        array[getEquvilantIndex(nextLast-1)] = null;
        nextLast--;
        size--;
        return res;
    }

    /**
     * Returns the item at the given index. if no such item exists, returns null.
     * @param index
     * @return
     */
    public Item get(int index) {
        int head = nextFirst + 1;
        return array[index+head];
    }

}