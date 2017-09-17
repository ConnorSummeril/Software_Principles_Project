
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
* Unittest for testing the device unlocker.
*/
public class DeviceUnlockerTest {
    /**
     * Test that the Unlocker can unlock the default device.
     */
    @Test
    public void DefaultConstructUnlockTest() {
        Device testDevice = new Device();
        assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(testDevice));
    }
    
    /**
     * Return all permutations of the 4 bit boolean array
     * in a list.
     */
    private ArrayList<boolean[]> getPermutations() {
        ArrayList<boolean[]> permutations = new ArrayList<boolean[]>();
        //0000
        permutations.add(new boolean[] {false, false, false, false});
        //0001
        permutations.add(new boolean[] {false, false, false, true});
        //0010
        permutations.add(new boolean[] {false, false, true, false});
        //0011
        permutations.add(new boolean[] {false, false, true, true});
        //0100
        permutations.add(new boolean[] {false, true, false, false});
        //0101
        permutations.add(new boolean[] {false, true, false, true});
        //0110
        permutations.add(new boolean[] {false, true, true, false});
        //0111
        permutations.add(new boolean[] {false, true, true, true});
        //1000
        permutations.add(new boolean[] {true, false, false, false});
        //1001
        permutations.add(new boolean[] {true, false, false, true});
        //1010
        permutations.add(new boolean[] {true, false, true, false});
        //1011
        permutations.add(new boolean[] {true, false, true, true});
        //1100
        permutations.add(new boolean[] {true, true, false, false});
        //1101
        permutations.add(new boolean[] {true, false, true, true});
        //1111
        permutations.add(new boolean[] {true, true, true, true});
        
        return permutations;
    }
    /**
     * Test unlocking devices that are constructed using
     * all possible default boolean arrays.
     */
    @Test
    public void AllConstructorPermutationsTest() {
        // Arrange
        ArrayList<boolean[]> permutations = getPermutations(); 
        ArrayList<Boolean> successes = new ArrayList<Boolean>();
        // Act
        for (boolean[] perm : permutations) {
            Device testDevice = new Device(perm, Device.DEFAULT_SIZE);
            Boolean success = FourBitTwoDisclosureDeviceUnlocker.unlock(testDevice);
            successes.add(success);
        }
        // Assert
        for (boolean success : successes) {
            assertTrue(success);
        }
    }
    
    /**
     * Validate that the general algorithm is superior to a basic
     * algorithm.
     */
    @Test
    public void PerformanceTest() {
        // Arrange
        int runTime = 10000; //1 minute in millis * minutes
        long secondaryTime = System.currentTimeMillis();
        BigDecimal generalAlgorithmSuccesses = new BigDecimal(0);
        BigDecimal simpleAlgorithmSuccesses = new BigDecimal(0);
        // Act
        long endTime = System.currentTimeMillis() + runTime;
        Boolean success = false;
        ArrayList<boolean[]> permutations = getPermutations();
        int permutationPosition = 0;
        while (System.currentTimeMillis() <= endTime) {
            if (permutationPosition == permutations.size()) {
                permutationPosition = 0;
            }
            Device testDevice = new Device(permutations.get(permutationPosition),
                                           Device.DEFAULT_PEEKS);
            success = FourBitTwoDisclosureDeviceUnlocker.unlock(testDevice);
            if (success) { 
                generalAlgorithmSuccesses = generalAlgorithmSuccesses
                                            .add(new BigDecimal(1));
            }
            permutationPosition++;
        }
        endTime = System.currentTimeMillis() + runTime;
        permutationPosition = 0;
        while (System.currentTimeMillis() <= endTime) {
            if (permutationPosition == permutations.size()) {
                permutationPosition = 0;
            }
            Device testDevice = new Device(permutations.get(permutationPosition),
                                           Device.DEFAULT_PEEKS);
            success = SimpleDeviceUnlocker.unlock(testDevice);
            if (success) {
                simpleAlgorithmSuccesses = simpleAlgorithmSuccesses
                                           .add(new BigDecimal(1));
            }
            permutationPosition++;
        }
        // Assert
        System.out.println(generalAlgorithmSuccesses.toString());
        System.out.println(simpleAlgorithmSuccesses.toString());
        assertTrue(generalAlgorithmSuccesses.compareTo(simpleAlgorithmSuccesses) >= 0);
        
    }
    
}

