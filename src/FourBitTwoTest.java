import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FourBitTwoTest {

	@Test
	public void testOne() {
		FourBitTwoDisclosureDeviceUnlocker test1 = new 
              FourBitTwoDisclosureDeviceUnlocker();
		boolean[] testArray1 = {false, false, false, false};
        Device device1 = new Device(testArray1, 2);
		assertThat(test1.unlock(device1), is(true));
	}
	
    @Test
    public void testTwo() {
        FourBitTwoDisclosureDeviceUnlocker test2 = new 
              FourBitTwoDisclosureDeviceUnlocker();
        boolean [] testArray2 = {false, false, false, true};
        Device device2 = new Device(testArray2, 2);
  		assertThat(test2.unlock(device2), is(true));
    }
    
    @Test
    public void testThree() {
        FourBitTwoDisclosureDeviceUnlocker test3 = new 
                 FourBitTwoDisclosureDeviceUnlocker();
        boolean [] testArray3 = {false, false, true, false};
        Device device3 = new Device(testArray3, 2);
        assertThat(test3.unlock(device3), is(true));
    }
    
    @Test
    public void testFour() {
    	   FourBitTwoDisclosureDeviceUnlocker test4 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray4 = {false, true, false, false};
       Device device4 = new Device(testArray4, 2);
       assertThat(test4.unlock(device4), is(true));
    }

    @Test
    public void testFive() {
    	FourBitTwoDisclosureDeviceUnlocker test5 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray5 = {true, false, false, false};
       Device device5 = new Device(testArray5, 2);
       assertThat(test5.unlock(device5), is(true));
    }
    
    @Test
    public void testSix() {
    	FourBitTwoDisclosureDeviceUnlocker test6 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray6 = {true, true, false, false};
       Device device6 = new Device(testArray6, 2);
       assertThat(test6.unlock(device6), is(true));
    }
    
    @Test
    public void testSeven() {
    	FourBitTwoDisclosureDeviceUnlocker test7 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray7 = {false, true, true, false};
       Device device7 = new Device(testArray7, 2);
       assertThat(test7.unlock(device7), is(true));
    }
    
    @Test
    public void testEight() {
    	FourBitTwoDisclosureDeviceUnlocker test8 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray8 = {false, false, true, true};
       Device device8 = new Device(testArray8, 2);
       assertThat(test8.unlock(device8), is(true));
    }
    
    @Test
    public void testNine() {
      FourBitTwoDisclosureDeviceUnlocker test9 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray9 = {false, true, false, true};
       Device device9 = new Device(testArray9, 2);
       assertThat(test9.unlock(device9), is(true));
    }
    
    @Test
    public void testTen() {
    	   FourBitTwoDisclosureDeviceUnlocker test10 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray10 = {true, false, false, true};
       Device device10 = new Device(testArray10, 2);
       assertThat(test10.unlock(device10), is(true));
    }
    
    @Test
    public void test11() {
    	FourBitTwoDisclosureDeviceUnlocker test11 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray11 = {true, false, true, false};
       Device device11 = new Device(testArray11, 2);
       assertThat(test11.unlock(device11), is(true));
    }
    
    @Test
    public void test12() {
    	FourBitTwoDisclosureDeviceUnlocker test12 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray12 = {true, true, true, false};
       Device device12 = new Device(testArray12, 2);
       assertThat(test12.unlock(device12), is(true));
    }
    
    @Test
    public void test13() {
    	FourBitTwoDisclosureDeviceUnlocker test13 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray13 = {true, true, false, true};
       Device device13 = new Device(testArray13, 2);
       assertThat(test13.unlock(device13), is(true));
    }
    
    @Test
    public void test14() {
    	FourBitTwoDisclosureDeviceUnlocker test14 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray14 = {true, false, true, true};
       Device device14 = new Device(testArray14, 2);
       assertThat(test14.unlock(device14), is(true));
    }
    
    @Test
    public void test15() {
    	FourBitTwoDisclosureDeviceUnlocker test15 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray15 = {false, true, true, true};
       Device device15 = new Device(testArray15, 2);
       assertThat(test15.unlock(device15), is(true));
    }
    
    @Test
    public void test16() {
    	FourBitTwoDisclosureDeviceUnlocker test16 = new 
                FourBitTwoDisclosureDeviceUnlocker();
       boolean [] testArray16 = {true, true, true, true};
       Device device16 = new Device(testArray16, 2);
       assertThat(test16.unlock(device16), is(true));
    }
    
}
