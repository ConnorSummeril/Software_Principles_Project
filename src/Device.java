/**
 * Resource-locking device with circular
 * bit storage.
 *
 * @author hollyradcliffe
 * @Version 1.2.5
 */
public class Device {

    /**
     * Default number of bits to reveal per peek.
     **/
    public static final int DEFAULT_PEEKS = 2;
    /**
     * Default number of bits stored.
     **/
    public static final int DEFAULT_SIZE = 4;
    /**
     * Character indicator of false.
     **/
    public static final char VALUE_FALSE = 'F';
    /**
     * Character indicator of true.
     **/
    public static final char VALUE_TRUE = 'T';

    /**
     * Construct device using defaults.
     */
    public Device() {

    }

    /**
     * Construct device with specified
     * size and number of peek/poke bits.
     *
     * @param size        the number of bits stored
     *                    in this device
     * @param bitsPerPeek the number of bits
     *                    to disclose via peek or set via poke
     */
    public Device(int size, int bitsPerPeek) {

    }

    /**
     * Construct device with specified defaults.
     *
     * @param intialBits  the bit values for this
     *                    test device
     * @param bitsPerPeek the number of bits to disclose
     *                    via peek or set via poke.
     */
    public Device(boolean[] intialBits, int bitsPerPeek) {

    }

    /**
     * Initiate device rotation.
     *
     * @return true if all bits have
     * identical value; false if otherwise
     */
    public boolean spin() {
        return false;
    }

    /**
     * Peek at bits of a device.
     *
     * @param pattern indicating which bits to
     *                show as '?'
     * @return a pattern that discloses the values
     * of the indicated bits
     */
    public CharSequence peek(CharSequence pattern) {
        return null;
    }

    /**
     * Poke bits into device.
     *
     * @param pattern indicator of values
     *                of bits to poke
     */
    public void poke(CharSequence pattern) {

    }

    /**
     * Render device information as a string.
     *
     * @return rendering that reveals partial state
     */
    @Override
    public String toString() {
        return null;
    }
}