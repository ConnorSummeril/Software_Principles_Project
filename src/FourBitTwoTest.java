import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FourBitTwoTest {
	@Test
	public void TestOne() {
		FourBitTwoDisclosureDeviceUnlocker test1 = new FourBitTwoDisclosureDeviceUnlocker();
		boolean[] testArray1 = {false, false, false, false};

		Device device1 = new Device(testArray1, 2);
		// System.out.println("Outcome of Test: " + testLock.unlock(device1));
		assertThat(test1.unlock(device1), is(true));
         
	}
}