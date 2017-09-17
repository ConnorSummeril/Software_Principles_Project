/**
 * The LinearDeviceUnlocker algorithm peeks and pokes all peek and poke configurations in a linear non-random manner.
 */
public class LinearDeviceUnlocker extends DeviceUnlocker {

    private static String[] pokePatterns = new String[6];
    private static String[] peekPatterns = new String[6];

    public static boolean unlock(Device dev) {
        int count = 0;
        final int MAX = 100000;
        initializePatternArrays();
        CharSequence values = "----";
        int patternIndex = 0;

        boolean unlocked = false;
        unlocked = dev.spin();

        if (unlocked == true) {
            return unlocked;
        } else {
            while (unlocked == false && count < MAX) {
                if (patternIndex > 5) {
                    patternIndex = 0; //reset pattern index
                }
                values = dev.peek(peekPatterns[patternIndex]);
                dev.poke(pokePatterns[patternIndex]);

                patternIndex++;

                unlocked = dev.spin();
                count++;
            }
            if (unlocked == true) {
                return unlocked;
            } else {
                return false;
            }
        }
    }

    public static void initializePatternArrays() {
        pokePatterns[0] = "TT--";
        pokePatterns[1] = "T-T-";
        pokePatterns[2] = "T--T";
        pokePatterns[3] = "-TT-";
        pokePatterns[4] = "-T-T";
        pokePatterns[5] = "--TT";

        peekPatterns[0] = "??--";
        peekPatterns[1] = "?-?-";
        peekPatterns[2] = "?--?";
        peekPatterns[3] = "-??-";
        peekPatterns[4] = "-?-?";
        peekPatterns[5] = "--??";
    }

    /**
     * This is an overloaded method to allow for the algorithm to be tested with custom spin devices.
     * @param dev the custom device
     * @return true if the resource is successfully
     * unlocked (all bits are now identical);
     * false otherwise
     */
    public static boolean unlock(CustomDevice dev) {
        int count = 0;
        final int MAX = 100000;
        initializePatternArrays();
        CharSequence values = "----";
        int patternIndex = 0;

        boolean unlocked = false;
        unlocked = dev.spin();

        if (unlocked == true) {
            return unlocked;
        } else {
            while (unlocked == false && count < MAX) {
                if (patternIndex > 5) {
                    patternIndex = 0; //reset pattern index
                }
                values = dev.peek(peekPatterns[patternIndex]);
                dev.poke(pokePatterns[patternIndex]);

                patternIndex++;

                unlocked = dev.spin();
                count++;
            }
            if (unlocked == true) {
                return unlocked;
            } else {
                return false;
            }
        }
    }
}
