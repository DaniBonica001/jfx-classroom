package ui;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.Career;
import model.Classroom;
import model.User;

public class ClassroomGUI {
	
	
	@FXML
    private Pane mainPane;	
	
	//Relations
	private Classroom classroom;
	
	//Controller Login
	//Controller Login
	//Controller Login
	//Controller Login
	//Controller Login

    @FXML
    private TextField txtUserName;

    @FXML
    private Button btnSingUp;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField passwordField;    

    @FXML
    private Label labInfo;
    
    
    private Alert alert;
	
    //Controller account-table
    //Controller account-table
    //Controller account-table
    //Controller account-table
    //Controller account-table
    //Controller account-table
    

    @FXML
    private BorderPane listBorderPane;

    @FXML
    private TableView<User> tbvUsers;

    @FXML
    private TableColumn<User, String> colUsername;

    @FXML
    private TableColumn<User,String> colGender;

    @FXML
    private TableColumn<User,String> colCareer;

    @FXML
    private TableColumn<User,String> colBrithday;

    @FXML
    private TableColumn<User,String> colBrowser;

    @FXML
    private Label labelUserName;

    @FXML
    private ImageView imageProfilePicture;

    @FXML
    private Button btnLogOut;
	    
	    
    //Conntroller Register
    //Conntroller Register
    //Conntroller Register
    //Conntroller Register
    //Conntroller Register
    
    @FXML
    private CheckBox cbSoftwareEng;    

    @FXML
    private CheckBox cbTelematicEng;

    @FXML
    private CheckBox cbIndustrialEng;

    @FXML
    private RadioButton rbMale;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private RadioButton rbOther;

    @FXML
    private TextField txtRegisterUsername;
    
    @FXML
    private PasswordField txtRegisterPassword;

    @FXML
    private DatePicker birthdayPicker;
    
    @FXML
    private ComboBox<String> cbFavBrowser;    
    
    @FXML
    private TextField txtAddresPhoto;

    @FXML
    private Button btnBrowse;
    
    @FXML
    private ImageView selectedImage;

    @FXML
    private Button btnSignIn;

    @FXML
    private Button btnCreateAccount;
	
		
	//Constructor
	public ClassroomGUI(Classroom classR) {
		classroom = classR;		
	}	
	
    //Open login.fxml (start button)
	@FXML
    public void showLoginForm(ActionEvent event) throws IOException{
    	FXMLLoader loginForm = new FXMLLoader (getClass().getResource("login.fxml"));
    	loginForm.setController(this);
    	Parent loginPane = loginForm.load();    	
    	mainPane.getChildren().setAll(loginPane);
    	
    }    
    
    //Method to open account-table.fxml from login screen(Login in button)
    @FXML
    public void openAccountList(ActionEvent event)throws IOException {
    	boolean open=false;
    	    	
    	if (!txtUserName.getText().equals("") && !passwordField.getText().equals("")) {
    		
    		String username= txtUserName.getText();
        	String password=passwordField.getText();      	
    	
    		open = classroom.findUser(username,password);
       	 	
       		if (open==true) {

        		labInfo.setText("Ingreso exitoso");   
        		File file = new File(txtAddresPhoto.getText());
        		Image profilePicture = new Image(file.toURI().toString());
            	
            	FXMLLoader accountTableForm = new FXMLLoader (getClass().getResource("account-table.fxml"));
            	accountTableForm.setController(this);            	
            	Parent accountPane = accountTableForm.load();
            	mainPane.getChildren().clear(); 
            	mainPane.getChildren().setAll(accountPane);
            	mainPane.autosize();
       			
            	initializableTableView();
            	
            	labelUserName.setText(username); 
            	
            	imageProfilePicture.setImage(profilePicture);
        		
        	}else {
        		alert = new Alert (AlertType.ERROR);
        		alert.setTitle("Error dialog");
        		alert.setHeaderText("Something went wrong...");
        		alert.setContentText("The username and password given are incorrect");
        		alert.showAndWait();    		
        	}       	 	
            
    	}else {
    		alert = new Alert (AlertType.WARNING);
    		alert.setTitle("Warning dialog");
    		alert.setHeaderText("Warning");
    		alert.setContentText("Please complete all the information");
    		alert.showAndWait();
    	}

    }
           
    //Method to return to the login screen from the account-table screen (log out button)
    @FXML
    public void returnLoginScene(ActionEvent event) throws IOException {   	
    	
    	FXMLLoader login = new FXMLLoader(getClass().getResource("login.fxml"));
    	login.setController(this);
    	Parent loginScreen = login.load();
    	listBorderPane.getChildren().setAll(loginScreen); 
    }
    
    //Method to initialize the table view    
    public void initializableTableView() { 		
    	ObservableList<User> listUsers = FXCollections.observableArrayList(classroom.getUsersAccount());
    	
    	colUsername.setCellValueFactory(new PropertyValueFactory<User,String>("username"));
    	colGender.setCellValueFactory(new PropertyValueFactory<User,String>("gender"));
    	colCareer.setCellValueFactory(new PropertyValueFactory<User,String>("career"));
    	colBrithday.setCellValueFactory(new PropertyValueFactory<User,String>("birthday"));    	
    	colBrowser.setCellValueFactory(new PropertyValueFactory<User,String>("favoriteBrowser"));
    	
    	tbvUsers.setItems(listUsers);     	
    }   
        
