/**
 * Specialty class which shifts by 2 bits every time
 */
public class DeviceShift2 extends CustomDevice {

    @Override
    public boolean spin() {
        if (super.isUnlocked()) {
            return true;
        } else {
            super.rotateOnce();
            super.rotateOnce();
            return false;
        }

    }
}
