package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import entity.User;
/**
 * Test User
 * @author Yinze Li
 * @Date 2019年5月30日下午9:37:35
 * TODO
 */
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