    //Method to open register.fxml from the login screen (Sign up button)
    @FXML
    public void openRegisterForm(ActionEvent event)throws IOException {
    	FXMLLoader registerForm = new FXMLLoader (getClass().getResource("register.fxml"));
    	registerForm.setController(this);
    	Parent registerPane = registerForm.load();
    	mainPane.getChildren().clear();
    	mainPane.getChildren().setAll(registerPane);
    	initializeRegisterWindow();
    }    
                
    //Method to initialize the register screen
    public void initializeRegisterWindow() {
    	//We have to add the radio buttons to the ToggleGroup    
    	ToggleGroup tg = new ToggleGroup();
    	rbMale.setToggleGroup(tg);
    	rbFemale.setToggleGroup(tg);
    	rbOther.setToggleGroup(tg); 	
    	
    	
    	//Items to the comboBox
    	ObservableList<String> optionsComboBox = FXCollections.observableArrayList("Opera","Internet Explorer","Google Chrome","Microsoft Edge","Firefox","Safari","Thor","Brave");
  	    cbFavBrowser.setItems(optionsComboBox);
    	   	   
    }
    
    //Method to open the files explorer (Browse button)
    @FXML
    public void openFilesExplorer(ActionEvent event) {
    	//Write the route of the picture in the textBox    
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.getExtensionFilters().addAll(
    			new FileChooser.ExtensionFilter("All Images", "*.*"),
    			new FileChooser.ExtensionFilter("JPG","*.jpg"),
    			new FileChooser.ExtensionFilter("PNG","*.png")
    			);
    	Stage stage = new Stage();
    	File fichero = fileChooser.showOpenDialog(stage);
    	txtAddresPhoto.setText(fichero.getAbsolutePath());
    	//Fix to show the selected image
    	if (fichero!=null) {
    		Image image= new Image("file:"+fichero.getAbsolutePath());
    		selectedImage.setImage(image);
    		selectedImage.setVisible(false);    		
    	}
    }
    
    //Method to open the login screen from the register screen (Sign in button)
    @FXML
    public void openLogin(ActionEvent event) throws IOException{
    	txtRegisterUsername.setText("");
    	txtRegisterPassword.setText("");
    	txtAddresPhoto.setText("");    	
    	showLoginForm(event);
    	//labInfo.setText("Your account wasn't create succesfully");
    }
        
    //Method to save user (create account button)
    @FXML
    public void saveUser(ActionEvent event) throws IOException{
    	ArrayList<Career>userCareers = new ArrayList<Career>();
    	String name= txtRegisterUsername.getText();
    	String password = txtRegisterPassword.getText();    
    	String addressPhoto = txtAddresPhoto.getText();
    	
    	String gender;
    	
    	if (rbMale.isSelected()) {
			gender= rbMale.getText();
		}else if (rbFemale.isSelected()) {
			gender=rbFemale.getText();
		}else if (rbOther.isSelected()){
			gender = rbOther.getText();
		}else {
			gender="";
		}
    	
    	String career="";
    	
    	if (cbSoftwareEng.isSelected()) {
    		userCareers.add(Career.SOFTWARE_ENGINEERING);			
		}
    	if (cbTelematicEng.isSelected()) {
			userCareers.add(Career.TELEMATIC_ENGINEERING);
		}
    	if (cbIndustrialEng.isSelected()) {
			userCareers.add(Career.INDUSTRIAL_ENGINEERING);
		}
    	/*
    	for (int i=0;i<userCareers.size();i++) {
    		career+=userCareers.get(i).name()+",";
    	} 
    	
    	*/
    	LocalDate birthdayDate = birthdayPicker.getValue();    
    	
    	String favoriteBrowser = cbFavBrowser.getSelectionModel().getSelectedItem();	
    	
    	if (name!="" && password!="" && addressPhoto!="" && gender!="" && userCareers!=null && birthdayDate!=null && favoriteBrowser!="") {
    		   		
    		String birthday =  birthdayDate.toString();
    		System.out.println("name: "+name);
    		System.out.println("password: "+password);
    		System.out.println("gender: "+gender);
    		
    		for (int i=0;i<userCareers.size();i++) {
    			career+=userCareers.get(i).name()+",";
    		}
    		System.out.println("careers: "+career);    	
    		
    		classroom.addUser(name,password,gender,userCareers, birthday,favoriteBrowser);
    		
    		alert = new Alert (AlertType.CONFIRMATION);
    		alert.setHeaderText("Congratulations!");
    		alert.setContentText("The new account has been created");
    		alert.showAndWait(); 	
    		
    		txtRegisterUsername.setText("");
    		txtRegisterPassword.setText("");
    		txtAddresPhoto.setText("");    		
    		rbMale.setSelected(false);
    		rbFemale.setSelected(false);
    		rbOther.setSelected(false);
    		cbSoftwareEng.setSelected(false);
    		cbTelematicEng.setSelected(false);
    		cbIndustrialEng.setSelected(false);
    		birthdayPicker.setValue(null); 
    		
    		
    	}else {
    		
    		alert = new Alert (AlertType.ERROR);
    		alert.setTitle("Error Dialog");
    		alert.setHeaderText("Error");
    		alert.setContentText("You must fill each field in this form");
    		alert.showAndWait();
    	
    	}
    	
    	

    }

}
    


