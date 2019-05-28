package gui;

import module.DockList;
import module.TransactionList;
import module.UserList;

/** 
* A test class for DockStateGUI. 
* 
* <p> The class trigger GUI of displaying slots states.
* 
* @author Zou Shiwen 
* @version 1.0 
* @since 24th April, 2019
* @see module.DockList
*/ 

public class DockStateGUITest {
	
	public static void main(String[] args) {
		
		int dock=0;
		DockList docklist=new DockList();
		DockStateGUI d=new DockStateGUI(dock, docklist);
		
	}

}
