package cs3.lists;

/**
 * Queue of Strings.
 *
 * @author Mr. Nichols
 */
public interface StringQueue {

    /**
     * Pushes a string onto the queue (enqueues the string).
     * @param str the {@code String} to enqueue
     */
    void enqueue(String str);

    /**
     * Removes the string from the head of the queue and returns it.
     * @return the {@code String} from the head of the queue
     * @throws NoTengoNadaException when called with an empty queue
     */
    String dequeue();

    /**
     * Returns the head of the queue. The head of a queue is the oldest element
     * in the queue.
     *
     * @return the head of the queue
     * @throws NoTengoNadaException when called with an empty queue
     */
    String head();

    /**
     * Returns the tail of the queue. The tail is the last element you placed in
     * the queue.
     *
     * @return the tail of the queue
     * @throws NoTengoNadaException when called with an empty queue
     */
    String tail();

    /**
     * Return the number of {@code String} elements in the stack.
     *
     * @return the number of {@code String} elements in the stack.
     */
    int size();

}
