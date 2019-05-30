package test;

import boundary.UsageInfoGUI;
import control.DockList;
import control.TransactionList;
import control.UserList;

/** 
* A test class for UsageInfoGUI. 
* 
* <p> The class trigger GUI of displaying all scooter usage information.
* 
* @author Zou Shiwen 
* @version 1.0 
* @since 22th April, 2019
* @see control.DockList
*/ 

public class UsageInfoGUITest {
	
public static void main(String[] args) {
		
	    UserList userlist=new UserList();
	    TransactionList transactionlist=new TransactionList();
	    UsageInfoGUI u=new UsageInfoGUI(userlist, transactionlist);
		
	}

}
