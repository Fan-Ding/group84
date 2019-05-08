package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import module.*;

/**
 * @author ZouShiwen
 *
 */
public class DockStateGUI {

	JFrame frame;
	JButton button;
	JLabel[] label;
	JPanel panel1,panel2,panel3,panel4;
	String[] state;
	int dockNum;
	DockList dockList;
	
	/**
	  * Constructor displaying all slots' states of a dock
	  */
	 public DockStateGUI(int dock, DockList docklist) {
		 dockNum=dock;
		 dockList=docklist;
		 this.checkSlotsState(dock);
		 
		 frame=new JFrame();
			Font Font1=new Font("arial", Font.PLAIN, 27);
			panel1=new JPanel();
			panel2=new JPanel();
			panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
			label= new JLabel[8];
			for(int i=0;i<8;i++) 
	            label[i]=new JLabel("Slot"+(i+1)+": "+ state[i]); 
			for(int i=0;i<8;i++) 
	            label[i].setFont(Font1);
			for(int i=0;i<8;i++) 
	            panel2.add(label[i]);
			panel1.add(BorderLayout.CENTER,panel2);
			button=new JButton("Return");
			button.setFont(Font1);
			button.addActionListener(new ButtonListener());
			panel3=new JPanel();
			panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 100));
	        panel3.add(button);
	        panel4=new JPanel();
	        panel4.add(BorderLayout.CENTER, panel3);
			frame.getContentPane().add(BorderLayout.CENTER,panel1);
			frame.getContentPane().add(BorderLayout.EAST,panel4);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(800,800);
			frame.setVisible(true);
	 }
	 
	 /**
	  * Convert slot boolean states into words.
	  */
	public void checkSlotsState(int dock) {
		boolean[] dockState=new boolean[8];
		dockState=dockList.dockState(dock);
		state=new String[8];
		for(int i=0;i<8;i++) {
			    if(dockState[i]==true)
				   state[i]="Parked";
			    else
				   state[i]="Empty";
	    }
	}
	
	/**
	  * Subclass to perform action of returning to main GUI
	  */
	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			frame.dispose();
		}
	}
	
}
