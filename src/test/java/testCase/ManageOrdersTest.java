package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementrepository.LoginPage;
import elementrepository.ManageOrders;

public class ManageOrdersTest extends BaseClass {
	ManageOrders mo;
	LoginPage lp;

	@Test(enabled = false)
	public void verifyListOrders() {
		lp = new LoginPage(driver);
		lp.login("admin", "admin");
		mo = new ManageOrders(driver);
		mo.manageOrder();
		String expected = "List Orders";
		String actual = mo.readListOrders();
		Assert.assertEquals(actual, expected, Constant.mo_verifyListOrders);
	}

	@Test(enabled = false)
	public void verifyDeleteOrder() {
		lp = new LoginPage(driver);
		mo = new ManageOrders(driver);
		lp.login("admin", "admin");
		mo.manageOrder();
		mo.deleteOrder("282");
		mo.alertAccept();
		String expected = "Alert!";
		String actual = mo.readAlertMsg();
		Assert.assertEquals(actual, expected, Constant.mo_verifyDeleteOrder);
	}

	@Test(enabled = false)
	public void verifySearchOrder() {
		lp = new LoginPage(driver);
		mo = new ManageOrders(driver);
		lp.login("admin", "admin");
		mo.manageOrder();
		mo.deleteOrder("271");
		mo.alertAccept();
		mo.searchClick();
		mo.searchOrder("271");
		mo.searchOdrClick();
		String expected = ".........RESULT NOT FOUND.......";
		String actual = mo.readSearchRslt();
		Assert.assertEquals(actual, expected, Constant.mo_verifyDeleteOrder);
	}

	@Test(enabled = false)
	public void verifyUpdateDelhiveryDate() {
		lp = new LoginPage(driver);
		mo = new ManageOrders(driver);
		lp.login("admin", "admin");
		mo.manageOrder();
		mo.updateDelhiveryDateTime("267");
		mo.updateDate("11/11/2023");
		mo.updateTime("11:00AM", "2:00PM");
		mo.updateDelhiveryDateClick();
		String expected = "×\nAlert!\nDelivery Date Updated Successfully";
		String actual = mo.readAlertMsg();
		Assert.assertEquals(actual, expected, Constant.mo_verifyUpdateDelhiveryDate);
		String expected1 = "11-Nov-2023\n11:00am to 02:00pm";
		String actual1 = mo.readUpdateDisplay("267");
		Assert.assertEquals(actual1, expected1, Constant.mo_verifyUpdateDelhiveryDate1);
	}

	@Test()
	public void verifyUpdateDelhiveryBoy() {
		lp = new LoginPage(driver);
		mo = new ManageOrders(driver);
		lp.login("admin", "admin");
		mo.manageOrder();
		mo.updateDelhiveryBoy("262");
		mo.selectDelhiveryBoy("262");
		String expected1 = mo.getSelectedDBoy();
		mo.updateDelhiveryBoyClick("262");
		mo.searchClick();
		mo.searchOrder("262");
		mo.searchOdrClick();
		String expected = "262";
		String actual = mo.readSearchRsltReturned();
		Assert.assertEquals(actual, expected, Constant.mo_verifyUpdateDelhiveryBoy);
		String actual1 = mo.readSearchRsltDBoy();
		Assert.assertEquals(actual1, expected1, Constant.mo_verifyUpdateDelhiveryBoy1);
	}
}
