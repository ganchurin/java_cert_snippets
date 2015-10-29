package building_blocks.bounds;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ByteBounds {

	@Test
	public void testUpperBound() {
		assertTrue((byte) (127) == 127);
		assertTrue((byte) (128) == -128);
	}

	@Test
	public void testLowerBound() {
		assertTrue((byte) (-128) == -128);
		assertTrue((byte) (-129) == 127);
	}


}