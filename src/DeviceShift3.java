/**
 * Specialty Device that shifts by 3 bits each time
 */
public class DeviceShift3 extends CustomDevice {

    @Override
    public boolean spin() {
        if (super.isUnlocked()) {
            return true;
        } else {
            super.rotateOnce();
            super.rotateOnce();
            super.rotateOnce();
            return false;
        }

    }
}
