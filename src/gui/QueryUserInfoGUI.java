package gui;

import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import module.*;

public class QueryUserInfoGUI implements ActionListener{
	
	private JFrame frame;
	private JTable table;
	private JTextField field;
	private JButton search;
	private JButton ban;
	private JButton unban;
	private JButton unuse;
	private JLabel label;
	private UserList userList;

	public QueryUserInfoGUI(UserList userList) {
		this.userList = userList;
		startFrame();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void startFrame() {
		frame = new JFrame("Query User Information");
		table = new JTable(userList.length(), 5);
		field = new JTextField();
		search = new JButton("search");
		ban = new JButton("ban");
		unban = new JButton("unban");
		unuse = new JButton("unuse");
		label = new JLabel();
		frame.setVisible(true);
		
	}

}
