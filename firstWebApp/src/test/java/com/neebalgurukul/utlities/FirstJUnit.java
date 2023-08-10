
package com.neebalgurukul.utlities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.neebalgurukul.utilities.AreaUtlities;

public class FirstJUnit{
	
	@Test
	public void testGetAreaRectangle() {
		
		
		AreaUtlities aUtil = new AreaUtlities();
		int l = 4;
		int b = 3;
		int expectedOutput = 12;
		int actualOutput = aUtil.getAreaRectange(l, b);
		
		assertEquals(expectedOutput, actualOutput);
		
	}
	
	@Test
	public void testGetPerimeterRectangle() {
		
		
		AreaUtlities aUtil = new AreaUtlities();
		int l = 4;
		int b = 3;
		int expectedOutput = 14;
		int actualOutput = aUtil.getPerimeterRectange(l, b);
		
		assertEquals(expectedOutput, actualOutput);
		
	}
	
	@Test
	public void testIsRectShape() {
		AreaUtlities aUtil = new AreaUtlities();
		int l = 4;
		int b = 3;
		boolean actualOutput = aUtil.isRectShape(l, b);
		assertTrue(actualOutput);
	}
}


