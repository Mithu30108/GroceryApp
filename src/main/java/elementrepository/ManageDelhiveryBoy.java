package elementrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;
import utilities.ExcelUtilities;

public class ManageDelhiveryBoy {
	WebDriver driver;
	String locator;
	int i;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	ExcelUtilities eu = new ExcelUtilities();

	public ManageDelhiveryBoy(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//p[text()='Manage Delivery Boy']")
	WebElement manageDelhiveryBoy;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;
	@FindBy(id = "name")
	WebElement name;
	@FindBy(id = "email")
	WebElement email;
	@FindBy(id = "phone")
	WebElement phoneNumber;
	@FindBy(id = "address")
	WebElement address;
	@FindBy(id = "username")
	WebElement userName;
	@FindBy(id = "password")
	WebElement password;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveBtn;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement addedName;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[2]")
	WebElement addedEmail;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[3]")
	WebElement addedPhoneNum;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]")
	WebElement addedUserName;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[7]//i[@class='fa fa-angle-double-down']")
	WebElement downArrow;
	@FindBy(xpath = "//tr[@class='detail-row open']//span")
	WebElement addedPwd;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> list;
	@FindBy(name = "update")
	WebElement updateBtn;

	public void clickManageDelhiveryBoy() {
		manageDelhiveryBoy.click();
	}

	public void addNewDBoy() {
		newBtn.click();
	}

	public String enterName() {
		int i = gu.randon(5);
		String nameB4 = eu.getInputStringData(i + 1, 0);
		name.sendKeys(nameB4);
		return nameB4;
	}

	public String enterEmail() {
		String emailB4 = "Test" + gu.generateCurrentDateAndTime() + "@test.com";
		email.sendKeys(emailB4);
		return emailB4;
	}

	public String enterPhone() {
		int i = gu.randon(5);
		int phNumber = eu.getInputNumData(i + 1, 2);
		String phNumberB4 = String.valueOf(phNumber) + gu.randon(9);
		phoneNumber.sendKeys(phNumberB4);
		return phNumberB4;
	}

	public void enterAddress() {
		int i = gu.randon(5);
		address.sendKeys(eu.getInputStringData(i + 1, 3));
	}

	public String enterUserName() {
		String userNameB4 = "TestProfile1" + gu.randon(1000);
		userName.sendKeys(userNameB4);
		return userNameB4;
	}

	public String enterPwd() {
		String pwdB4 = "TP1" + gu.randon(1000);
		password.sendKeys(pwdB4);
		return pwdB4;
	}

	public String editPwd() {
		String pwdB4 = "TP1" + gu.randon(1000);
		password.clear();
		password.sendKeys(pwdB4);
		return pwdB4;
	}

	public String readName() {
		return addedName.getText();
	}

	public String readEmail() {
		return addedEmail.getText();
	}

	public String readPhone() {
		return addedPhoneNum.getText();
	}

	public String readUserName() {
		return addedUserName.getText();
	}

	public String readPwd() {
		downArrow.click();
		return addedPwd.getText();
	}

	public void saveDBoyAdded() {
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, saveBtn);
		gu.jsExecutorClick(driver, saveBtn);
	}

	public String getEditLocator() {
		int j = gu.randon(((list.size()) - 1));
		if ((j % 2) == 0) {
			i = j + 1;
		} else {
			i = j;
		}
		locator = "//table[@class='table table-bordered table-hover table-sm']//tr[" + i + "]";
		return locator;
	}

	public String readEditPwd() {
		WebElement dwnArrowOldPwd = driver
				.findElement(By.xpath(locator + "//td[7]//i[@class='fa fa-angle-double-down']"));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, dwnArrowOldPwd);
		gu.jsExecutorClick(driver, dwnArrowOldPwd);
		return addedPwd.getText();
	}

	public void editDboy() {
		WebElement editIcon = driver.findElement(By.xpath(locator + "//td[8]//i[@class='fas fa-edit']"));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, editIcon);
		gu.jsExecutorClick(driver, editIcon);
	}

	public void updateChanges() {
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, updateBtn);
		gu.jsExecutorClick(driver, updateBtn);
	}

}
