
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


public class UnlockerRaceTest {

    @Test
    public void originalTimer() throws Exception {
        Device device = new Device();
        CustomDevice random = new CustomDevice();
        DeviceShift1 shift1 = new DeviceShift1();
        DeviceShift2 shift2 = new DeviceShift2();
        DeviceShift3 shift3 = new DeviceShift3();
        DeviceNeverShift never = new DeviceNeverShift();
        SinusoidalDevice sinusoidal = new SinusoidalDevice();

        long startTime = System.nanoTime();
        Assert.assertThat(FourBitTwoDisclosureDeviceUnlocker.unlock(device), Is.is(true));
        Assert.assertThat(FourBitTwoDisclosureDeviceUnlocker.unlock(random), Is.is(true));
        Assert.assertThat(FourBitTwoDisclosureDeviceUnlocker.unlock(shift1), Is.is(true));
        Assert.assertThat(FourBitTwoDisclosureDeviceUnlocker.unlock(shift2), Is.is(true));
        Assert.assertThat(FourBitTwoDisclosureDeviceUnlocker.unlock(shift3), Is.is(true));
        //Assert.assertThat(FourBitTwoDisclosureDeviceUnlocker.unlock(never), Is.is(true));
        Assert.assertThat(FourBitTwoDisclosureDeviceUnlocker.unlock(sinusoidal), Is.is(true));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("FourBitTwoDisclosure finishes unlocking 7 devices in : " + duration + " nano seconds");
    }

    @Test
    public void simpleTimer() throws Exception {
        Device device = new Device();
        CustomDevice random = new CustomDevice();
        DeviceShift1 shift1 = new DeviceShift1();
        DeviceShift1 balance = new DeviceShift1();
        DeviceShift2 shift2 = new DeviceShift2();
        DeviceShift3 shift3 = new DeviceShift3();
        DeviceNeverShift never = new DeviceNeverShift();
        SinusoidalDevice sinusoidal = new SinusoidalDevice();

        long startTime = System.nanoTime();
        Assert.assertThat(SimpleDeviceUnlocker.unlock(device), Is.is(true));
        Assert.assertThat(SimpleDeviceUnlocker.unlock(random), Is.is(true));
        Assert.assertThat(SimpleDeviceUnlocker.unlock(shift1), Is.is(true));
        Assert.assertThat(SimpleDeviceUnlocker.unlock(shift2), Is.is(true));
        Assert.assertThat(SimpleDeviceUnlocker.unlock(shift3), Is.is(true));
        //Assert.assertThat(SimpleDeviceUnlocker.unlock(never), is(false)); the never shift device will not be unlocked with simple algorithm
        Assert.assertThat(SimpleDeviceUnlocker.unlock(balance), Is.is(true)); //added another shift1 device for fairness.
        Assert.assertThat(SimpleDeviceUnlocker.unlock(sinusoidal), Is.is(true));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("SimpleDeviceUnlocker finishes unlocking 7 devices in : " + duration + " nano seconds");
    }

    @Test
    public void linearTimer() throws Exception {
        Device device = new Device();
        CustomDevice random = new CustomDevice();
        DeviceShift1 shift1 = new DeviceShift1();
        DeviceShift2 shift2 = new DeviceShift2();
        DeviceShift3 shift3 = new DeviceShift3();
        DeviceNeverShift never = new DeviceNeverShift();
        SinusoidalDevice sinusoidal = new SinusoidalDevice();

        long startTime = System.nanoTime();
        Assert.assertThat(LinearDeviceUnlocker.unlock(device), Is.is(true));
        Assert.assertThat(LinearDeviceUnlocker.unlock(random), Is.is(true));
        Assert.assertThat(LinearDeviceUnlocker.unlock(shift1), Is.is(true));
        Assert.assertThat(LinearDeviceUnlocker.unlock(shift2), Is.is(true));
        Assert.assertThat(LinearDeviceUnlocker.unlock(shift3), Is.is(true));
        Assert.assertThat(LinearDeviceUnlocker.unlock(never), Is.is(true));
        Assert.assertThat(LinearDeviceUnlocker.unlock(sinusoidal), Is.is(true));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Linear unlocker finishes unlocking 7 devices in : " + duration + " nano seconds");
    }
}