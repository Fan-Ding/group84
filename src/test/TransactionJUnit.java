package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.Test;

import entity.Transaction;
/**
 * test transaction
 * @author Yinze Li
 * @Date 2019年5月30日下午9:39:47
 * TODO
 */
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
