package module;

/**
 * test docklist
 * @author Yinze Li
 * @Date 2019��5��30������9:40:45
 * TODO
 */
public class DockListTest {

	public static void main(String[] args) {
		DockList d = new DockList();
//		System.out.print(d.pickWhich(0)+","+d.returnWhich(0));
//		d.returnScooter(0, 7);
//		d.dockSave();
		boolean[] s = d.dockState(0);
		for(int i = 0; i<s.length;i++)
		System.out.print(s[i]);
	}

}
