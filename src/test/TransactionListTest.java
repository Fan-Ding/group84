package test;

import control.TransactionList;

/**
 * test transactionList
 * @author Yinze Li
 * TODO
 */
public class TransactionListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TransactionList t = new TransactionList();
		t.sendEmail(161189148);
//		t.newTrans(161189148, 1, 2, true);
		t.loadTrans();
//		String[] s = t.allTrans();
//		System.out.println(s[0]+s[1]);
	}

}
