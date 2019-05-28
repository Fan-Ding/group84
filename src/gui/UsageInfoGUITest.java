package gui;

import module.DockList;
import module.TransactionList;
import module.UserList;

/** 
* A test class for UsageInfoGUI. 
* 
* <p> The class trigger GUI of displaying all scooter usage information.
* 
* @author Zou Shiwen 
* @version 1.0 
* @since 22th April, 2019
* @see module.DockList
*/ 

public class UsageInfoGUITest {
	
public static void main(String[] args) {
		
	    UserList userlist=new UserList();
	    TransactionList transactionlist=new TransactionList();
	    UsageInfoGUI u=new UsageInfoGUI(userlist, transactionlist);
		
	}

}
