package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import module.Dock;
import module.DockList;
import module.UserList;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class PickFailed {

	private JFrame frame;
	private int studID;
	private int dockID;
	private UserList userList;
	private DockList dockList;
	
	public PickFailed(int studID,int dockID,UserList userList,DockList dockList) {
		this.studID = studID;
		this.dockID = dockID;
		this.userList = userList;
		this.dockList = dockList;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblTimeoutFailTo = new JLabel("TIMEOUT! FAILED TO PICK UP");
		lblTimeoutFailTo.setForeground(Color.RED);
		lblTimeoutFailTo.setFont(new Font("����", Font.PLAIN, 21));
		lblTimeoutFailTo.setBounds(59, 55, 302, 34);
		panel.add(lblTimeoutFailTo);
		
		JButton btnTryAgain = new JButton("try again");
		btnTryAgain.setBounds(38, 130, 113, 27);
		panel.add(btnTryAgain);
		
		JButton btnAbort = new JButton("abort");
		btnAbort.setBounds(267, 130, 113, 27);
		panel.add(btnAbort);
		
		class BTListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event)
			{
				//���ݲ�ͬ�����ţ���ȡ��ͬ������
				if(event.getSource() == btnAbort) {
					frame.dispose();
				}
				else if(event.getSource() == btnTryAgain) {
					//����������SelectScooters����ĵط�*****
					SelectScootersGUI gui = new SelectScootersGUI(studID, dockID, userList, dockList);
					frame.dispose();
				}
			}
		}
		//Create Listeners and associate them with buttons
		BTListener listener_1 = new BTListener();
		BTListener listener_2 = new BTListener();
		
		btnAbort.addActionListener(listener_1);
		btnTryAgain.addActionListener(listener_2);
		
		
	}

}