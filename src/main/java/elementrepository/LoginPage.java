package elementrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtilities;
import utilities.GeneralUtilities;

public class LoginPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExcelUtilities eu = new ExcelUtilities();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alert1;
	@FindBy(xpath = "//div[@class='errors']//li")
	WebElement blankUsrnm;
	@FindBy(xpath = "//div[@class='errors']//li[2]")
	WebElement blankPwd;

	public void login(String name, String pwd) {
		username.sendKeys(name);
		password.sendKeys(pwd);
		signIn.click();
	}

	public void login() {
		username.sendKeys(eu.getUsername(1, 0));
		password.sendKeys(eu.getPassword(1, 1));
		signIn.click();
	}

	public String readAlert1() {
		return alert1.getText();
	}

	public String readAlert2() {
		return blankUsrnm.getText();
	}

	public String readAlert3() {
		return blankPwd.getText();
	}

	public String readBlankloginAlert() {
		return gu.getAlertText(driver);
	}
}
