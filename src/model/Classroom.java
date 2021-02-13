package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	
	//Relation
	private List<User> usersAccount;
	
	//Constructor
	public Classroom() {
		usersAccount = new ArrayList<User>();		
	}
	
	//Method to find the  user
	public boolean findUser(String username, String password) {
		boolean openWindow=false;
		boolean exit =false;
						
		for (int i=0;i<usersAccount.size() && !exit ;i++) {
			if (username.equalsIgnoreCase(usersAccount.get(i).getUsername()) && password.equalsIgnoreCase(usersAccount.get(i).getPassword()) ) {
				openWindow=true;
				exit=true;				
			}
		}
		return openWindow;
	}
	
	//Method to add a new user to the List
	public void addUser(String name,String password,String gender,ArrayList<Career> career, String birthday,String favoriteBrowser) {
		boolean find = findUser(name,password);
		if (find==false) {
			usersAccount.add(new User(name,password,gender,career,birthday,favoriteBrowser));
		}		
	}
	
	//Method to return the users list
	public List<User> getUsersAccount(){
		return usersAccount;		
	}

		
}
