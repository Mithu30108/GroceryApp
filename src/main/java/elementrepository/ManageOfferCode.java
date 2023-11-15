package elementrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageOfferCode {
	WebDriver driver;
	String locator;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ManageOfferCode(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[6][@class='col-lg-3 col-6']//a[text()='More info ']")
	WebElement manageOfferCode;
	@FindBy(name = "offer_code")
	WebElement offerCode;
	@FindBy(xpath = "//label[@class='radio-inline']//input[@value='no']")
	WebElement radioBtnNo;
	@FindBy(id = "offer_per")
	WebElement percentage;
	@FindBy(id = "offer_price")
	WebElement amnt;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement description;
	@FindBy(name = "update")
	WebElement updateBtn;
	@FindBy(xpath = "//div[@class='note-btn-group btn-group note-insert']//i[@class='note-icon-link']")
	WebElement decriptionLink;
	@FindBy(xpath = "//input[@class='note-link-text form-control note-form-control note-input']")
	WebElement linkText;
	@FindBy(xpath = "//input[@class='note-link-url form-control note-form-control note-input']")
	WebElement linkUrl;
	@FindBy(xpath = "//input[@value='Insert Link']")
	WebElement insertLinkBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement editSuccessMsg;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr//td[1]")
	List<WebElement> list;

	public void clickManageOfferCode() {
		manageOfferCode.click();
	}

	public void editManageOffer() {
		int i = gu.randon(list.size()-1);
		locator = "//table[@class='table table-bordered table-hover table-sm']//tr[" + (i + 1) + "]";
		WebElement editBtn = driver.findElement(By.xpath(locator + "//td[6]//i[@class='fas fa-edit']"));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, editBtn);
		gu.jsExecutorClick(driver, editBtn);
	}

	public String editOfferCode() {
		offerCode.clear();
		String inputOfferCode = "TestOfferCD" + gu.randon(1000);
		offerCode.sendKeys(inputOfferCode);
		return inputOfferCode;
	}

	public String getOfferCode() {
		WebElement getOfferCode = driver.findElement(By.xpath(locator + "//td[1]"));
		return getOfferCode.getText();
	}

	public void enterRBtn() {
		radioBtnNo.click();
	}

	public void enterPercentage() {
		percentage.clear();
		percentage.sendKeys(String.valueOf(gu.randon(100)));
	}

	public void enterAmount() {
		amnt.clear();
		amnt.sendKeys(String.valueOf(gu.randon(1000)));
	}

	public void enterDescription() {
		description.clear();
		description.sendKeys("TestOfferDescription" + gu.generateCurrentDateAndTime() + "\n");
	}

	public void enterLinkText(String text) {
		decriptionLink.click();
		linkText.sendKeys(text);
	}

	public void enterLinkUrl(String url) {
		linkUrl.sendKeys(url);
	}

	public void insertLink() {
		insertLinkBtn.click();
	}

	public void updateChanges() {
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, updateBtn);
		gu.jsExecutorClick(driver, updateBtn);
	}

	public String readAlert() {
		return editSuccessMsg.getText();
	}
}
