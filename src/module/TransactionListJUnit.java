package module;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransactionListJUnit {

	@Test
	void test() {
		TransactionList t = new TransactionList();
		assertNotNull(t.allTrans());
		System.out.print("2222"+t.allUserTrans(0));
		assertNull(t.allUserTrans(0));
	}

}
