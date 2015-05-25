package selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	public static String getMessageOfSuccessRegistration(WebDriver driver){		
		return driver.findElement(By.id("flash_notice")).getText();
	}					
}

