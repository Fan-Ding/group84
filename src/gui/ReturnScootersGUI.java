package gui;

import java.awt.*;
import javax.swing.*;

import module.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnScootersGUI {

	private JFrame frame;
	private JTextField txtPleasePickUp;
	private int dockID;
	private int studID;
	private UserList userList;
	private DockList dockList;
	private boolean Pressed = false;//�����жϰ����Ƿ񱻴�����
	private boolean timeout = false;//�жϵȴ��Ƿ�ʱ
	private boolean press = false;//�жϵȴ��Ƿ�ʱ
	
	public ReturnScootersGUI(int studID,int dockID, UserList userList,DockList dockList) {
		this.dockID = dockID;
		this.studID = studID;
		this.dockList = dockList;
		this.userList = userList;
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 453, 301);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtPleasePickUp = new JTextField();
		txtPleasePickUp.setBackground(SystemColor.control);
		txtPleasePickUp.setText("  PLEASE RETURN THE SCOOTER TO THE FLASHING SLOT!");
		txtPleasePickUp.setBounds(0, 25, 435, 36);
		frame.getContentPane().add(txtPleasePickUp);
		txtPleasePickUp.setColumns(10);

		JPanel CounterPanel = new JPanel();
		CounterPanel.setForeground(Color.RED);
		CounterPanel.setBackground(SystemColor.controlLtHighlight);
		CounterPanel.setBounds(24, 120, 89, 82);
		frame.getContentPane().add(CounterPanel);
		CounterPanel.setLayout(null);
		
		JLabel CounterLabel = new JLabel("60");
		CounterLabel.setForeground(Color.RED);
		CounterLabel.setBackground(Color.GRAY);
		CounterLabel.setHorizontalAlignment(SwingConstants.CENTER);
		CounterLabel.setBounds(0, 0, 89, 82);
		CounterLabel.setFont(new Font("΢���ź�", Font.PLAIN, 40));
		CounterPanel.add(CounterLabel);

		JLabel lblTimeRemaing = new JLabel("TIME REMIANING");
		lblTimeRemaing.setFont(new Font("����", Font.PLAIN, 18));
		lblTimeRemaing.setForeground(Color.RED);
		lblTimeRemaing.setBounds(10, 74, 150, 29);
		frame.getContentPane().add(lblTimeRemaing);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(146, 95, 238, 146);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JButton button_1 = new JButton("1");
		button_1.setBounds(46, 31, 41, 27);
		panel_1.add(button_1);

		JButton button_2 = new JButton("2");
		button_2.setBounds(82, 31, 41, 27);
		panel_1.add(button_2);

		JButton button_3 = new JButton("3");
		button_3.setBounds(121, 31, 41, 27);
		panel_1.add(button_3);

		JButton button_4 = new JButton("4");
		button_4.setBounds(160, 31, 41, 27);
		panel_1.add(button_4);

		JButton button_5 = new JButton("5");
		button_5.setBounds(46, 71, 41, 27);
		panel_1.add(button_5);

		JButton button_6 = new JButton("6");
		button_6.setBounds(82, 71, 41, 27);
		panel_1.add(button_6);

		JButton button_7 = new JButton("7");
		button_7.setBounds(121, 71, 41, 27);
		panel_1.add(button_7);

		JButton button_8 = new JButton("8");
		button_8.setBounds(160, 71, 41, 27);
		panel_1.add(button_8);
		
		JButton button[] = new JButton[200];
		button[1] = button_1;
		button[2] = button_2;
		button[3] = button_3;
		button[4] = button_4;
		button[5] = button_5;
		button[6] = button_6;
		button[7] = button_7;
		button[8] = button_8;

		TransactionList transactionList = new TransactionList();
		int slotID = dockList.returnWhich(dockID)+1;//�жϵ�ǰ������slot�š�С���Ա���ַ�Χ[0,7]���˴�Ϊ[1,8]
		
		//����һ���̣߳����ṩ����ʱ��dock�����칦��
				class CounterRunnable implements Runnable {
					public CounterRunnable() {
						// TODO Auto-generated constructor stub
					}
					public void run() {
						int time = 60;  //����ʱʱ������
						while (Pressed == false && time >=0) {//Pressed�����ж��Ƿ����¼���time���м���.Pressed=trueΪ���°���
							CounterLabel.setText(time+"s");
							flashLED();
							 try {
								 Thread.sleep(333);
					                flashLED();
					                Thread.sleep(333);
					                flashLED();
					                Thread.sleep(334);
					            } catch (InterruptedException e) {
					                e.printStackTrace();
					            }
					         	time--;
						}
						if(Pressed == false && time <0)
							timeout = true;
						if(time < 0 && !press) {
							ReturnFailed GUI = new ReturnFailed(studID, dockID, userList, dockList);
							frame.dispose();
						}
					}
					public void flashLED() {
						if(button[slotID].getForeground()==Color.BLACK) {
							button[slotID].setForeground(Color.RED);
							//button[slotID].setBackground(Color.RED);
						}
						else {
							button[slotID].setForeground(Color.BLACK);
							//button[slotID].setBackground(Color.BLACK);
						}                                                  
					 }
			}
				//��ʼ����ʱ�����
				CounterRunnable counter = new CounterRunnable();
				Thread thread = new Thread(counter);
				thread.start();

		class RedButtonListener implements ActionListener
		{	
			public void actionPerformed(ActionEvent event)
			{
				//�����µ�ʹ�ü�¼���ر��̣߳�����ȡ���ɹ�GUI
				while(!timeout && !Pressed) {
					if(event.getSource() == button[slotID]) {
						Pressed = true;
						
						int[] checktime = new int[2];
						checktime = userList.usingMinute(studID);
						dockList.returnScooter(dockID, slotID-1);
						
						if (checktime[0]<=30 && checktime[1]<=120) {
							transactionList.newTrans(studID, dockID, slotID-1, false, false);//slotID���±�ƫ����
						}
						else {
							transactionList.newTrans(studID, dockID, slotID-1, false, true);//slotID���±�ƫ����
							userList.ban(studID);
						}
						SuccessfullyReturned GUI = new SuccessfullyReturned();
						press = true;
						frame.dispose();
					}
				}
			}
		}
		// Create actionListener
				RedButtonListener listener[] = new RedButtonListener[200];
					for(int i=1;i<9;i++) {
						listener[i] = new RedButtonListener();
					}
					button[slotID].addActionListener(listener[slotID]);
	}
}