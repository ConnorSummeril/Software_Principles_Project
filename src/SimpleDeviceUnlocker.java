/**
 * Solution development for 4bit/2-disclosure device.
 *
 * @author Holly Radcliffe
 * @author Mohammad Shahid Foy
 * @author Connor J. Summeril
 * @author Said Robley
 * @author Ian Merrill
 * @version 4.1.5
 **/
public class SimpleDeviceUnlocker extends DeviceUnlocker {
    /**
     * Unlocks a resource controlled by
     * a 4bit/2-disclosure device. Behavior
     * is unspecified if parameter is not a
     * reference to a valid 4bit/2-disclosure device.
     *
     * @param dev the device controlling the resource
     *            to unlock; must be a 4-bit device with 2
     *            peek/poke bits.
     * @return true if the resource is successfully
     * unlocked (all bits are now identical);
     * false otherwise
     **/
    public static boolean unlock(Device dev) {
        int count = 0;
        final int MAX = 100000;

        boolean unlocked = false;
        unlocked = dev.spin();

        CharSequence values = "----";

        if (unlocked == true) {
            return true;
        } else {
            while (unlocked == false && count < MAX) {
                values = dev.peek("??--");
                dev.poke("TT--");
                unlocked = dev.spin();
                count++;
            }
            if (unlocked == true) {
                return true;
            } else {
                return false;
            }
        }
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

        boolean unlocked = false;
        unlocked = dev.spin();

        CharSequence values = "----";

        if (unlocked == true) {
            return true;
        } else {
            while (unlocked == false && count < MAX) {
                values = dev.peek("??--");
                dev.poke("TT--");
                unlocked = dev.spin();
                count++;
            }
            if (unlocked == true) {
                return true;
            } else {
                return false;
            }
        }
    }
}

