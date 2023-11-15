package elementrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageOrders {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();
	WebElement updtDate, delhiveryStrtTime, delhiveryEndTime, updateDeliveryDateIcon, updateDisplay, statusDropDwn;

	public ManageOrders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//p[text()='Manage Orders']")
	WebElement manageOrders;
	@FindBy(xpath = "//h1[text()='List Orders']")
	WebElement listOrders;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alertMsg;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> list;
	@FindBy(xpath = "//div//i[@class=' fa fa-search']")
	WebElement searchOdr;
	@FindBy(xpath = "//div//i[@class='fa fa-search']")
	WebElement searchBtn;
	@FindBy(id = "od")
	WebElement orderId;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//span")
	WebElement searchRslt;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[6]//span[2]")
	WebElement searchRsltDBoy;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement searchRsltReturned;

	public void manageOrder() {
		manageOrders.click();
	}

	public void alertAccept() {
		gu.alertAccept(driver);
	}

	public void readAlert() {
		gu.getAlertText(driver);
	}

	public String readListOrders() {
		return listOrders.getText();

	}

	public String readAlertMsg() {
		return alertMsg.getText();
	}

	public void deleteOrder(String oId) {
		int j = gu.getInti(list, oId);
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + j
				+ "]//td[7]//a[@class='btn btn-sm btn btn-danger btncss']";
		WebElement deletBtn = driver.findElement(By.xpath(locator));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, deletBtn);
		gu.jsExecutorClick(driver, deletBtn);
	}

	public void updateDelhiveryDateTime(String oId) {
		int j = gu.getInti(list, oId);
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + j
				+ "]//td[6]//a[@class='btn btn-primary btn-sm']";
		WebElement changeDelhiveryDate = driver.findElement(By.xpath(locator));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, changeDelhiveryDate);
		gu.jsExecutorClick(driver, changeDelhiveryDate);
		updtDate = driver.findElement(
				By.xpath("//div[@id='mymodal2" + oId + "']//input[@class='jquery-datepicker__input datepicker1']"));
		delhiveryStrtTime = driver.findElement(By.xpath("//div[@id='mymodal2" + oId + "']//input[@id='basicExample']"));
		delhiveryEndTime = driver.findElement(By.xpath("//div[@id='mymodal2" + oId + "']//input[@id='basicExample1']"));
		updateDeliveryDateIcon = driver
				.findElement(By.xpath("//div[@id='mymodal2" + oId + "']//button[@name='Update_st']"));
		updateDisplay = driver.findElement(By.xpath(
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + j + "]//td[6]//span[2]"));
	}

	public void updateDate(String date1) {
		updtDate.clear();
		updtDate.sendKeys(date1);
	}

	public void updateTime(String strtTime, String endTime) {
		delhiveryStrtTime.clear();
		delhiveryStrtTime.sendKeys(strtTime);
		delhiveryEndTime.clear();
		delhiveryEndTime.sendKeys(endTime);
	}

	public void updateDelhiveryDateClick() {
		gu.jsExecutorClick(driver, updateDeliveryDateIcon);
	}

	public void updateDelhiveryBoy(String oId) {
		int j = gu.getInti(list, oId);
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + j
				+ "]//td[6]//a[@class='btn btn-warning btn-sm']";
		WebElement changeDelhiveryBoy = driver.findElement(By.xpath(locator));
		gu.scrollPage(driver);
		wu.elementToBeClickableExpWait(driver, changeDelhiveryBoy);
		gu.jsExecutorClick(driver, changeDelhiveryBoy);
	}

	public void selectDelhiveryBoy(String oId) {
		statusDropDwn = driver.findElement(By.xpath("//div[@id='mymodal3" + oId + "']//select[@id='delivery_boy_id']"));
		gu.selectByIndexDropdown(statusDropDwn, 4);
	}

	public String getSelectedDBoy() {
		return gu.getSelectedOption(statusDropDwn);
	}

	public void updateDelhiveryBoyClick(String oId) {
		WebElement updateDeliverBoyIcon = driver
				.findElement(By.xpath("//div[@id='mymodal3" + oId + "']//button[@name='assign_del']"));
		gu.jsExecutorClick(driver, updateDeliverBoyIcon);
	}

	public void searchClick() {
		searchOdr.click();
	}

	public void searchOdrClick() {
		searchBtn.click();
	}

	public void searchOrder(String oId) {
		orderId.sendKeys(oId);
	}

	public String readUpdateDisplay(String oId) {
		int j = gu.getInti(list, oId);
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + j
				+ "]//td[6]//span[2]";
		WebElement updateDisplay = driver.findElement(By.xpath(locator));
		return updateDisplay.getText();
	}

	public String readSearchRslt() {
		return searchRslt.getText();
	}

	public String readSearchRsltDBoy() {
		return searchRsltDBoy.getText();
	}

	public String readSearchRsltReturned() {
		return searchRsltReturned.getText();
	}
}
