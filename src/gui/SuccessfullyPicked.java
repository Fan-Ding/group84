package tanzijing;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class SuccessfullyPicked {

	private JFrame frame;

	public SuccessfullyPicked() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PICK UP SUCCESSFULLY!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("свт╡", Font.PLAIN, 22));
		lblNewLabel.setBounds(92, 100, 242, 35);
		panel.add(lblNewLabel);
	}

}
