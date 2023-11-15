package elementrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageProducts {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	WebElement stckAvailability;

	public ManageProducts(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//p[text()='Manage Product']")
	WebElement managePdt;
	@FindBy(xpath = "//h1[text()='List Products']")
	WebElement listPdt;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> list;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement stkUpdateMsg;

	public void clickManagePdt() {
		managePdt.click();
	}

	public String readListPdt() {
		return listPdt.getText();
	}

	public String readPdtStkAvliblty(String pdtTitle) {
		int j = gu.getIntiContainsElement(list, pdtTitle);
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + j
				+ "]//td[6]//span";
		stckAvailability = driver.findElement(By.xpath(locator));
		return stckAvailability.getText();
	}

	public void editPdtStkAvliblty() {
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, stckAvailability);
		gu.jsExecutorClick(driver, stckAvailability);
	}

	public String readEditStkAvliblty() {
		return stkUpdateMsg.getText();
	}
}
