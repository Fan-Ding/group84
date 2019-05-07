/**
 * 
 */
package module;

public class Dock {

	private Slot[] dock;
	private int available;

	public Dock(String[] slots) {
		dockInit(slots);
	}

	/**
	 * load slots' states
	 */
	public void dockInit(String[] slots) {
		available = 0;
		dock = new Slot[slots.length];
		for (int i = 0; i < slots.length; i++) {
			boolean scooter = Boolean.parseBoolean(slots[i]);
			dock[i] = new Slot(scooter);
			if (scooter) {
				available++;
			}
		}
	}

	/**
	 * release the lock of particular slot
	 */
	public void release(int slot) {
		dock[slot].setLock(false);
	}

	/**
	 * lock particular slot
	 */
	public void lock(int slot) {
		dock[slot].setLock(true);
	}

	/**
	 * when a scooter is returned, call this method to change the slot's state
	 */
	public void returnScooter(int slot) {
		dock[slot].setScooter(true);
		available++;
	}

	/**
	 * when a scooter is picked up, call this method to change the slot's state
	 */
	public void pickScooter(int slot) {
		dock[slot].setScooter(true);
		available--;
	}

	/**
	 * randomly choose a slot for returning a scooter, if no slot available, return
	 * -1
	 */
	public int returnWhich() {
		if (available == dock.length) {
			return -1;
		} else {
			while (true) {
				int slot = (int) Math.floor(Math.random() * 8);
				System.out.print("trying" + slot + "...");
				if (!dock[slot].isScooter()) {
					System.out.println("slot" + slot + "is ok");
					return slot;
				}
				System.out.println("slot" + slot + "is not ok");
			}
		}
	}

	/**
	 * randomly choose a slot for picking up a scooter, if no scooter here, return
	 * -1
	 */
	public int pickWhich() {
		if (available == 0) {
			return -1;
		} else {
			while (true) {
				int slot = (int) Math.floor(Math.random() * 8);
				System.out.print("trying" + slot + "...");
				if (dock[slot].isScooter()) {
					System.out.println("slot" + slot + "is ok");
					return slot;
				}
				System.out.println("slot" + slot + "is not ok");
			}
		}
	}

	@Override
	public String toString() {
		String s = "";
		for (int i = 0; i < dock.length; i++) {
			s += dock[i].isScooter() + ",";
		}
		return s;
	}

	/**
	 * @return the available
	 */
	public int getAvailable() {
		return available;
	}
	
	/**
	 * return all the slots' states in a dock 
	 */
	public boolean[] dockState() {
		boolean[] state = new boolean[dock.length];
		for (int i = 0; i < dock.length; i++) {
			state[i] = dock[i].isScooter();
		}
		return state;
	}
}
