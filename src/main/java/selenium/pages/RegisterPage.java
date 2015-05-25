package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	private WebDriver driver;
	By loginField = By.id("user_login");
	By registerLink = By.className("register");
	By passwordField = By.id("user_password");
	By userNameField = By.id("user_firstname");
	By confirmPasswordField = By.id("user_password_confirmation");
	By userLastnameField = By.id("user_lastname");
	By emailField = By.id("user_mail");
	By languageSelect = By.id("user_language");
	By submitButton = By.name("commit");
	
	public RegisterPage(WebDriver driver){
		this.driver = driver;
	}
	
public void registerWith(String login, String password, String userName, String userLastName, String email){
	
	gotoRegisterPage();	
	setLogin(login);	
	setPasswords(password);	
	setUserName(userName);	
	setUserLastName(userLastName);
	setEmail(email);
	
	Select langSelect = new Select(driver.findElement(languageSelect));
	langSelect.selectByValue("en");	
	driver.findElement(By.name("commit")).click();
	 
}

private void setEmail(String email) {
	driver.findElement(emailField)
			.sendKeys(email);
}

private void setUserLastName(String userLastName) {
	driver.findElement(userLastnameField).sendKeys(userLastName);
}

private void setUserName(String userName) {
	driver.findElement(userNameField).sendKeys(userName);
}

private void setPasswords(String password) {
	driver.findElement(passwordField).sendKeys(password);	
	driver.findElement(confirmPasswordField).sendKeys(password);
}

private void setLogin(String login) {
	driver.findElement(loginField).sendKeys(login);
}

private void gotoRegisterPage() {
	driver.findElement(registerLink).click();
}

public void submitRegistration() {
	driver.findElement(submitButton).click();
}
}
