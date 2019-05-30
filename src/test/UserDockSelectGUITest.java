package test;

import boundary.UserDockSelectGUI;
import control.DockList;
import control.TransactionList;
import control.UserList;

class UserDockSelectGUITest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DockList dockList = new DockList();
		UserList userList = new UserList();
		TransactionList transactionList = new TransactionList();
		UserDockSelectGUI userDockSelectGUI = new UserDockSelectGUI(dockList, userList, transactionList);
		
		
	}

}
