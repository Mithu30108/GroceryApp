package utilities;

import java.util.Random;
import java.util.Set;
import java.util.Date;
import java.util.List;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {

	public String getElementText(WebElement element) {
		return element.getText();
	}

	public String getUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void navigateToPage(WebDriver driver, String inUrl) {
		driver.navigate().to(inUrl);
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void dismissAccept(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}

	public void sendKeysAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public boolean verifyisSelected(WebElement element) {
		return (element.isSelected());
	}

	public boolean verifyisDisplayed(WebElement element) {
		return (element.isDisplayed());
	}

	public boolean verifyisEnabled(WebElement element) {
		return (element.isEnabled());
	}

	public void clear(WebElement element) {
		element.clear();
	}

	public void dragAndDropAction(WebDriver driver, WebElement srcElement, WebElement target) {
		Actions obj = new Actions(driver);
		obj.dragAndDrop(srcElement, target).perform();
	}

	public void selectByIndexDropdown(WebElement element, int index) {
		Select obj = new Select(element);
		obj.selectByIndex(index);
	}

	public void selectByValueDropdown(WebElement element, String input) {
		Select obj = new Select(element);
		obj.selectByValue(input);
	}

	public void selectByVisibleTextDropdown(WebElement element, String input) {
		Select obj = new Select(element);
		obj.selectByVisibleText(input);
	}

	public String getSelectedOption(WebElement element) {
		Select obj = new Select(element);
		return obj.getFirstSelectedOption().getText();
	}

	public void selectbyIndexMultiDropdown(WebElement element, int size) {
		Select obj = new Select(element);
		for (int i = 0; i < size; i++) {
			obj.selectByIndex(i);
		}
	}

	public void selectbyValueMultiDropdown(WebElement element, int size) {
		Select obj = new Select(element);
		for (int i = 0; i < size; i++) {
			obj.selectByIndex(i);
		}
	}

	public void getAllSelectedOptions(WebElement element) {
		Select obj = new Select(element);
		List<WebElement> list1 = obj.getAllSelectedOptions();
		for (int j = 0; j < list1.size(); j++) {
			System.out.println(list1.get(j).getText());
		}
	}

	public void fileUploadRobotClass(WebDriver driver, WebElement element, String inputPath) {
		Actions a1 = new Actions(driver);
		a1.moveToElement(element).click().perform();
		StringSelection s1 = new StringSelection(inputPath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s1, null);
		Robot rc = null;
		try {
			rc = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rc.delay(50);
		rc.keyPress(KeyEvent.VK_CONTROL);
		rc.keyPress(KeyEvent.VK_V);
		rc.delay(50);
		rc.keyRelease(KeyEvent.VK_V);
		rc.keyRelease(KeyEvent.VK_CONTROL);
		rc.delay(50);
		rc.keyPress(KeyEvent.VK_ENTER);
		rc.keyRelease(KeyEvent.VK_ENTER);
	}

	public void switchToFrame(WebDriver driver, WebElement iframe) {
		driver.switchTo().frame(iframe);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void doubleClickMouse(WebDriver driver, WebElement element) {
		Actions obj = new Actions(driver);
		obj.doubleClick(element).perform();
	}

	public void mouseHovering(WebDriver driver, WebElement element) {
		Actions obj = new Actions(driver);
		obj.moveToElement(element).perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions obj = new Actions(driver);
		obj.contextClick(element).perform();
	}

	public void CentralAlign(WebDriver driver, WebElement element) {
		Actions a1 = new Actions(driver);
		a1.moveToElement(element).click().perform();
		Robot rc = null;
		try {
			rc = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rc.delay(30);
		rc.keyPress(KeyEvent.VK_CONTROL);
		rc.keyPress(KeyEvent.VK_SHIFT);
		rc.keyPress(KeyEvent.VK_E);
		rc.delay(30);
		rc.keyRelease(KeyEvent.VK_E);
		rc.keyRelease(KeyEvent.VK_SHIFT);
		rc.keyRelease(KeyEvent.VK_CONTROL);

	}

	public void arrowDown(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.sendKeys(Keys.ARROW_DOWN).perform();
	}

	public void arrowUP(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.sendKeys(Keys.ARROW_UP).perform();
	}

	public void arrowLeft(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.sendKeys(Keys.ARROW_LEFT).perform();
	}

	public void arrowRight(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.sendKeys(Keys.ARROW_RIGHT).perform();
	}

	public void keyboardBackSpace(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.sendKeys(Keys.BACK_SPACE).perform();
	}

	public void keyboardDelete(WebDriver driver) {
		Actions obj = new Actions(driver);
		obj.sendKeys(Keys.DELETE).perform();
	}

	public void scrollPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
	}

	public void jsExecutorClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void windowHandling(WebDriver driver, WebElement element) {
		String parentWindow = driver.getWindowHandle();
		element.click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindow : allWindows) {
			if (!parentWindow.equals(childWindow)) {
				driver.switchTo().window(childWindow);
			}
		}
	}

	public int getInti(List<WebElement> myList, String element) {
		int j = 0;
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getText().equals(element)) {
				j = i + 1;
				break;
			}
		}
		return j;
	}

	public int getIntiContainsElement(List<WebElement> myList, String element) {
		int j = 0;
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getText().contains(element)) {
				j = i + 1;
				break;
			}
		}
		return j;
	}

	public void switchWindow(WebDriver driver, String window) {
		driver.switchTo().window(window);
	}

	public int randon(int limit) {
		Random random = new Random();
		int randomNumber = random.nextInt(limit);
		return randomNumber;
	}

	public String generateCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyhhmmss");
		return formatter.format(date);
	}

public String generateCurrentDate() {
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-YYYY");
	return formatter.format(date);
}
}
