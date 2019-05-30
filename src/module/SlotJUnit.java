package module;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * test slot
 * @author Yinze Li
 * @Date 2019年5月30日下午9:40:28
 * TODO
 */
class SlotJUnit {

	@Test
	void test() {
		Slot s = new Slot(true);
		assertEquals(true,s.isScooter());
	}

}
