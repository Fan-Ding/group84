package gui;

import module.TransactionList;
import module.UserList;

/**
 * @author ZouShiwen
 *
 */

public class SendEmailGUITest {

public static void main(String[] args) {
		
	    UserList userlist=new UserList();
	    TransactionList transactionlist=new TransactionList();
	    SendEmailGUI s=new SendEmailGUI(userlist, transactionlist);
		
	}
	
}
