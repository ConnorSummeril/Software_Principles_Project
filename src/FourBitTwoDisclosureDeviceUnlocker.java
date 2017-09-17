import java.util.Random;
/**
 * Solution development for 4bit/2-disclosure device.
 * @author Holly Radcliffe
 * @author Mohammad Shahid Foy
 * @author Connor J. Summeril
 * @author Said Robley
 * @author Ian Merrill
 * @author Dr. Jody Paul
 * @version 4.1.5
 * @see <a href="http://jodypaul.com/cs/sweprin/deviceProj/projectDescription.html">Project Description</a>
 **/
public final class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker {

    /**
     * Unlocks a resource controlled by
     * a 4bit/2-disclosure device. Behavior
     * is unspecified if parameter is not a
     * reference to a valid 4bit/2-disclosure device.
     *
     **/
    private FourBitTwoDisclosureDeviceUnlocker() {
    }

    /**
    * Unlocks a resource controlled by a 4-bit/2-disclosure device.
    * @param dev the device controlling the resource
    * to unlock; must be a 4-bit device with 2
    * peek/poke bits.
    * @return true if the resource is successfully
    * unlocked (all bits are now identical);
    * false otherwise
    **/
    public static boolean unlock(final Device dev) {
            int count = 0;
            final int maxTries = 100000;
            boolean unlocked = dev.spin();
            if (unlocked) {
                return true;
            }
            while (!unlocked && count < maxTries) {
                int rand1 = getRand1();
                int rand2 = getRand2();
                while (rand1 == rand2) {
                    rand2 = getRand2();
                }
                randomizedPeekPoke(rand1, rand2, dev);
                unlocked = dev.spin();
                count++;
            }
            return unlocked;
        }

    /**
     * Randomized peeking helper.
     * @return a value from 0-2
     */
    private static int getRand1() {
        Random rand = new Random();
        final int range = 3;
        return rand.nextInt(range);
    }

    /**
     * Randomized peeking helper.
     * @return a value from 1-3
     */
    private static int getRand2() {
        Random rand = new Random();
        final int range = 3;
        final int offset = 1;
        return rand.nextInt(range) + offset;
    }

    /**
    * Decide which peek positions
    * to check based on randomized values passed.
    * @param rand1 The first random value for permutation
    * @param rand2 The second random value for permutation
    * @param dev The device to be accessed
    */
    private static void randomizedPeekPoke(final int rand1, final int rand2,
                                           final Device dev) {
        CharSequence values = "----";
        final int indexZero, indexOne, indexTwo, indexThree;
        indexZero = 0;
        indexOne = 1;
        indexTwo = 2;
        indexThree = 3;

        if (rand1 == indexZero && rand2 == indexOne) {
            values =  dev.peek("??--");
            log("peek: " + values);
            dev.poke("TT--");
        } else if (rand1 == indexZero && rand2 == indexTwo) {
            values =  dev.peek("?-?-");
            log("peek: " + values);
            dev.poke("T-T-");
        } else if (rand1 == indexZero && rand2 == indexThree) {
            values = dev.peek("?--?");
            log("peek: " + values);
            dev.poke("T--T");
        } else if (rand1 == indexOne && rand2 == indexTwo) {
            values = dev.peek("-??-");
            log("peek: " + values);
            dev.poke("-TT-");
        } else if (rand1 == indexOne && rand2 == indexThree) {
            values = dev.peek("-?-?");
            log("peek: " + values);
            dev.poke("-T-T");
        } else if (rand1 == indexTwo && rand2 == indexThree) {
            values =  dev.peek("--??");
            log("peek: " + values);
            dev.poke("--TT");
        }
    }
}
