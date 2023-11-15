package elementrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtilities;
import utilities.GeneralUtilities;

public class ManageContent {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ManageContent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-edit']")
	WebElement manageContent;
	@FindBy(xpath = "//p[text()='Manage Pages']")
	WebElement managePages;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;
	@FindBy(xpath = "//input[@id='title']")
	WebElement title;
	@FindBy(xpath = "//button[@class='note-btn btn btn-light btn-sm note-btn-bold']")
	WebElement selectBold;
	@FindBy(xpath = "//button[@data-original-title='Paragraph']")
	WebElement paraAlignment;
	@FindBy(xpath = "//button[@data-original-title='Align center (CTRL+SHIFT+E)']")
	WebElement cetreAlignment;
	@FindBy(xpath = "//div[@class='note-editable card-block']")
	WebElement description;
	@FindBy(xpath = "//input[@id='page']")
	WebElement page;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveBtn;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement pageCreatSuccessMsg;
	@FindBy(id = "main_img")
	WebElement imageUpload;
	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateBtn;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement alertFailmsg;

	public void manageContentClick() {
		manageContent.click();
	}

	public void managePagesClick() {
		managePages.click();
	}

	public void newBtnClick() {
		newBtn.click();
	}

	public void newPageTiltle() {
		gu.generateCurrentDateAndTime();
		String titlename = "Test" + gu.generateCurrentDateAndTime();
		title.sendKeys(titlename);
	}

	public void enterFontDetails() {
		selectBold.click();
		gu.CentralAlign(driver, description);
	}

	public void enterDescription(String inText) {
		description.sendKeys(inText);
	}

	public void enterPageDetails(String inText) {
		page.sendKeys(inText + gu.randon(1000));
	}

	public void saveDetails() {
		saveBtn.click();
	}

	public void previousPage() {
		gu.navigateBack(driver);
	}

	public String readPageCreatedMsg() {
		return pageCreatSuccessMsg.getText();
	}

	public void editAddInvalidImage() {
		int i = gu.randon(19);
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i + 1)
				+ "]//td[5]//a[@class='btn btn-sm btn btn-primary btncss']";
		WebElement editIcon = driver.findElement(By.xpath(locator));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, editIcon);
		gu.jsExecutorClick(driver, editIcon);
	}

	public void uploadImage() {
		imageUpload.sendKeys((System.getProperty("user.dir") + "\\src\\main\\resources\\Inputfiles\\ScreenShot.doc"));
	}

	public void updateDetail() {
		updateBtn.click();
	}

	public String readAlertFailMsg() {
		return alertFailmsg.getText();
	}

}
