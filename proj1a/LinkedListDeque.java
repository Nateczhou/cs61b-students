public class LinkedListDeque<Item> {
    private Node<Item> sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node<>();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Add an Item to the front of the deque
     * @param item
     */
    public void addFirst(Item item) {
        Node<Item> node = new Node<>(item);
        node.next = sentinel.next.prev;
        node.prev = sentinel;
        sentinel.next.prev = node;
        sentinel.next = node;
        size += 1;
    }

    /**
     * Add an Item to the end of the deque
     * @param item
     */
    public void addLast(Item item) {
        Node<Item> last = sentinel.prev;
        Node<Item> node = new Node<>(item);
        last.next = node;
        node.prev = last;
        node.next = sentinel;
        sentinel.prev = node;
        size += 1;
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
        Node<Item> curr = sentinel.next;
        for (int i = 0; i < size; i+=1) {
            System.out.print(curr.item.toString()+" ");
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * Removes and returns the first item in the deque
     * @return
     */
    public Item removeFirst() {
        Node<Item> first = sentinel.next;
        Node<Item> second = first.next;
        sentinel.next = second;
        second.prev = sentinel;
        size -= 1;
        return first.item;
    }

    /**
     * Removes and returns the last item in the deque
     * @return
     */
    public Item removeLast() {
        Node<Item> last = sentinel.prev;
        Node<Item> secondLast = last.prev;
        sentinel.prev = secondLast;
        secondLast.next = sentinel;
        last.prev = null;
        last.next = null;
        size -= 1;
        return last.item;
    }

    /**
     * Returns the item at the given index. if no such item exists, returns null.
     * @param index
     * @return
     */
    public Item get(int index) {
        Node<Item> curr = sentinel;
        if (index < size) {
            while (index >= 0) {
                curr = curr.next;
                index--;
            }
            return curr.item;
        }
        return null;
    }

    /**
     * Node class for linkedList
     * @param <Item>
     */
    private class Node<Item> {
        private Item item;
        public Node next;
        public Node prev;

        public Node() {
            item = null;
            next = null;
            prev = null;
        }

        public Node(Item item) {
            this.item = item;
            next = null;
            prev = null;
        }
    }
}