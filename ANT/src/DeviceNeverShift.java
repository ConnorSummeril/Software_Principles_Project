/**
 * Specialty Device that never shifts
 */
public class DeviceNeverShift extends CustomDevice {

    @Override
    public boolean spin() {
        if (super.isUnlocked()) {
            return true;
        } else {
            return false;
        }
    }
}
