package elementrepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.WaitUtilities;

public class ManageExpense {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	WaitUtilities wu = new WaitUtilities();

	public ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);// with page factory
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement manageExpense;
	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expseCategory;
	@FindBy(xpath = "//p[text()='Manage Expense']")
	WebElement manageExpenseRBtn;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newBtn;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchBtn;
	@FindBy(xpath = "//button[@name='Search']")
	WebElement searchBtnClick;
	@FindBy(xpath = "//input[@id='name']")
	WebElement title;
	@FindBy(id = "user_id")
	WebElement user;
	@FindBy(id = "ex_date")
	WebElement expDate;
	@FindBy(id = "ex_cat")
	WebElement expCategory;
	@FindBy(id = "order_id")
	WebElement expOrderId;
	@FindBy(id = "purchase_id")
	WebElement expPurchaseId;
	@FindBy(id = "ex_type")
	WebElement expType;
	@FindBy(id = "amount")
	WebElement expAmount;
	@FindBy(xpath = "//input[@placeholder='Enter the Title']")
	WebElement SearchExpTitile;
	@FindBy(id = "un")
	WebElement titleSearch;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement saveBtn;
	@FindBy(xpath = "//button[@name='create']")
	WebElement saveBtn1;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
	List<WebElement> list;
	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	WebElement duplicateTitleMsg;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	WebElement searchRsltTitle;


	public void manageExpense() {
		manageExpense.click();
	}

	public void expnsCategory() {
		expseCategory.click();
	}

	public void manageExpenseRadioBtn() {
		manageExpenseRBtn.click();
	}

	public String readExpnsCategory() {
		return expseCategory.getText();
	}

	public String readTitle() {	
		int i=gu.randon(list.size()-1);
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + (i+1) + "]//td[1]";
		WebElement expenseTitle = driver.findElement(By.xpath(locator));
		return expenseTitle.getText();

	}

	public void newBtnClick() {
		newBtn.click();
	}

	public void userSelect() {
		gu.selectByIndexDropdown(user, 8);
	}

	public String getUserSelected() {
		return gu.getSelectedOption(user);
	}

	public void sendExpDate() {
		expDate.clear();
		expDate.sendKeys(gu.generateCurrentDate());
	}

	public void selectExpCategory(String inValue) {
		gu.selectByValueDropdown(expCategory, inValue);
	}

	public String getExpCategory() {
		return gu.getSelectedOption(expCategory);
	}

	public void selectExpOrderId(String inValue) {
		gu.selectByVisibleTextDropdown(expOrderId, inValue);
		;
	}

	public void selectExpPurchaseId() {
		int i=gu.randon(100);
		gu.selectByIndexDropdown(expPurchaseId, i+1);
	}

	public void selectExpType(String inValue) {
		gu.selectByVisibleTextDropdown(expType, inValue);
	}

	public void selectExpAmount(String amnt) {
		expAmount.sendKeys(amnt);
	}

	public void editTitle(String expenseTitleName) {
		System.out.println(expenseTitleName);
		title.sendKeys(expenseTitleName);
	}

	public void save() {
		saveBtn.click();
	}

	public void save1() {
		saveBtn1.click();
	}
	public String expListUrl() {
		return driver.getCurrentUrl();
	}

	public void navigateToExpListpg(String url) {
		gu.navigateToPage(driver, url);
	}

	public String readDuplicateTitleMsg() {
		return duplicateTitleMsg.getText();
	}

	public void searchBtnClick() {
		searchBtn.click();
	}

	public void searchExpTitle(String inValue) {
		SearchExpTitile.sendKeys(inValue);
	}

	public void search() {
		searchBtnClick.click();
	}

}
