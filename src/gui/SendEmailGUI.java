package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import module.*;

public class SendEmailGUI {
	
	JFrame frame;
	JPanel panel1,panel2,panel3,panel4,panel5;
	JLabel label;
	JButton sbutton,ebutton,rbutton;
	JTextField textfield;
	JTextArea textarea;
	UserList userList;
	TransactionList transactionList;
	int id;
	
	public SendEmailGUI(UserList userlist, TransactionList transactionlist) {
		userList=userlist;
		transactionList=transactionlist;
		
		frame=new JFrame();
    	Font Font1=new Font("arial", Font.PLAIN, 20);
    	label=new JLabel("Please Enter the QM Number:");
    	label.setFont(Font1);
    	textfield=new JTextField(20);
    	textfield.setFont(Font1);
    	sbutton=new JButton("Search");
    	sbutton.setFont(Font1);
    	sbutton.addActionListener(new SearchButtonListener());
    	textarea=new JTextArea(40,45);
    	textarea.setFont(Font1);
    	textarea.setText("    Pick or Return     |       Time       |       Dock      |      Slot      |      Is Over Time\n");
    	ebutton=new JButton("Send An Email");
    	ebutton.setFont(Font1);
    	ebutton.addActionListener(new EmailButtonListener());
    	rbutton=new JButton("Return");
    	rbutton.setFont(Font1);
    	rbutton.addActionListener(new RetButtonListener());
    	panel1=new JPanel();
    	panel1.add(label);
    	panel2=new JPanel();
    	panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 60, 10));
    	panel2.add(textfield);
    	panel2.add(sbutton);
    	panel3=new JPanel();
    	panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
    	panel3.add(panel1);
    	panel3.add(panel2);
    	panel4=new JPanel();
    	panel4.add(textarea);
    	panel5=new JPanel();
    	panel5.setLayout(new FlowLayout(FlowLayout.LEFT, 100, 10));
    	panel5.add(ebutton);
    	panel5.add(rbutton);
    	frame.getContentPane().add(BorderLayout.NORTH, panel3);
    	frame.getContentPane().add(BorderLayout.CENTER, panel4);
    	frame.getContentPane().add(BorderLayout.SOUTH, panel5);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setVisible(true);
	}
    
    class SearchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String input=textfield.getText();
			id = Integer.parseInt(input);
			String[] line=transactionList.allUserTrans(id);
			for(String cell : line) {
				textarea.append(cell+"\n");
			}
			textfield.setText(""); 
			textfield.requestFocus();
		}
	}
    
    class EmailButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			transactionList.sendEmail(id);
		}
	}
    
    class RetButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
		}
	}
    
}
