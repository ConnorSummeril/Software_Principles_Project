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
    // needs implementations
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
    // needs implementation
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
        for(int i = 0; i < DEFAULT_SIZE; i++) {
            bitArray[i] = initialBits[i];
        }

        if(bitsPerPeek == DEFAULT_PEEKS) {
            thebits = bitsPerPeek;
        }


        for(int y = 0; y < DEFAULT_SIZE; y++) {
            System.out.println(bitArray[y]);
        }

        System.out.println("===========================");

    }

    /**
     * Initiate device rotation.
     *
     * @return true if all bits have
     * identical value; false if otherwise
     */
    public boolean spin() {
        int countFalse = 0;
        int countTrue = 0;

        for(int i = 0; i < DEFAULT_SIZE; i++) {
            if(bitArray[i] == false) {
                countFalse++;
            }
        }

        for(int j = 0; j < DEFAULT_SIZE; j++) {
            if(bitArray[j] == true) {
                countTrue++;
            }
        }

        System.out.println("True Count: " + countTrue);


        if(countFalse == 4 || countTrue == 4) {
            return true;
        } else {
            int randomNum = (int) (Math.random() * 11);
            int tracker = 0;
            System.out.println("The Random Number: " + randomNum);
            boolean[] tmpArray = new boolean[DEFAULT_SIZE];
            while(tracker < randomNum) {
                tmpArray[0] = bitArray[3];
                tmpArray[1] = bitArray[0];
                tmpArray[2] = bitArray[1];
                tmpArray[3] = bitArray[2];

                bitArray[0] = tmpArray[0];
                bitArray[1] = tmpArray[1];
                bitArray[2] = tmpArray[2];
                bitArray[3] = tmpArray[3];

                tracker++;
            }

            for(int y = 0; y < DEFAULT_SIZE; y++) {
                System.out.println(bitArray[y]);
            }

            System.out.println("===========================");


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
        System.out.println(pattern);
        //System.out.println(pattern.charAt(1));
        //System.out.println(pattern.charAt(5));

        CharSequence returnVal1 = "-";
        CharSequence returnVal2 = "-";
        CharSequence returnVal3 = "-";
        CharSequence returnVal4 = "-";

        if(pattern.charAt(1) == '?') {
            if(bitArray[0] == false) {
                returnVal1 =  String.valueOf(VALUE_FALSE);
                //return returnVal1;
            } else {
                returnVal1 = String.valueOf(VALUE_TRUE);
                //return returnVal1;
            }
        }

        if(pattern.charAt(3) == '?') {
            if(bitArray[1] == false) {
                returnVal2 =  String.valueOf(VALUE_FALSE);
                //return returnVal1;
            } else {
                returnVal2 = String.valueOf(VALUE_TRUE);
                //return returnVal1;
            }
        }

        if(pattern.charAt(5) == '?') {
            if(bitArray[2] == false) {
                returnVal3 =  String.valueOf(VALUE_FALSE);
                //return returnVal3;
            } else {
                returnVal3 = String.valueOf(VALUE_TRUE);
                //return returnVal3;
            }
        }

        if(pattern.charAt(7) == '?') {
            if(bitArray[3] == false) {
                returnVal4 =  String.valueOf(VALUE_FALSE);
                //return returnVal3;
            } else {
                returnVal4 = String.valueOf(VALUE_TRUE);
                //return returnVal3;
            }
        }

        return "["+returnVal1+ " "+returnVal2+" "+returnVal3+" "+returnVal4+"]";
    }

    public void poke(CharSequence pattern) {
        System.out.println(pattern);

        CharSequence returnVal1 = "-";
        CharSequence returnVal2 = "-";
        CharSequence returnVal3 = "-";
        CharSequence returnVal4 = "-";

        if(pattern.charAt(1) == 'T') {
            if(bitArray[0] == false) {
                returnVal1 = String.valueOf(VALUE_TRUE);
                bitArray[0] = true;
            }
        }

        if(pattern.charAt(3) == 'T') {
            if(bitArray[1] == false) {
                returnVal2 = String.valueOf(VALUE_TRUE);
                bitArray[1] = true;
            }
        }

        if(pattern.charAt(5) == 'T') {
            if(bitArray[2] == false) {
                returnVal3 = String.valueOf(VALUE_TRUE);
                bitArray[2] = true;
            }
        }

        if(pattern.charAt(7) == 'T') {
            if(bitArray[3] == false) {
                returnVal4 = String.valueOf(VALUE_TRUE);
                bitArray[3] = true;
            }
        }

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