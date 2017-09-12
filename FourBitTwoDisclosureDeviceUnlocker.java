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
        int count = 0;
        // final int MAX = 2000000000;
        final int MAX = 20;
        boolean unlocked = false;
        unlocked = dev.spin();

        System.out.println("Hi");
        System.out.println(unlocked);

        if(unlocked == true) {
            return unlocked;
        } else {
            while(unlocked == false && count < MAX) {
                System.out.println(dev.peek("??--"));

                count++;
                unlocked = dev.spin();

            }

            if(unlocked == true) {
                return unlocked;
            } else {
                return false;
            }
        }
        // return false;
    }
}

class Constructor
{
  public static void main(String[]agrs)
  {
    FourBitTwoDisclosureDeviceUnlocker testLock = new FourBitTwoDisclosureDeviceUnlocker();

    boolean[] testArray = {false, true, true, false};
    Device device = new Device(testArray, 2);

    testLock.unlock(device);
  }

}