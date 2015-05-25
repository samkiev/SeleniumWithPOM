package selenium.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import selenium.pages.LoginPage;
import selenium.pages.RegisterPage;

public class RegisterPageTest {
	private static WebDriver driver;
	String add_to_login = "j452sd8";
	String login = "testuser" + add_to_login;
	String password = login;
	String name = "name" + login;
	String lastName = "lastname" + login;
	String email = login + "@usdf.uf";
	// New Login value
	String new_password = password + add_to_login;
	String new_user_login = "newtestuser" + add_to_login;
	String name_new_user = "itlabs" + add_to_login;
	// Project Value
	String project_name = name_new_user + "project" + add_to_login;
	String version_name = "new_version" + add_to_login;
	// issue value
	String subject_bug = "bug_issue";
	String subject_feature = "feature_issue";
	String subject_support = "support_issue";
	
  @Test
  public void registerFlow() {
	  RegisterPage registerPage = new RegisterPage(driver);
	  registerPage.registerWith(login, password, name, lastName, email);
	  registerPage.submitRegistration();
	  String messageOfSuccessRegistration = LoginPage.getMessageOfSuccessRegistration(driver);
	  Assert.assertEquals(messageOfSuccessRegistration, "Ваша учётная запись активирована. Вы можете войти.");
	  
  }
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://demo.redmine.org");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
