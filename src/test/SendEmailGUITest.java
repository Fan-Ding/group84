package test;

import boundary.SendEmailGUI;
import control.TransactionList;
import control.UserList;

/** 
* A test class for SendEmailGUI. 
* 
* <p> The class trigger GUI of displaying user's transactions,
* and send email to user.
* 
* @author Zou Shiwen 
* @version 1.0 
* @since 27th April, 2019
* @see control.TransactionList
*/ 

public class SendEmailGUITest {

public static void main(String[] args) {
		
	    UserList userlist=new UserList();
	    TransactionList transactionlist=new TransactionList();
	    SendEmailGUI s=new SendEmailGUI(userlist, transactionlist);
		
	}
	
}
