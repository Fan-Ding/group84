package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.Slot;

/**
 * test slot
 * @author Yinze Li
 * @Date 2019��5��30������9:40:28
 * TODO
 */
class SlotJUnit {

	@Test
	void test() {
		Slot s = new Slot(true);
		assertEquals(true,s.isScooter());
	}

}
