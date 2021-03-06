
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;


public class UnlockerRaceTest {

    @Test
    public void originalTimer() throws Exception {
        FourBitTwoDisclosureDeviceUnlocker unlocker = new FourBitTwoDisclosureDeviceUnlocker();
        Device device = new Device();
        CustomDevice random = new CustomDevice();
        DeviceShift1 shift1 = new DeviceShift1();
        DeviceShift2 shift2 = new DeviceShift2();
        DeviceShift3 shift3 = new DeviceShift3();
        DeviceNeverShift never = new DeviceNeverShift();
        SinusoidalDevice sinusoidal = new SinusoidalDevice();

        long startTime = System.nanoTime();
        Assert.assertThat(unlocker.unlock(device), Is.is(true));
        Assert.assertThat(unlocker.unlock(random), Is.is(true));
        Assert.assertThat(unlocker.unlock(shift1), Is.is(true));
        Assert.assertThat(unlocker.unlock(shift2), Is.is(true));
        Assert.assertThat(unlocker.unlock(shift3), Is.is(true));
        Assert.assertThat(unlocker.unlock(never), Is.is(true));
        Assert.assertThat(unlocker.unlock(sinusoidal), Is.is(true));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("FourBitTwoDisclosure finishes unlocking 7 devices in : " + duration + " nano seconds");
    }

    @Test
    public void simpleTimer() throws Exception {
        SimpleDeviceUnlocker unlocker = new SimpleDeviceUnlocker();
        Device device = new Device();
        CustomDevice random = new CustomDevice();
        DeviceShift1 shift1 = new DeviceShift1();
        DeviceShift1 balance = new DeviceShift1();
        DeviceShift2 shift2 = new DeviceShift2();
        DeviceShift3 shift3 = new DeviceShift3();
        DeviceNeverShift never = new DeviceNeverShift();
        SinusoidalDevice sinusoidal = new SinusoidalDevice();

        long startTime = System.nanoTime();
        Assert.assertThat(unlocker.unlock(device), Is.is(true));
        Assert.assertThat(unlocker.unlock(random), Is.is(true));
        Assert.assertThat(unlocker.unlock(shift1), Is.is(true));
        Assert.assertThat(unlocker.unlock(shift2), Is.is(true));
        Assert.assertThat(unlocker.unlock(shift3), Is.is(true));
       // assertThat(unlocker.unlock(never), is(true)); the never shift device will not be unlocked with simple algorithm
        Assert.assertThat(unlocker.unlock(balance), Is.is(true)); //added another shift1 device for fairness.
        Assert.assertThat(unlocker.unlock(sinusoidal), Is.is(true));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("SimpleDeviceUnlocker finishes unlocking 7 devices in : " + duration + " nano seconds");
    }

    @Test
    public void linearTimer() throws Exception {
        LinearDeviceUnlocker unlocker = new LinearDeviceUnlocker();
        Device device = new Device();
        CustomDevice random = new CustomDevice();
        DeviceShift1 shift1 = new DeviceShift1();
        DeviceShift2 shift2 = new DeviceShift2();
        DeviceShift3 shift3 = new DeviceShift3();
        DeviceNeverShift never = new DeviceNeverShift();
        SinusoidalDevice sinusoidal = new SinusoidalDevice();

        long startTime = System.nanoTime();
        Assert.assertThat(unlocker.unlock(device), Is.is(true));
        Assert.assertThat(unlocker.unlock(random), Is.is(true));
        Assert.assertThat(unlocker.unlock(shift1), Is.is(true));
        Assert.assertThat(unlocker.unlock(shift2), Is.is(true));
        Assert.assertThat(unlocker.unlock(shift3), Is.is(true));
        Assert.assertThat(unlocker.unlock(never), Is.is(true));
        Assert.assertThat(unlocker.unlock(sinusoidal), Is.is(true));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.println("Linear unlocker finishes unlocking 7 devices in : " + duration + " nano seconds");
    }
}