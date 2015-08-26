package cs3.lists;

/**
 * Interface for a linked list containing elements of type {@code String}.
 * Indices for locations in the list begin at 0.
 * @author Michael Nichols
 */
public interface StringList {

    /**
     * Return the number of {@code String} elements in the list.
     * @return the number of {@code String} elements in the list.
     */
    int size();

    /**
     * Return the {@code String} at the specified location in the list.
     * @param index the index of the item to return
     * @return the {@code String} found at the specified index
     * @throws IndexOutOfBoundsException if the index falls outside of the
     * valid range of indices (given the contents of the list)
     */
    String get(int index);

    /**
     * Adds the given {@code String} to the end of the list.
     * The {@code String} may not be null.
     * @param element  the {@code String} to add
     * @throws NullPointerException if {@code element} is null
     */
    void add(String element);

    /**
     * Adds the given {@code String} to the list at the specified location.
     * Any {@code String} already at or following the index will follow the
     * inserted element after completion of this method.
     * The {@code String} may not be null.
     * @param index the index at which to add the new {@code String}
     * @param element the {@code String} to add
     * @throws IndexOutOfBoundsException if the index is invalid
     * @throws NullPointerException if {@code element} is null
     */
    void add(int index, String element);

    /**
     * Removes the {@code String} at the specified index in the list.
     * @param index the index of the element to remove
     * @throws IndexOutOfBoundsException if the index does not exist in
     * the list
     */
    void remove(int index);

    /**
     * Returns the first index at which the supplied {@code String} exists in the
     * list. If the given {@code String} does not exist in the list,
     * this method returns a -1.
     * @param element the {@code String} to search for
     * @return the index of the {@code String} in the list or -1 if not found
     * @throws NullPointerException if {@code element} is null
     */
    int indexOf(String element);

    /**
     * Returns true if given {@code String} is in the list and false otherwise. 
     * @param element the {@code String} to search for
     * @return true if {@code element} is in list, false otherwise
     * @throws NullPointerException if {@code element} is null
     */
    boolean contains(String element);

    /**
     * Generates an array from the list.
     * @return an array containing the elements of the list
     */
    String[] toArray();
}
