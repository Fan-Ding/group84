package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import module.DockList;
import module.TransactionList;
import module.UserList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Dimension;

public class DockFunctionGUI extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
    public int index0 = 0;
    boolean Isban = false;
    int Qmnum;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DockFunctionGUI frame = new DockFunctionGUI(dockNum,docklist,userlist,transactionlist);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public DockFunctionGUI(int dockNum,DockList docklist, UserList userlist, TransactionList transactionlist) {
		JFrame jf = new JFrame("main");
		Toolkit tk = this.getToolkit();// 得到窗口工具条
		int width = 650;
		int height = 500;
		Dimension dm = tk.getScreenSize();
		jf.setLocation((int) (dm.getWidth() - width) / 2,
				(int) (dm.getHeight() - height) / 2);// 显示在屏幕中央
		
		jf.setSize(450, 300);// 设置程序的大小
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setVisible(true);
		contentPane = new JPanel();
		jf.setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JButton btnReturn = new JButton("Return");                                         //归还按钮
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnReturn)
		        {
		            if((docklist.howManyScooter(dockNum))>7) {		      
		            	 new FtoSelectDock();//还车失败gui
		            	 setVisible(true);}
				    else{
			           new ReturnScootersGUI(Qmnum,dockNum,docklist,userlist); //跳到tzj还车GUI
					   setVisible(true); }  
		        }
			}
		});
		btnReturn.setBounds(329, 167, 97, 47);
		contentPane.add(btnReturn);
		btnReturn.setVisible(false);
		
		
		JButton btnPay = new JButton("Pay Fine");//罚金按钮
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnPay)
		        {
				 
		           new PayaFine(Qmnum,userlist);
		           setVisible(true);
		        }
			}
		});
		btnPay.setBounds(10, 167, 97, 47);
		contentPane.add(btnPay);
		btnPay.setVisible(false);
		
		
		JButton btnBorrow = new JButton("Borrow");//借车按钮
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBorrow)
		        {
					if(userlist.isBan(Qmnum)==true) {
						new PayaFine(Qmnum,userlist);
				           setVisible(true);
					}
					else if(userlist.isBan(Qmnum)==false){						
					
					 if((docklist.howManyScooter(dockNum))<1) {
		        	     
		            	 new FtoSelectDock();//还车失败gui
		            	 setVisible(true);
		            	 }
		            	
		            else{
		            	new SelectScootersGUI(Qmnum,dockNum,docklist,userlist);//跳到tzj借车GUI
					    setVisible(true);
					 }
					}
		        }
			}
			
		});
		btnBorrow.setBounds(168, 167, 97, 47);
		contentPane.add(btnBorrow);
		btnBorrow.setVisible(false);
		
		
		JLabel lblTitle = new JLabel("Please enter your QM number to borrow, return or pay fines");
		lblTitle.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblTitle.setBounds(10, 0, 416, 83);
		contentPane.add(lblTitle);
		
		
		tf1 = new JTextField();
		tf1.setBounds(20, 116, 395, 41);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==tf1)
				  {
				    Qmnum = Integer.parseInt(tf1.getText());
				    
					   if(userlist.search(Qmnum)>=0) {						   
						   tf1.setText(Qmnum+" is a right QM number in system");
						   btnPay.setVisible(true);
						   btnReturn.setVisible(true);
						   btnBorrow.setVisible(true);
					   }
					   else {
						   tf1.setText("");            //在文本框按下回车键，将文本框内容清空，并在其中显示Warning
				           tf1.setText("Wrong number or not enroll, please check again!");
				           btnPay.setVisible(false);
						   btnReturn.setVisible(false);
						   btnBorrow.setVisible(false);
					   }
				  				   
				  }
			};
		
			
		});
		
		
		JLabel lblRem = new JLabel("(Press \"Enter\" to check your QM number)");
		lblRem.setBounds(78, 73, 302, 15);
		contentPane.add(lblRem);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(168, 228, 97, 23);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBack)
		        {
					jf.dispose();
		        }
            }
		});
		
		jf.setVisible(true);
	}
}
