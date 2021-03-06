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
 public final class FourBitTwoDisclosureDeviceUnlocker extends DeviceUnlocker{
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
    public static boolean unlock(Device dev) {
            int count = 0;
            final int MAX = 100000;
            boolean unlocked = false;
            unlocked = dev.spin();
            if(unlocked == true) {
                return unlocked;
            } else {
                while(unlocked == false && count < MAX)  {
                    int rand1 = getRand1();
                    int rand2 = getRand2();
                    while(rand1 == rand2){
                        rand2 = getRand2();
                    }
                    randomizedPeekPoke(dev, rand1, rand2);
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
    /**
     * Randomized peeking helper.
     * @return a value from 0-2
     */
    private static int getRand1(){
        Random rand = new Random();
        return rand.nextInt(3);
    }
    /**
     * Randomized peeking helper.
     * @return a value from 1-3
     */
    private static int getRand2(){
        Random rand = new Random();
        return rand.nextInt(3) + 1;
    }
    private static void randomizedPeekPoke(Device dev, int rand1, int rand2) {
        CharSequence values = "----";
        
        if(rand1 == 0 && rand2 == 1){
            values =  dev.peek("??--");
            log("peek: " + values);
            dev.poke("TT--");
         } else if(rand1 == 0 && rand2 == 2){
            values =  dev.peek("?-?-");
            log("peek: " + values);
            dev.poke("T-T-");
         } else if(rand1 == 0 && rand2 == 3){
            values=  dev.peek("?--?");
            log("peek: " + values);
            dev.poke("T--T");
         }else if(rand1 == 1 && rand2 == 2){
            values = dev.peek("-??-");
            log("peek: " + values);
            dev.poke("-TT-");
         } else if(rand1 == 1 && rand2 == 3){
            values = dev.peek("-?-?");
            log("peek: " + values);
            dev.poke("-T-T");  
         } else if(rand1 == 2 && rand2 == 3){
            values =  dev.peek("--??");
            log("peek: " + values);
            dev.poke("--TT");
         }
    }
}