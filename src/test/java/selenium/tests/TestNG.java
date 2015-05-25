package selenium.tests;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
 
public class TestNG {
 
 public WebDriver driver;
 
 @Test 
 public void main() {
 
 // Find the element that's ID attribute is 'user_login' (Username)
 
 // Enter Username on the element found by above desc.
 
 driver.findElement(By.id("user_login")).sendKeys("subscriber");
 
 // Find the element that's ID attribute is 'user_pass' (Password)
 
 // Enter Password on the element found by the above desc.
 
 driver.findElement(By.id("user_pass")).sendKeys("subscriberpassword");
 
 // Now submit the form. WebDriver will find the form for us from the element
 
 driver.findElement(By.id("wp-submit")).click();
 
 if (driver.findElement(By.id("profile-page")).isDisplayed()) 
 { 
 // Print a Log In message to the screen 
 System.out.println("Login successfully.");
 } 
 }
 
 @BeforeMethod
 public void beforeMethod() {
 
 // Create a new instance of the Firefox driver
 
 driver = new FirefoxDriver();
 
 //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
 
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 
 //Launch the Wordpress Admin site
 
 driver.get("http://autoqa.pp.ua/wp-admin");
 
 }
 
 @AfterMethod
 public void afterMethod() {
 
 // Close the driver
 
 driver.quit();
 
 }
}