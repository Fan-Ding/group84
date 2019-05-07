package module;

import java.util.ArrayList;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class UserList {

	private ArrayList<User> userList;

	public UserList() {
		userList = new ArrayList<User>();
		load();
	}

	public ArrayList<User> getUserList() {
		return userList;
	}

	/**
	 * load all user's information from the file to ArrayList
	 */
	public void load() {
		try {
			System.out.println("load users...");
			BufferedReader reader = new BufferedReader(new FileReader("src/userInfo.csv"));
			reader.readLine();
			String line = null;
			while ((line = reader.readLine()) != null) {
				String item[] = line.split(",");
				int ID = Integer.parseInt(item[0]);
				String name = item[1];
				String email = item[2];
				boolean isBanned = Boolean.parseBoolean(item[3]);
				boolean isUsing = Boolean.parseBoolean(item[4]);
				User user = new User(ID, name, email);
				user.setBanned(isBanned);
				user.setUsing(isUsing);
				System.out.println(user);
				userList.add(user);
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * save all user information to the file
	 */
	public void save() {
		try {
			File csv = new File("src/userInfo.csv");
			BufferedWriter bw = new BufferedWriter(new FileWriter(csv, false));
			bw.write("ID,name,email,isBanned,isUsing");
			bw.newLine();
			for (int i = 0; i < userList.size(); i++) {
				User user = userList.get(i);
				bw.write(user.getID() + "," + user.getName() + "," + user.getEmail() + "," + user.isBanned() + ","
						+ user.isUsing());
				bw.newLine();
			}
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * enroll a user
	 */
	public void enroll(int ID, String name, String email) {
		User user = new User(ID, name, email);
		userList.add(user);
	}

	/**
	 * delete a user
	 */
	public void delete(int ID) {
		int i = search(ID);
		if (i >= 0) {
			userList.remove(i);
		} else {
			System.out.println("ID is not existed");
		}
	}

	/**
	 * if a user pick up a scooter, record picking time
	 */
	public void pickRecord(int ID) {
		int i = search(ID);
		Calendar cal = Calendar.getInstance();
		userList.get(i).setLastPick(cal);
		userList.get(i).setUsing(true);
	}

	/**
	 * if a user return a scooter, calculate using time
	 */
	public int[] usingMinute(int ID) {
		int[] time = new int[2];
		int i = search(ID);
		Calendar now = Calendar.getInstance();
		Calendar pick = userList.get(i).getLastPick();
		int minute = (now.get(Calendar.YEAR) - pick.get(Calendar.YEAR)) * 525600
				+ (now.get(Calendar.DAY_OF_YEAR) - pick.get(Calendar.DAY_OF_YEAR)) * 1440
				+ (now.get(Calendar.HOUR_OF_DAY) - pick.get(Calendar.HOUR_OF_DAY)) * 60
				+ (now.get(Calendar.MINUTE) - pick.get(Calendar.MINUTE));
		userList.get(i).setUsing(false);
		time[0] = minute;
		int[] todayUsing = userList.get(i).getTodayUsingTime();
		if (now.get(Calendar.DAY_OF_YEAR) == todayUsing[0]) {
			todayUsing[1] += minute;
		} else {
			todayUsing[1] = minute;
		}
		userList.get(i).setTodayUsingTime(now.get(Calendar.DAY_OF_YEAR), todayUsing[1]);
		time[1] = todayUsing[1];
		return time;
	}

	/**
	 * ban a user
	 */
	public void ban(int ID) {
		int i = search(ID);
		if (i >= 0) {
			userList.get(i).setBanned(true);
		} else {
			System.out.println("ID is not existed");
		}
	}

	/**
	 * check if a user is using a scooter
	 */
	public boolean isUsing(int ID) {
		int i = search(ID);
		return userList.get(i).isUsing();
	}

	/**
	 * unban a user
	 */
	public void unban(int ID) {
		int i = search(ID);
		if (i >= 0) {
			userList.get(i).setBanned(false);
		} else {
			System.out.println("ID is not existed");
		}
	}

	/**
	 * check if ID exists
	 */
	public boolean checkIDExist(int ID) {
		User user;
		for (int i = 0; i < userList.size(); i++) {
			user = userList.get(i);
			if (user.getID() == ID) {
				return true;
			}
		}
		return false;
	}

	/**
	 * check ID format
	 */
	public boolean checkIDFormat(int ID) {
		if (ID < 99999999 || ID > 1000000000) {
			return false;
		}
		return true;
	}

	/**
	 * check Email format
	 */
	public boolean checkEmailFormat(String email) {
		int i, j = 0;
		int position = 0;
		if (email.length() < 3)
			return false;
		for (i = 0; i < email.length(); i++) {
			if (email.charAt(i) == '@') {
				j++;
				position = i;
			}
		}
		if (position > 0 && position < (email.length() - 1) && j == 1)
			return true;
		return false;
	}

	/**
	 * search a user by ID, return his position in the ArrayList
	 */
	public int search(int ID) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getID() == ID) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * search a user by ID, return if a user is banned
	 */
	public boolean isBan(int ID) {
		int i = search(ID);
		return userList.get(i).isBanned();
	}

	/**
	 * return the size of user list
	 */
	public int length() {
		return userList.size();
	}

}
