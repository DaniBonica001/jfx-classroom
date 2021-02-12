package model;

import java.util.ArrayList;

public class User {
	
	//Atributes
	private String username;
	private String password;
	private String gender;
	private String career;
	private ArrayList<Career>userCareers;
	private String birthday;
	private String favoriteBrowser;
	
	//Constructor
	public User(String username,String password,String gender, ArrayList<Career>userCareers, String birthday, String favoriteBrowser) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		career=":)";
		this.userCareers=userCareers; 
		this.birthday = birthday;
		this.favoriteBrowser = favoriteBrowser;		
	}
	
	public void setUsername(String username) {
		this.username=username;
	}	
	public String getUsername() {
		return username;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}	
	public String getGender() {
		return gender;
	}
	
	public void setCareer(String career) {
		this.career=career;
	}
	public String getCareer() {
		for (int i=0;i<userCareers.size();i++) {
			if (userCareers.get(i)!=null) {
				career+=userCareers.get(i).name()+",";
			}			
		}		
		System.out.println("+++++++++++++ "+career);
		return career;
	}
	
	public void setBirthday(String birthday) {
		this.birthday=birthday;
	}
	public String getBirthday() {
		return birthday;
	}
	
	public void setFavoriteBrowser(String favoriteBrowser) {
		this.favoriteBrowser=favoriteBrowser;
	}
	public String getFavoriteBrowser() {
		return favoriteBrowser;
	}
	


}
