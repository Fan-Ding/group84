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
		Toolkit tk = this.getToolkit();// �õ����ڹ�����
		int width = 650;
		int height = 500;
		Dimension dm = tk.getScreenSize();
		jf.setLocation((int) (dm.getWidth() - width) / 2,
				(int) (dm.getHeight() - height) / 2);// ��ʾ����Ļ����
		
		jf.setSize(450, 300);// ���ó���Ĵ�С
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//ֻ�رյ�ǰ��������
		jf.setVisible(true);
		contentPane = new JPanel();
		jf.setContentPane(contentPane);
		contentPane.setLayout(null);

		//�黹��ť
		JButton btnReturn = new JButton("Return"); 
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnReturn)
		        {
		            if((docklist.howManyScooter(dockNum))>7) {//dock��8������slotȫ��   
		            	 ftos = new FtoSelectDock();//����ʧ��GUI
		            	 }
				    else{//�п�λ����
				    	if(userlist.isUsing(Qmnum)==true) {//�û������ó�
			           ret = new ReturnScootersGUI(Qmnum,dockNum,docklist,userlist); //��������GUI
					   }
				    	else {//�û�δ�賵
				    		rrep = new Rrep();//�ظ�����GUI
				    	}				    			    		
					   }  
		        }
			}
		});
		btnReturn.setBounds(329, 167, 97, 47);
		contentPane.add(btnReturn);
		btnReturn.setVisible(false);
		
		//����ť		
		JButton btnPay = new JButton("Pay Fine");
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnPay)
		        {				 
		           payaFine = new PayaFine(Qmnum,userlist);//��������GUI
		        }
			}
		});
		btnPay.setBounds(10, 167, 97, 47);
		contentPane.add(btnPay);
		btnPay.setVisible(false);
		
		//�賵��ť		
		JButton btnBorrow = new JButton("Borrow");
		btnBorrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBorrow)
     	        {
					if(userlist.isBan(Qmnum)==true) {//�û���ban����������
						payaFine = new PayaFine(Qmnum,userlist);
					}
					else if(userlist.isBan(Qmnum)==false){//�û�ûban											
					 if((docklist.howManyScooter(dockNum))<1) {//Dockû�г��ɽ�		        	     
		            	 ftos = new FtoSelectDock();//����ʧ��GUI
		            	 }		            	
		            else{//Dock�г��ɽ�
		            	if(userlist.isUsing(Qmnum)==false) {//�û�δʹ�ó�
		            	sel = new SelectScootersGUI(Qmnum,dockNum,docklist,userlist);//�����賵GUI
                        }
		            	else {//�û��Ѿ�����һ����
		            		brep = new Brep();//�ظ��賵GUI
		            	}
					 }
					}
		        }
			}			
		});
		btnBorrow.setBounds(168, 167, 97, 47);
		contentPane.add(btnBorrow);
		btnBorrow.setVisible(false);
		
		//������ǩ		
		JLabel lblTitle = new JLabel("Please enter your QM number to borrow, return or pay fines");
		lblTitle.setFont(new Font("΢ܛ�����w", Font.PLAIN, 14));
		lblTitle.setBounds(10, 15, 416, 47);
		contentPane.add(lblTitle);
		
		JLabel lblWar1 = new JLabel("\u221APlease select the next step!");
		lblWar1.setFont(new Font("����", Font.PLAIN, 14));
		lblWar1.setForeground(Color.GREEN);
		lblWar1.setBounds(150, 97, 226, 15);
		contentPane.add(lblWar1);
		lblWar1.setVisible(false);
		
		JLabel lblWar2 = new JLabel("\u00D7Please check your number again!");
		lblWar2.setFont(new Font("����", Font.PLAIN, 14));
		lblWar2.setForeground(Color.RED);
		lblWar2.setBounds(150, 122, 248, 15);
		contentPane.add(lblWar2);
		lblWar2.setVisible(false);
		
		//����QM�ı���
		tf1 = new JTextField();
		tf1.setBounds(10, 96, 87, 41);
		contentPane.add(tf1);
		tf1.setColumns(10);		
		tf1.addActionListener(new ActionListener() {//�����س�
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==tf1)
				  {
				    Qmnum = Integer.parseInt(tf1.getText());//��ȡ�ı�������
				    
					   if(userlist.search(Qmnum)>=0) {//�����ѧ����ע��
						   lblWar1.setVisible(true);
						   lblWar2.setVisible(false);
						//   tf1.setText(Qmnum+" is a right QM number in system");
						   btnPay.setVisible(true);
						   btnReturn.setVisible(true);
						   btnBorrow.setVisible(true);
					   }
					   else {
						   tf1.setText("");            //����ѧ��δע��
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
