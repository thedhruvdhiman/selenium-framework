/**
 * 
 */
/**
 * 
 */
package infinity.pageObjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import infinity.utility.UtilityMethods;

public class LoginPage extends UtilityMethods{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement username;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement loginButton;
	
	@FindBy(css = ".error-message-container")
	WebElement errorMessage;	
	
	
	public void openURL() throws IOException {
		Properties props = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//infinity//resources//information.properties");
		props.load(fs);
		driver.get(props.getProperty("url"));
	}
	
	
	/**
	 * Enter user name, password and click login button.
	 * 
	 * @param userLoginName
	 * @param userPassword
	 * */
	
	public void enterLoginValuesAndClickLogin(String userLoginName, String userPassword) {
		username.sendKeys(userLoginName);
		password.sendKeys(userPassword);
		loginButton.click();
	}
	
	/**
	 * *Unhappy-path | Enter user name, password and click login button.
	 *
	 * @param userLoginName
	 * @param userPassword
	 * @return Error message string
	 * */
	public String enterIncorrectLoginValuesAndClickLogin(String userLoginName, String userPassword) {
		username.sendKeys(userLoginName);
		password.sendKeys(userPassword);
		loginButton.click();
		waitForElementDisplay(errorMessage);
		return errorMessage.getText();
	}
}
