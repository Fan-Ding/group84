package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import module.*;

public class ScooperStateGUI {
	
	JFrame frame;
	JPanel panel1,panel2,panel3,panel4;
	JLabel clabel,ulabel,dlabel;
	JButton button;
	DockList dockList;
	private int parkedNum=0;
	private int usedNum=0;
	
	public ScooperStateGUI(DockList docklist) {
		dockList=docklist;
		calculateScooperInUse(dockList);
		
		frame=new JFrame();
		Font Font1=new Font("arial", Font.PLAIN, 27);	
		clabel=new JLabel("Current State of Scooper:");
		clabel.setFont(Font1);
		ulabel=new JLabel(usedNum + " in use");
		ulabel.setFont(Font1);
		dlabel=new JLabel(parkedNum + " in dock");
		dlabel.setFont(Font1);
		button=new JButton("Return");
		button.setFont(Font1);
		button.addActionListener(new ButtonListener());
		panel1=new JPanel();
		panel1.add(clabel);
		panel2=new JPanel();
		panel2.setLayout(new BoxLayout(panel2,BoxLayout.Y_AXIS));
		panel2.add(ulabel);
		panel2.add(dlabel);
		panel3=new JPanel();
		panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 200, 30));
		panel3.add(button);
		panel4=new JPanel();
		panel4.setLayout(new BoxLayout(panel4,BoxLayout.Y_AXIS));
		panel4.add(panel2);
		panel4.add(panel3);
		frame.getContentPane().add(BorderLayout.NORTH, panel1);
		frame.getContentPane().add(BorderLayout.CENTER, panel4);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setVisible(true);
	}
	
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
		}
	}
	
	public void calculateScooperInUse(DockList dockList) {
		boolean[][] scooperState=new boolean[3][8];
		for(int i=0;i<3;i++) {
		    scooperState[i]=dockList.dockState(i);
		}
		for(int i=0;i<3;i++) {
			for(int j=0;j<8;j++) {
				if(scooperState[i][j]==true) 
					parkedNum++;
			}
		}
		usedNum=15-parkedNum;
	}

}
