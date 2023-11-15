package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import elementrepository.LoginPage;
import elementrepository.ManageExpense;
import elementrepository.ManageOrders;

public class ManageExpenseTest extends BaseClass {
	LoginPage lp;
	ManageExpense me;
	ManageOrders mo;

	@Test
	public void verifyManageExpense() {
		lp = new LoginPage(driver);
		me = new ManageExpense(driver);
		lp.login("admin", "admin");
		me.manageExpense();
		me.expnsCategory();
		String expected = "Expense Category";
		String actual = me.readExpnsCategory();
		Assert.assertEquals(actual, expected,Constant.me_verifyManageExpense );
	}

	@Test
	public void verifyExpenseCategory() {
		lp = new LoginPage(driver);
		me = new ManageExpense(driver);
		lp.login("admin", "admin");
		me.manageExpense();
		me.expnsCategory();
		String title = me.readTitle();
		me.newBtnClick();
		me.editTitle(title);
		me.save();
		String expected = "×\nAlert!\nCategory already exists.";
		String actual = me.readDuplicateTitleMsg();
		Assert.assertEquals(actual, expected,Constant.me_verifyExpenseCategory);
	}

	@Test
	public void verifyAddListExpense() {
		lp = new LoginPage(driver);
		mo = new ManageOrders(driver);
		me = new ManageExpense(driver);
		lp.login("admin", "admin");
		me.manageExpense();
		me.manageExpenseRadioBtn();
		String expListURl = me.expListUrl();
		me.newBtnClick();
		me.userSelect();
		String userSelected = me.getUserSelected();
		String temp = userSelected.replace("(", "-");
		String temp1 = temp.replace(")", "");
		me.sendExpDate();
		me.selectExpCategory("432");
		String expCategory = me.getExpCategory();
		me.selectExpOrderId("28");
		me.selectExpPurchaseId();
		me.selectExpType("Credit Cash");
		me.selectExpAmount("3000");
		me.save1();
		me.navigateToExpListpg(expListURl);
		me.searchBtnClick();
		me.searchExpTitle(expCategory);
		me.search();
		String expected = expCategory + " " + "(" + temp1 + ")";
		String actual = mo.readSearchRsltReturned();
		Assert.assertEquals(actual, expected, Constant.me_verifyAddListExpense);
	}
}
