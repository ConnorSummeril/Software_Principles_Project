import java.util.Random;
/**
 * Solution development for 4bit/2-disclosure device.
 * @version 4.1.5
 * @author hollyradcliffe
 * @author Mohammad Shahid Foy
 * @author Connor J. Summeril
 * @author Said Robley
 * @author Ian Merrill
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
        final int MAX = 100000;

        boolean unlocked = false;
        unlocked = dev.spin();

        CharSequence values = "----";

        if(unlocked == true) {
            return unlocked;
        } else {
            while(unlocked == false && count < MAX)  {
                int rand1 = getRand1();
                int rand2 = getRand2();

                while(rand1 == rand2){
                    rand2 = getRand2();
                }

                if(rand1 == 0 && rand2 == 1){
                   values =  dev.peek("??--");
                   dev.poke("TT--");
                } else if(rand1 == 0 && rand2 == 2){
                   values =  dev.peek("?-?-");
                   dev.poke("T-T-");
                } else if(rand1 == 0 && rand2 == 3){
                   values=  dev.peek("?--?");
                   dev.poke("T--T");
                }else if(rand1 == 1 && rand2==2){
                   values = dev.peek("-??-");
                   dev.poke("-TT-");
                } else if(rand1 == 1 && rand2==3){
                   values = dev.peek("-?-?");
                   dev.poke("-T-T");
                } else if(rand1 == 2 && rand2 == 3){
                   values =  dev.peek("--??");
                   dev.poke("--TT");
                }

                unlocked = dev.spin();
                count++;
            }
            if(unlocked == true){
                return unlocked;
            } else{
                return false;
            }
        }
    }
    public static int getRand1(){
        Random rand = new Random();
        return rand.nextInt(3);
    }
    public static int getRand2(){
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }

}

