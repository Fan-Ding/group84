package gui;

import module.DockList;
import module.TransactionList;
import module.UserList;

class UserDockSelectGUITest {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DockList dockList = new DockList();
		UserList userList = new UserList();
		TransactionList transactionList = new TransactionList();
		UserDockSelectGUI userDockSelectGUI = new UserDockSelectGUI(dockList, userList, transactionList);
		
		
	}

}
