package model;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
	
	//Atributes
	private List<User> usersAccount;
	
	//Constructor
	public Classroom() {
		usersAccount = new ArrayList<User>();		
	}
	
	public boolean findUser(String username, String password) {
		boolean openWindow=false;
		boolean exit =false;
		
		System.out.println("************password: "+password);
		
		for (int i=0;i<usersAccount.size() && !exit ;i++) {
			if (username.equalsIgnoreCase(usersAccount.get(i).getUsername()) && password.equalsIgnoreCase(usersAccount.get(i).getPassword()) ) {
				openWindow=true;
				exit=true;				
			}
		}
		System.out.println("************"+openWindow);
		return openWindow;
	}
	
	
	
	
	
	
	public void addUser(String name,String password,String gender,String career, String birthday,String favoriteBrowser) {
		boolean find = findUser(name,password);
		if (find==false) {
			usersAccount.add(new User(name,password,gender,career,birthday,favoriteBrowser));
		}		
	}
	
	
	public List<User> getUsersAccount(){
		return usersAccount;
		
	}

	
	
}
