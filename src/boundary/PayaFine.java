package boundary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.UserList;

import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
/**
 * GUI for paying fines.
 * @author SunYu
 */
public class PayaFine extends JFrame {

	private JPanel contentPane;

	public PayaFine(int Qmnum,UserList userlist) {     
		
		JFrame jf = new JFrame("Pay");
		
		Toolkit tk = this.getToolkit();// 得到窗口工具条
		int width = 650;
		int height = 500;
		Dimension dm = tk.getScreenSize();
		jf.setLocation((int) (dm.getWidth() - width) / 2,
				(int) (dm.getHeight() - height) / 2);// 显示在屏幕中央
		
		jf.setSize(450, 300);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setVisible(true);
		contentPane = new JPanel();
		jf.setContentPane(contentPane);
		contentPane.setLayout(null);
				
		JPanel panel = new JPanel();
		panel.setBounds(10, 23, 416, 91);
		contentPane.add(panel);
		
		JLabel lblPleasePay = new JLabel("Please pay \u00A3100 to active your account.");
		lblPleasePay.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblPleasePay);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 160, 416, 64);
		contentPane.add(panel_1);
		
		JButton btnPay = new JButton("Pay"); //Pay 按钮
		btnPay.setBounds(10, 0, 172, 65);
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnPay)
		        {
					if(userlist.isBan(Qmnum)==true) {    //账户被ban
					btnPay.setText("Paid successfully!");
					userlist.unban(Qmnum);               //账户状态在交罚款后改为未ban
		     		}
					else {                               //账户未ban
						btnPay.setText("Account isn't banned!");
					}

		        }
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnPay);
		
		JButton btnCancel = new JButton("Cancel");      //取消按钮
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCancel)
		        {
					jf.dispose();
		        }
			}
		});
		btnCancel.setBounds(233, 0, 173, 65);
		panel_1.add(btnCancel);
		
		JLabel lblRem = new JLabel("Make sure that if you should pay a fine at first!");
		lblRem.setFont(new Font("宋体", Font.PLAIN, 14));
		lblRem.setForeground(Color.RED);
		lblRem.setBounds(45, 121, 353, 29);
		contentPane.add(lblRem);
		jf.setVisible(true);
	}
}
