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
	private PayaFine payaFine;
    private int Qmnum;
    private FtoSelectDock ftos;
    private Brep brep;
    private Rrep rrep;
    private ReturnScootersGUI ret;
    private SelectScootersGUI sel;


	public DockFunctionGUI(int dockNum,DockList docklist, UserList userlist, TransactionList transactionlist) {
		JFrame jf = new JFrame("Enter QM number");
		Toolkit tk = this.getToolkit();// 得到窗口工具条
		int width = 650;
		int height = 500;
		Dimension dm = tk.getScreenSize();
		jf.setLocation((int) (dm.getWidth() - width) / 2,
				(int) (dm.getHeight() - height) / 2);// 显示在屏幕中央
		
		jf.setSize(450, 300);// 设置程序的大小
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//只关闭当前窗口设置
		jf.setVisible(true);
		contentPane = new JPanel();
		jf.setContentPane(contentPane);
		contentPane.setLayout(null);

		//归还按钮
		JButton btnReturn = new JButton("Return"); 
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnReturn)
		        {
		            if((docklist.howManyScooter(dockNum))>7) {//dock内8辆车，slot全满   
		            	 ftos = new FtoSelectDock();//还车失败GUI
		            	 }
				    else{//有空位还车
				    	if(userlist.isUsing(Qmnum)==true) {//用户正在用车
			           ret = new ReturnScootersGUI(Qmnum,dockNum,docklist,userlist); //跳到还车GUI
					   }
				    	else {//用户未借车
				    		rrep = new Rrep();//重复还车GUI
				    	}				    			    		
					   }  
		        }
			}
		});
		btnReturn.setBounds(329, 167, 97, 47);
		contentPane.add(btnReturn);
		btnReturn.setVisible(false);
		
		//罚金按钮		
		JButton btnPay = new JButton("Pay Fine");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnPay)
		        {				 
		           payaFine = new PayaFine(Qmnum,userlist);//跳到罚款GUI
		        }
			}
		});
		btnPay.setBounds(10, 167, 97, 47);
		contentPane.add(btnPay);
		btnPay.setVisible(false);
		
		//借车按钮		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBorrow)
     	        {
					if(userlist.isBan(Qmnum)==true) {//用户被ban，跳到罚金
						payaFine = new PayaFine(Qmnum,userlist);
					}
					else if(userlist.isBan(Qmnum)==false){//用户没ban											
					 if((docklist.howManyScooter(dockNum))<1) {//Dock没有车可借		        	     
		            	 ftos = new FtoSelectDock();//还车失败GUI
		            	 }		            	
		            else{//Dock有车可借
		            	if(userlist.isUsing(Qmnum)==false) {//用户未使用车
		            	sel = new SelectScootersGUI(Qmnum,dockNum,docklist,userlist);//跳到借车GUI
                        }
		            	else {//用户已经用了一辆车
		            		brep = new Brep();//重复借车GUI
		            	}
					 }
					}
		        }
			}			
		});
		btnBorrow.setBounds(168, 167, 97, 47);
		contentPane.add(btnBorrow);
		btnBorrow.setVisible(false);
		
		//三个标签		
		JLabel lblTitle = new JLabel("Please enter your QM number to borrow, return or pay fines");
		lblTitle.setFont(new Font("微軟正黑體", Font.PLAIN, 14));
		lblTitle.setBounds(10, 15, 416, 47);
		contentPane.add(lblTitle);
		
		JLabel lblWar1 = new JLabel("\u221APlease select the next step!");
		lblWar1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblWar1.setForeground(Color.GREEN);
		lblWar1.setBounds(150, 97, 226, 15);
		contentPane.add(lblWar1);
		lblWar1.setVisible(false);
		
		JLabel lblWar2 = new JLabel("\u00D7Please check your number again!");
		lblWar2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblWar2.setForeground(Color.RED);
		lblWar2.setBounds(150, 122, 248, 15);
		contentPane.add(lblWar2);
		lblWar2.setVisible(false);
		
		//输入QM文本框
		tf1 = new JTextField();
		tf1.setBounds(10, 96, 87, 41);
		contentPane.add(tf1);
		tf1.setColumns(10);		
		tf1.addActionListener(new ActionListener() {//监听回车
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==tf1)
				  {
				    Qmnum = Integer.parseInt(tf1.getText());//获取文本框输入
				    
					   if(userlist.search(Qmnum)>=0) {//输入的学号已注册
						   lblWar1.setVisible(true);
						   lblWar2.setVisible(false);
						//   tf1.setText(Qmnum+" is a right QM number in system");
						   btnPay.setVisible(true);
						   btnReturn.setVisible(true);
						   btnBorrow.setVisible(true);
					   }
					   else {
						   tf1.setText("");            //输入学号未注册
						   lblWar1.setVisible(false);
						   lblWar2.setVisible(true);
				      //     tf1.setText("Wrong number or not enroll, please check again!");
				           btnPay.setVisible(false);
						   btnReturn.setVisible(false);
						   btnBorrow.setVisible(false);
					   }
				  				   
				  }
			};					
		});
				
		JLabel lblRem = new JLabel("(Press \"Enter\" to check your QM number with 9 digits)");
		lblRem.setBounds(48, 72, 340, 15);
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
