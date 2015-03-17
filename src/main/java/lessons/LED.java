package lessons;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.BitSet;

/**
 * Represents the lighted portion of an LED. We use seven positions in an array
 * to represent each of the "pixels" of our display. Each of the positions of
 * the LED corresponds to a specific cell in our array and for the purposes of
 * display, its either on or off. We start numbering at the top, and work our
 * way, top-down, left to right. Using this approach, the representation of the
 * numbers 0-9 are the following:<br>
 * <br>
 * <table>
 * <tr>
 * <td>0</td>
 * <td>1110111</td>
 * <td>119</td>
 * </tr>
 * <tr>
 * <td>1</td>
 * <td>0010010</td>
 * <td>36</td>
 * </tr>
 * <tr>
 * <td>2</td>
 * <td>1011101</td>
 * <td>93</td>
 * </tr>
 * <tr>
 * <td>3</td>
 * <td>1011011</td>
 * <td>109</td>
 * </tr>
 * <tr>
 * <td>4</td>
 * <td>0111010</td>
 * <td>46</td>
 * </tr>
 * <tr>
 * <td>5</td>
 * <td>1101011</td>
 * <td>107</td>
 * </tr>
 * <tr>
 * <td>6</td>
 * <td>0101111</td>
 * <td>122</td>
 * </tr>
 * <tr>
 * <td>7</td>
 * <td>1010010</td>
 * <td>37</td>
 * </tr>
 * <tr>
 * <td>8</td>
 * <td>1111111</td>
 * <td>127</td>
 * </tr>
 * <tr>
 * <td>9</td>
 * <td>1111011</td>
 * <td>111</td>
 * </tr>
 * </table>
 * 
 * @author Jason Foster
 */
public class LED {

	private final BitSet pixels = new BitSet(7);
	private final ByteArrayOutputStream deviceStream;
	
	public LED(ByteArrayOutputStream outputStream) {
		if (outputStream == null)
			throw new IllegalArgumentException("output stream cannot be null");
		
		deviceStream = outputStream;
	}

	public boolean display(char value) {
		switch (value) {
		case '0':
			return set0();
		case '1':
			return set1();
		case '2':
			return set2();
		case '3':
			return set3();
		case '4':
			return set4();
		case '5':
			return set5();
		case '6':
			return set6();
		case '7':
			return set7();
		case '8':
			return set8();
		case '9':
			return set9();
		default:
			return false;
		}
	}

	private boolean set0() {
		// 0 1110111
		try {
			pixels.set(0);
			pixels.set(1);
			pixels.set(2);
			pixels.clear(3);
			pixels.set(4);
			pixels.set(5);
			pixels.set(6);
			deviceStream.write(pixels.toByteArray());
			deviceStream.flush();
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}

	private boolean set1() {
		// 1 0010010
		try {
			pixels.clear(0);
			pixels.clear(1);
			pixels.set(2);
			pixels.clear(3);
			pixels.clear(4);
			pixels.set(5);
			pixels.clear(6);
			deviceStream.write(pixels.toByteArray());
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}

	private boolean set2() {
		// 2 1011101
		try {
			pixels.set(0);
			pixels.clear(1);
			pixels.set(2);
			pixels.set(3);
			pixels.set(4);
			pixels.clear(5);
			pixels.set(6);
			deviceStream.write(pixels.toByteArray());
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}

	private boolean set3() {
		// 3 1011011
		try {
			pixels.set(0);
			pixels.clear(1);
			pixels.set(2);
			pixels.set(3);
			pixels.clear(4);
			pixels.set(5);
			pixels.set(6);
			deviceStream.write(pixels.toByteArray());
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}

	private boolean set4() {
		// 4 0111010
		try {
			pixels.clear(0);
			pixels.set(1);
			pixels.set(2);
			pixels.set(3);
			pixels.clear(4);
			pixels.set(5);
			pixels.clear(6);
			deviceStream.write(pixels.toByteArray());
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}

	private boolean set5() {
		// 5 1101011
		try {
			pixels.set(0);
			pixels.set(1);
			pixels.clear(2);
			pixels.set(3);
			pixels.clear(4);
			pixels.set(5);
			pixels.set(6);
			deviceStream.write(pixels.toByteArray());
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}

	private boolean set6() {
		// 6 0101111
		try {
			pixels.clear(0);
			pixels.set(1);
			pixels.clear(2);
			pixels.set(3);
			pixels.set(4);
			pixels.set(5);
			pixels.set(6);
			deviceStream.write(pixels.toByteArray());
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}

	private boolean set7() {
		// 7 1010010
		try {
			pixels.set(0);
			pixels.clear(1);
			pixels.set(2);
			pixels.clear(3);
			pixels.clear(4);
			pixels.set(5);
			pixels.clear(6);
			deviceStream.write(pixels.toByteArray());
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}

	private boolean set8() {
		// 8 1111111
		try {
			pixels.set(0);
			pixels.set(1);
			pixels.set(2);
			pixels.set(3);
			pixels.set(4);
			pixels.set(5);
			pixels.set(6);
			deviceStream.write(pixels.toByteArray());
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}

	private boolean set9() {
		// 9 1111011
		try {
			pixels.set(0);
			pixels.set(1);
			pixels.set(2);
			pixels.set(3);
			pixels.clear(4);
			pixels.set(5);
			pixels.set(6);
			deviceStream.write(pixels.toByteArray());
			return true;
		} catch (IOException ioEx) {
			return false;
		}
	}
}
