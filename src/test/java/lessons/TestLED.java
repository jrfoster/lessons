package lessons;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.util.BitSet;

import org.junit.Test;

public class TestLED {

	@Test
	public void testDisplay() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		LED led = new LED(baos);
		
		assertTrue(led.display('0'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {119}).toString());
		assertTrue(led.display('1'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {36}).toString());
		assertTrue(led.display('2'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {93}).toString());
		assertTrue(led.display('3'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {109}).toString());
		assertTrue(led.display('4'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {46}).toString());
		assertTrue(led.display('5'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {107}).toString());
		assertTrue(led.display('6'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {122}).toString());
		assertTrue(led.display('7'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {37}).toString());
		assertTrue(led.display('8'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {127}).toString());
		assertTrue(led.display('9'));
		System.out.println(baos);
		//assertEquals(led.toString(), BitSet.valueOf(new byte[] {111}).toString());
		
		for (char c = 0; c < 256; c++) {
			if (c >= 48 && c <= 57)
			   assertTrue(led.display(c));
			else
			   assertFalse(led.display(c));
		}
	}
}
