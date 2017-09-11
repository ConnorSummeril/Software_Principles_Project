public class Device
{
	public static final int DEFAULT_SIZE = 4;
	public static final int DEFAULT_PEEKS = 2;
	public static final char VALUE_TRUE = 'T';
	public static final char VALUE_FALSE = 'F';

	private boolean[] bitArray = new boolean[DEFAULT_SIZE];
	private int thebits = DEFAULT_PEEKS;

	public Device() {

	}

	public Device(boolean[] initialBits, int bitsPerPeek) {
		for(int i = 0; i < DEFAULT_SIZE; i++) {
			bitArray[i] = initialBits[i];
		}
		
		if(bitsPerPeek == DEFAULT_PEEKS) {
			thebits = bitsPerPeek;
		}

		
		for(int y = 0; y < DEFAULT_SIZE; y++) {
			System.out.println(bitArray[y]);
		}
		
		System.out.println("===========================");
		

	}

	public Device(int size, int bitsPerPeek) {

	}

	public boolean spin() {
		int countFalse = 0;
		int countTrue = 0;

		for(int i = 0; i < DEFAULT_SIZE; i++) {
			if(bitArray[i] == false) {
				countFalse++;
			}
		}

		for(int j = 0; j < DEFAULT_SIZE; j++) {
			if(bitArray[j] == true) {
				countTrue++;
			}
		}

		System.out.println("True Count: " + countTrue);


		if(countFalse == 4 || countTrue == 4) {
			return true;
		} else {
			int randomNum = (int) (Math.random() * 11);
			int tracker = 0;
			System.out.println("The Random Number: " + randomNum);
			boolean[] tmpArray = new boolean[DEFAULT_SIZE];
			while(tracker < randomNum) {
				tmpArray[0] = bitArray[3];
				tmpArray[1] = bitArray[0];
				tmpArray[2] = bitArray[1];
				tmpArray[3] = bitArray[2];

				bitArray[0] = tmpArray[0];
				bitArray[1] = tmpArray[1];
				bitArray[2] = tmpArray[2];
				bitArray[3] = tmpArray[3];

				tracker++;		
			}

			for(int y = 0; y < DEFAULT_SIZE; y++) {
				System.out.println(bitArray[y]);
			}

			System.out.println("===========================");

			return false;
		}
	}

	public CharSequence peek(CharSequence pattern) {
		System.out.println(pattern);
		//System.out.println(pattern.charAt(1));
		//System.out.println(pattern.charAt(5));

		CharSequence returnVal1 = "-";
		CharSequence returnVal2 = "-";
		CharSequence returnVal3 = "-";
		CharSequence returnVal4 = "-";

		if(pattern.charAt(1) == '?') {
			if(bitArray[0] == false) {
				returnVal1 =  String.valueOf(VALUE_FALSE);
				//return returnVal1;
			} else {
				returnVal1 = String.valueOf(VALUE_TRUE);
				//return returnVal1;
			}
		}

		if(pattern.charAt(3) == '?') {
			if(bitArray[1] == false) {
				returnVal2 =  String.valueOf(VALUE_FALSE);
				//return returnVal1;
			} else {
				returnVal2 = String.valueOf(VALUE_TRUE);
				//return returnVal1;
			}
		}

		if(pattern.charAt(5) == '?') {
			if(bitArray[2] == false) {
				returnVal3 =  String.valueOf(VALUE_FALSE);
				//return returnVal3;
			} else {
				returnVal3 = String.valueOf(VALUE_TRUE);
				//return returnVal3;
			}
		}	

		if(pattern.charAt(7) == '?') {
			if(bitArray[3] == false) {
				returnVal4 =  String.valueOf(VALUE_FALSE);
				//return returnVal3;
			} else {
				returnVal4 = String.valueOf(VALUE_TRUE);
				//return returnVal3;
			}
		}

		return "["+returnVal1+ " "+returnVal2+" "+returnVal3+" "+returnVal4+"]";
	} 



	public void poke(CharSequence pattern) {
		System.out.println(pattern);

		CharSequence returnVal1 = "-";
		CharSequence returnVal2 = "-";
		CharSequence returnVal3 = "-";
		CharSequence returnVal4 = "-";

		if(pattern.charAt(1) == 'T') {
			if(bitArray[0] == false) {
				returnVal1 = String.valueOf(VALUE_TRUE);
				bitArray[0] = true;
			}
		}

		if(pattern.charAt(3) == 'T') {
			if(bitArray[1] == false) {
				returnVal2 = String.valueOf(VALUE_TRUE);
				bitArray[1] = true;
			}
		}

		if(pattern.charAt(5) == 'T') {
			if(bitArray[2] == false) {
				returnVal3 = String.valueOf(VALUE_TRUE);
				bitArray[2] = true;
			}
		}

		if(pattern.charAt(7) == 'T') {
			if(bitArray[3] == false) {
				returnVal4 = String.valueOf(VALUE_TRUE);
				bitArray[3] = true;
			}
		}

	}

	public String toString() {
		return null;
	}
}


class Constructor
{
  public static void main(String[]agrs)
  {
  	boolean[] testArray = {false, true, true, false};
  	Device device = new Device(testArray, 2);
  	// System.out.println(device.spin());
  	int turns = 0;
  	boolean unlocked = false;
  	unlocked = device.spin();

  	if(unlocked == true) {
  		System.out.println("Device Unlocked");
  	} else {

	  	while (unlocked == false) {
	  		if(turns % 2 == 0) {
	  			// device.peek("[? - ? -]");
	  			// device.poke("[T - T -]");
	  			device.peek("[? ? - -]");
	  			device.poke("[T T - -]");
	  		} else {
	  			// device.peek("[- ? - ?]");
	  			// device.poke("[- T - T]");
	  			device.peek("[- ? - ?]");
	  			device.peek("[- T - T]");
	  		}
	  		turns++;
	  		unlocked = device.spin();
	  	}

	  	if(unlocked == true) {
  			System.out.println("Device Unlocked");
  		}

  	}

  	

  }
}