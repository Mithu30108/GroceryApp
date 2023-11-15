	package elementrepository;
	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
	
	public class ManageSlider {
		WebDriver driver;
		GeneralUtilities gu=new GeneralUtilities();
		public ManageSlider(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);// with page factory
		}
		
		@FindBy(xpath="//p[text()='Manage Slider']")
		WebElement manageSliders;
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[1]")
		WebElement element1;
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tr[1]//td[4]//i[@class='fas fa-edit']")
		WebElement editIcon;
		@FindBy(xpath="//div[@class=' form-group']//input[@id='main_img']")
		WebElement image;
		@FindBy(id="link")
		WebElement link;
		@FindBy(name="update")
		WebElement updateIcon;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']//h5")
		WebElement alertMsg;
		@FindBy(xpath="//span[@class='fas fa-trash-alt']")
		WebElement deleteIcon;
		
		public void manageSlider() {
			manageSliders.click();
		}
	
		public void editElement() {
			editIcon.click();
		}
		
		public void imageUpload(String path) {
			image.sendKeys(path);
		}
		
		public void deleteExistngImage() {
			deleteIcon.click();
		}
		
		public void acceptAlert() {
			gu.alertAccept(driver);
			
		}
		public void updateLink(String lnk) {
			link.clear();
			link.sendKeys(lnk);
		}
		
		public void updateElement() {
			updateIcon.click();
		}
		
		public String readAlertMsg() {
			return alertMsg.getText();	
		}
	}
