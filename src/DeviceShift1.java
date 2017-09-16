/**
 * The specialty device which shifts only 1 bit each spin
 */
public class DeviceShift1 extends CustomDevice {


    @Override
    public boolean spin() {
        if (super.isUnlocked()) {
            return true;
        } else {
            super.rotateOnce();
            return false;
        }
    }
}
