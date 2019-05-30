package test;

import boundary.ManagerFunctionGUI;
import control.DockList;
import control.TransactionList;
import control.UserList;

class ManagerFunctionGUITest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DockList dockList = new DockList();
		UserList userList = new UserList();
		TransactionList transactionList = new TransactionList();
		ManagerFunctionGUI managerFunctionGUI = new ManagerFunctionGUI(dockList, userList, transactionList);
	}

}
