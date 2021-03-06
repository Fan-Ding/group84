package boundary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * GUI for reminding users that they have repeatedly borrowed.
 * @author SunYu
 */
public class Brep extends JFrame {

	private JPanel contentPane;

	public Brep() {
		JFrame jf = new JFrame("Fail");		
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
		panel.setBounds(10, 10, 416, 150);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("<html><body><p>This account has occupied one scooter, please return the scooter first then try again!");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		panel.add(lblNewLabel, BorderLayout.CENTER);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(165, 201, 100, 50);
		contentPane.add(btnOk);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnOk)
		        {
					jf.dispose();
		        }
			}
		});
		
	}
}
