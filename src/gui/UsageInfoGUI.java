package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import module.*;

/**
 * @author ZouShiwen
 *
 */
public class UsageInfoGUI {

	JFrame frame;
	JPanel panel1,panel2,panel3;
	JTextArea textarea;
	JButton button;
	UserList userList;
	TransactionList transactionList;
	
	/**
	  * Constructor displaying all usage information
	  */
	public UsageInfoGUI(UserList userlist,TransactionList transactionlist) {
		userList=userlist;
		transactionList=transactionlist;
		
		frame=new JFrame();
		Font Font1=new Font("arial", Font.PLAIN, 20);
		textarea=new JTextArea(30,40);
		textarea.setFont(Font1);
		String[] line=transactionList.allTrans();
		textarea.setText("       ID           | Dock | Slot | Is Picked  | Year |  Month |  Date |  Hour |  Minutes\n");
		for(int i=0;i<line.length;i++) {
				textarea.append(line[i]);
		}
		button=new JButton("Return");
		button.setFont(Font1);
		button.addActionListener(new ButtonListener());
		panel1=new JPanel();
		panel1.add(textarea);
		panel2=new JPanel();
		panel2.add(button);
		panel3=new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
		panel3.add(panel1);
		panel3.add(panel2);
		frame.getContentPane().add(BorderLayout.CENTER,panel3);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setVisible(true);
	}
	
	/**
	  * Subclass to perform action of returning to main GUI
	  */
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
		}
	}
	
}
