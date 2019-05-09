package module;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

class TransactionJUnit {

	@Test
	void test() {
		Calendar cal = Calendar.getInstance();
		Transaction t = new Transaction(123456789,0,0,true,cal, false);
		assertEquals(false,t.isOverTime());
		assertNotNull(t.getCal());
		assertNotNull(t.transToString());
//		fail("Not yet implemented");
	}

}
