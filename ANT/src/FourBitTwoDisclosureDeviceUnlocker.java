/**
 * Solution development for 4bit/2-disclosure device.
 * @version 4.1.5
 * @author hollyradcliffe
 * @author Mohammad Shahid Foy
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
    public static void main(String[] args){
        boolean[] test = {true, false, true, true};
        Device d = new Device(test, 2);
        unlock(d);

    }
    public static boolean unlock(Device dev) {
        // algorithm
        int count = 0;
        final int MAX = 20;
        // 2.
        boolean unlocked = false;
        unlocked = dev.spin();

        if(unlocked == true) {
            return unlocked;
        } else {
            while(unlocked == false && count < MAX)  {
                // this is one algorith
                dev.spin();
                dev.peek("??--");
                dev.poke("TT--");
                unlocked = dev.spin();
                count++;


            }
            if(unlocked == true){
                return unlocked;
            }
        }
        if(count == MAX){
            return false;
        }


        return false;
    }
}
