package module;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class UserJUnit {

	@Test
	void test() {
		User u = new User(123456789,"lyz","lyz@qqq");
		assertEquals("lyz",u.getName());
		Calendar c = Calendar.getInstance();
		assertNull(u.getLastPick());
		u.setLastPick(c);
		assertEquals(c,u.getLastPick());
		assertEquals(0,u.getTodayUsingTime()[0]);
		assertEquals(false,u.isBanned());
	}

}
