package elementrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageLocation {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ManageLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-map-marker']")
	WebElement manageLocation;
	@FindBy(id = "st_id")
	WebElement state;
	@FindBy(xpath = "//a[text()='Cancel']")
	WebElement cancelBtn;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[6]")
	List<WebElement> list;

	public void manageLocation() {
		manageLocation.click();
	}

	public void editLocation() {
		int i = gu.randon(list.size()-1);
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
				+ "]//td[6]//a[@class='btn btn-sm btn btn-primary btncss']";
		WebElement editIcon = driver.findElement(By.xpath(locator));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, editIcon);
		gu.jsExecutorClick(driver, editIcon);
	}

	public void editState() {
		int i = gu.randon(30);
		gu.selectByIndexDropdown(state, i);
	}

	public String getUrl() {
		return gu.getUrl(driver);
	}

	public void cancelEdit() {
		cancelBtn.click();
	}
}
