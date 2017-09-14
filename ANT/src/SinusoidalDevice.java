/**
* This device spins in a sequence which is sinusoidal.
*/

public class SinusoidalDevice extends Device {

    private int sineWave[] = {3, 4, 5, 6, 5, 4, 3, 2, 1, 0, 1, 2};
    private int sinePosition = 0;

    /**
     * The spin which matches the sinusoidal pattern.
     * @override
     */
    private void rotateBits() {
        if (sinePosition == sineWave.length) {
            sinePosition = 0;
        }
        for (int i = 0; i < sineWave[sinePosition]; i++) {
            this.rotateOnce();
        }
    }
    
    /**
     * Rotate the bits once to the right.
     */
    protected void rotateOnce() {
        super.rotateOnce();
    }
}