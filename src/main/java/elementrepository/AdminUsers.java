package elementrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class AdminUsers {
	WebDriver driver;
	String locator;
	int i;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public AdminUsers(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//p[text()='Admin Users']")
	WebElement adminUsers;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> list;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[@name='Update']")
	WebElement updateBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement updateSuccessMsg;

	public void clickAdminUsers() {
		adminUsers.click();
	}

	public void getColumnSize() {
		int j = gu.randon(((list.size()) - 1));
		if ((j % 2) == 0) {
			i = j + 1;
		} else {
			i = j;
		}
		locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + i + "]";
	}

	public String getPassword() {
		WebElement doubleDownArrow = driver
				.findElement(By.xpath(locator + "//td[4]//i[@class='fa fa-angle-double-down']"));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, doubleDownArrow);
		gu.jsExecutorClick(driver, doubleDownArrow);
		WebElement hiddenPwd = driver.findElement(By.xpath(
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1) + "]//span"));
		return hiddenPwd.getText();
	}

	public void editAdminUser() {
		WebElement editBtn = driver
				.findElement(By.xpath(locator + "//td[5]//a[@class='btn btn-sm btn btn-primary btncss']"));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, editBtn);
		gu.jsExecutorClick(driver, editBtn);
	}

	public String enterPassword() {
		wu.elementToBeClickableExpWait(driver, password);
		gu.jsExecutorClick(driver, password);
		password.clear();
		String inputPwd = "PWD" + (gu.randon(100));
		password.sendKeys(inputPwd);
		return inputPwd;
	}

	public void updateChanges() {
		updateBtn.click();
	}

	public String readUpdateSuccessMsg() {
		return updateSuccessMsg.getText();
	}

}
