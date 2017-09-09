/**
 * Solution development for 4bit/2-disclosure device.
 * @version 4.1.5
 * @author hollyradcliffe
 *
 **/
public class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker{

    /**
     * Unlocks a resource controlled by
     * a 4bit/2-disclosure device. Behavior
     * is unspecified if paramter is not a
     * reference to a valid 4bit/2-disclosure device.
     * @param dev the device controlling the resource
     * to unlock; must be a 4-bit device with 2
     * peek/poke bits.
     * @return true if the resource ius successfully
     * unlocked (all bits are now identical);
     * false otherwise
     **/
    public static boolean unlock(Device dev) {
        return false;
    }
}