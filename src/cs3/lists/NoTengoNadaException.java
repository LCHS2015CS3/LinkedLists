package cs3.lists;

/**
 * Exception thrown when trying to access data from an empty
 * data structure.
 * @author Mr. Nichols
 */
public class NoTengoNadaException extends RuntimeException {

    /**
     * Creates a new instance of <code>NoTengoNadaException</code> without detail
     * message.
     */
    public NoTengoNadaException() {
    }

    /**
     * Constructs an instance of <code>NoTengoNadaException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public NoTengoNadaException(String msg) {
	super(msg);
    }
}
