public class Device
{
	public static final int DEFAULT_SIZE = 4;
	public static final int DEFAULT_PEEKS = 2;
	public static final char VALUE_TRUE = 'T';
	public static final char VALUE_FALSE = 'F';

	private boolean[] bitArray = new boolean[DEFAULT_SIZE];
	private int thebits = DEFAULT_PEEKS;

	public Device() {
        // Values are already initialized for the default device.
	}

	public Device(boolean[] initialBits, int bitsPerPeek) {
		for(int i = 0; i < DEFAULT_SIZE; i++) {
			bitArray[i] = initialBits[i];
		}
		
		if(bitsPerPeek == DEFAULT_PEEKS) {
			thebits = bitsPerPeek;
		}
	}

	public Device(int size, int bitsPerPeek) {

	}

	public boolean spin() {
        if (this.isUnlocked()) {
            return true;
        } else {
            this.rotateBits();
            return false;
		}
	}

    /**
     * Return true if the device bitArray is unlocked, false otherwise.
     */ 
    private boolean isUnlocked() {
		int countFalse = 0;
		int countTrue = 0;
        for (int i = 0; i < DEFAULT_SIZE; i++) {
            if(bitArray[i] == false) {
				countFalse++;
			}
		}

		for (int j = 0; j < DEFAULT_SIZE; j++) {
			if(bitArray[j] == true) {
				countTrue++;
			}
		}

		if (countFalse == 4 || countTrue == 4) {
			return true;
		} else {
            return false;
        }
    }
    /**
     * Rotate the "bits" in the internal boolean array in some fashion.
     */
    private void rotateBits() {
        int randomNum = (int) (Math.random() * 11);
        int tracker = 0;
        while(tracker < randomNum) {
            this.rotateOnce();
            tracker++;		
        }
    }

    /**
     * Rotate the array once to the right.
     */
    protected void rotateOnce() {
        boolean[] tempArray = new boolean[DEFAULT_SIZE];
        tempArray[0] = bitArray[3];
        tempArray[1] = bitArray[0];
        tempArray[2] = bitArray[1];
        tempArray[3] = bitArray[2];

        bitArray[0] = tempArray[0];
        bitArray[1] = tempArray[1];
        bitArray[2] = tempArray[2];
        bitArray[3] = tempArray[3];
    }

	public CharSequence peek(CharSequence pattern) {
		CharSequence returnVal1 = "-";
		CharSequence returnVal2 = "-";
		CharSequence returnVal3 = "-";
		CharSequence returnVal4 = "-";

		if(pattern.charAt(0) == '?') {
			if(bitArray[0] == false) {
				returnVal1 =  String.valueOf(VALUE_FALSE);
				//return returnVal1;
			} else {
				returnVal1 = String.valueOf(VALUE_TRUE);
				//return returnVal1;
			}
		}

		if(pattern.charAt(1) == '?') {
			if(bitArray[1] == false) {
				returnVal2 =  String.valueOf(VALUE_FALSE);
				//return returnVal1;
			} else {
				returnVal2 = String.valueOf(VALUE_TRUE);
				//return returnVal1;
			}
		}

		if(pattern.charAt(2) == '?') {
			if(bitArray[2] == false) {
				returnVal3 =  String.valueOf(VALUE_FALSE);
				//return returnVal3;
			} else {
				returnVal3 = String.valueOf(VALUE_TRUE);
				//return returnVal3;
			}
		}	

		if(pattern.charAt(3) == '?') {
			if(bitArray[3] == false) {
				returnVal4 =  String.valueOf(VALUE_FALSE);
				//return returnVal3;
			} else {
				returnVal4 = String.valueOf(VALUE_TRUE);
				//return returnVal3;
			}
		}

		return "" + returnVal1 + returnVal2 + returnVal3 + returnVal4;
	} 


	public void poke(CharSequence pattern) {
		CharSequence returnVal1 = "-";
		CharSequence returnVal2 = "-";
		CharSequence returnVal3 = "-";
		CharSequence returnVal4 = "-";

		if(pattern.charAt(0) == 'T') {
			if(bitArray[0] == false) {
				returnVal1 = String.valueOf(VALUE_TRUE);
				bitArray[0] = true;
			}
		}

		if(pattern.charAt(1) == 'T') {
			if(bitArray[1] == false) {
				returnVal2 = String.valueOf(VALUE_TRUE);
				bitArray[1] = true;
			}
		}

		if(pattern.charAt(2) == 'T') {
			if(bitArray[2] == false) {
				returnVal3 = String.valueOf(VALUE_TRUE);
				bitArray[2] = true;
			}
		}

		if(pattern.charAt(3) == 'T') {
			if(bitArray[3] == false) {
				returnVal4 = String.valueOf(VALUE_TRUE);
				bitArray[3] = true;
			}
		}

	}

    //  @Override
    public String toString() {
        return null;
    }
}
