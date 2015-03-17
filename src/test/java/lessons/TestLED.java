package lessons;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail; 

import java.io.ByteArrayOutputStream;
import java.util.Arrays;

import org.junit.Test;

public class TestLED {

	@Test
	public void testDisplay() {
		ByteArrayOutputStream baos = null;
		
		try {
			baos = new ByteArrayOutputStream();
			LED led = new LED(baos);
			
			assertTrue(led.display('0'));
			assertTrue(led.display('1'));
			assertTrue(led.display('2'));
			assertTrue(led.display('3'));
			assertTrue(led.display('4'));
			assertTrue(led.display('5'));
			assertTrue(led.display('6'));
			assertTrue(led.display('7'));
	 		assertTrue(led.display('8'));
			assertTrue(led.display('9'));
			assertTrue(Arrays.equals(baos.toByteArray(), 
					new byte[] {119,36,93,109,46,107,122,37,127,111}));
			
			
			for (char c = 0; c < 256; c++) {
				if (c >= 48 && c <= 57)
				   assertTrue(led.display(c));
				else
				   assertFalse(led.display(c));
			}
		} catch (Exception ex) {
			fail(ex.getMessage());
		} finally {
			if (baos != null) {
				try { baos.close(); } catch (Exception ignored) {}				
			}
		}
	}
}
