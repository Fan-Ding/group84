package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.TransactionList;
/**
 * Test transactionlist
 * @author Yinze Li
 * @Date 2019��5��30������9:39:06
 * TODO
 */
class TransactionListJUnit {

	@Test
	void test() {
		TransactionList t = new TransactionList();
		assertNotNull(t.allTrans());
		System.out.print("2222"+t.allUserTrans(0));
		assertNull(t.allUserTrans(0));
	}

}
