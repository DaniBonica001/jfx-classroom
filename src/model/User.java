package model;

public class User {
	
	//Atributes
	private String username;
	private String password;
	//Falta la imagen
	private String gender;
	private String career;//puede ser un enum
	private String birthday;
	private String favoriteBrowser;
	
	//Constructor
	public User(String username,String password,String gender, String career, String birthday, String favoriteBrowser) {
		this.username = username;
		this.password = password;
		this.gender = gender;
		this.career = career;
		this.birthday = birthday;
		this.favoriteBrowser = favoriteBrowser;		
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getCareer() {
		return career;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
	public String getFavoriteBrowser() {
		return favoriteBrowser;
	}

}
