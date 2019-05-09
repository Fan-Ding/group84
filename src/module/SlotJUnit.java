package module;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SlotJUnit {

	@Test
	void test() {
		Slot s = new Slot(true);
		assertEquals(true,s.isScooter());
	}

}
