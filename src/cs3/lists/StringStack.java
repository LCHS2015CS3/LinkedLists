package cs3.lists;

/**
 * Stack of String.
 *
 * @author Mr. Nichols
 */
public interface StringStack {

    /**
     * Return the number of {@code String} elements in the stack.
     *
     * @return the number of {@code String} elements in the stack.
     */
    int size();

    /**
     * Push a string onto the stack.
     * @param str the string to push
     */
    void push(String str);

    /**
     * Pops a string from the top of the stack.
     * This method removes the top element from the stack and returns it.
     * @return the string from the top of the stack
     * @throws NoTengoNadaException when called on an empty stack
     */
    String pop();

    /**
     * Returns the string at the top of the stack without removing it
     * from the stack.
     * @return the string at the top of the stack
     * @throws NoTengoNadaException when called on an empty stack
     */
    String peek();

}
