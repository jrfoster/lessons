package lessons;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.nio.ByteBuffer;

import org.junit.Test;

public class TestLED {

	@Test
	public void testDisplay() {
		try {
			ByteBuffer buff = ByteBuffer.allocate(1);
			LED led = new LED(buff);

			assertTrue(led.display('0'));
			assertTrue((byte) 119 == buff.get(0));
			assertTrue(led.display('1'));
			assertTrue((byte) 36 == buff.get(0));
			assertTrue(led.display('2'));
			assertTrue((byte) 93 == buff.get(0));
			assertTrue(led.display('3'));
			assertTrue((byte) 109 == buff.get(0));
			assertTrue(led.display('4'));
			assertTrue((byte) 46 == buff.get(0));
			assertTrue(led.display('5'));
			assertTrue((byte) 107 == buff.get(0));
			assertTrue(led.display('6'));
			assertTrue((byte) 122 == buff.get(0));
			assertTrue(led.display('7'));
			assertTrue((byte) 37 == buff.get(0));
			assertTrue(led.display('8'));
			assertTrue((byte) 127 == buff.get(0));
			assertTrue(led.display('9'));
			assertTrue((byte) 111 == buff.get(0));

			for (char c = 0; c < 256; c++) {
				if (c >= 48 && c <= 57)
					assertTrue(led.display(c));
				else
					assertFalse(led.display(c));
			}
		} catch (Exception ex) {
			fail(ex.getMessage());
		}
	}
}
