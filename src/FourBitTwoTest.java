import static org.junit.Assert.assertThat; 
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class FourBitTwoTest {

	@Test
	public void testOne() {
        boolean[] testArray1 = {false, false, false, false};
        Device device1 = new Device(testArray1, 2);
		assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device1));
	}
	
    @Test
    public void testTwo() {
        boolean [] testArray2 = {false, false, false, true};
        Device device2 = new Device(testArray2, 2);
        assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device2));
    }
    
    @Test
    public void testThree() {
        boolean [] testArray3 = {false, false, true, false};
        Device device3 = new Device(testArray3, 2);
        assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device3));    
    }
    
    @Test
    public void testFour() {
       boolean [] testArray4 = {false, true, false, false};
       Device device4 = new Device(testArray4, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device4));
    }

    @Test
    public void testFive() {
       boolean [] testArray5 = {true, false, false, false};
       Device device5 = new Device(testArray5, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device5));
    }
    
    @Test
    public void testSix() {
       boolean [] testArray6 = {true, true, false, false};
       Device device6 = new Device(testArray6, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device6));
    }
    
    @Test
    public void testSeven() {
       boolean [] testArray7 = {false, true, true, false};
       Device device7 = new Device(testArray7, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device7));
    }
    
    @Test
    public void testEight() {
       boolean [] testArray8 = {false, false, true, true};
       Device device8 = new Device(testArray8, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device8));
    }
    
    @Test
    public void testNine() {
       boolean [] testArray9 = {false, true, false, true};
       Device device9 = new Device(testArray9, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device9));
    }
    
    @Test
    public void testTen() {
       boolean [] testArray10 = {true, false, false, true};
       Device device10 = new Device(testArray10, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device10));
    }
    
    @Test
    public void test11() {
       boolean [] testArray11 = {true, false, true, false};
       Device device11 = new Device(testArray11, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device11));
    }
    
    @Test
    public void test12() {
       boolean [] testArray12 = {true, true, true, false};
       Device device12 = new Device(testArray12, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device12));
    }
    
    @Test
    public void test13() {
       boolean [] testArray13 = {true, true, false, true};
       Device device13 = new Device(testArray13, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device13));
    }
    
    @Test
    public void test14() {
       boolean [] testArray14 = {true, false, true, true};
       Device device14 = new Device(testArray14, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device14));
    }
    
    @Test
    public void test15() {
       boolean [] testArray15 = {false, true, true, true};
       Device device15 = new Device(testArray15, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device15));
    }
    
    @Test
    public void test16() {
       boolean [] testArray16 = {true, true, true, true};
       Device device16 = new Device(testArray16, 2);
       assertTrue(FourBitTwoDisclosureDeviceUnlocker.unlock(device16));
    }
    
}
