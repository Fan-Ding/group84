package gui;

import module.DockList;
import module.TransactionList;
import module.UserList;

/**
 * @author ZouShiwen
 *
 */

public class UsageInfoGUITest {
	
public static void main(String[] args) {
		
	    UserList userlist=new UserList();
	    TransactionList transactionlist=new TransactionList();
	    UsageInfoGUI u=new UsageInfoGUI(userlist, transactionlist);
		
	}

}
