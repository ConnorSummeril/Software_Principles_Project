/**
 * Provides for unlocking resource-control devices.
 *
 * @author hollyradcliffe
 * @Version 1.1.5
 */
public abstract class DeviceUnlocker {

    public DeviceUnlocker() {

    }

    /**
     * Unlocks a device-controlled resource.
     *
     * @param dev the device controlling the
     *            resource to unlock
     * @return true if the resource is unlocked
     * (all bits in the device are now identical);
     * false otherwise
     */
    public static boolean unlock(Device dev) {
        return false;
    }

    /**
     * Retrieve trace of previous unlock process.
     *
     * @return rendering of steps in the unlock process
     */
    public static String showTrace() {
        return null;
    }
}